package com.noah.demo.concurrent.customize;

/**
 * Title: BoundedBuffer.java <br>
 * Description:             <br>
 * Copyright: Copyright (c) 2015<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author yinzo 2019-11-15
 */
public class BoundedBuffer<V> extends BaseBoundedBuffer<V> {

    protected BoundedBuffer(int capacity) {
        super(capacity);
    }

    // 条件谓词：not-full (!isFull)
    // 条件谓词：not-empty (!isEmpty)

    // 阻塞并直到：not-full
    public synchronized void put(V v) throws InterruptedException {

        while (isFull()) {
            wait();
        }
        doPut(v);
        notifyAll();
    }

    // 阻塞并直到：not-empty
    public synchronized V take() throws InterruptedException {
        while (isEmpty()) {
            wait();
        }
        V v = doTake();
        notifyAll();
        return v;
    }


}
