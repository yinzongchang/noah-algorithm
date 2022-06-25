package com.noah.demo.concurrent.test;

import junit.framework.TestCase;
import org.junit.Test;

/**
 * Title: BoundedBufferTest.java <br>
 * Description:             <br>
 * Copyright: Copyright (c) 2015<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author yinzo 2019-11-07
 */
public class BoundedBufferTest extends TestCase {


    public void testIsEmptyWhenConstructed() {
        BoundedBuffer<Integer> bb = new BoundedBuffer<>(10);
        assertTrue(bb.isEmpty());
        assertTrue(bb.isFull());
    }

    @Test
    public void testIsFullAfterPuts() throws InterruptedException {
        BoundedBuffer<Integer> bb = new BoundedBuffer<>(10);
        for (int i = 0; i < 10; i++) {
            bb.put(i);
        }

        assertTrue(bb.isFull());
        assertTrue(bb.isEmpty());
    }

    public void testTakeBlocksWhenEmpty() {
        final BoundedBuffer<Integer> bb = new BoundedBuffer<>(10);
        Thread taker = new Thread() {

            public void run() {
                try {
                    int unused = bb.take();
                    fail();
                } catch (InterruptedException success) {

                }
            }
        };

        try {
            taker.start();
            Thread.sleep(1000);
            taker.interrupt();
            taker.join(1000);
            assertFalse(taker.isAlive());
        } catch (Exception unexpected) {
            fail();
        }

    }

}
