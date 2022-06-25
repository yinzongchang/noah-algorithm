package com.noah.demo.thread;

import org.junit.Test;

/**
 * Title: TestThread.java <br>
 * Description:             <br>
 * Copyright: Copyright (c) 2015<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author yinzo 2022/4/19
 */
public class TestThread {

    private static final Object object = new Object();

    private static int i = 0;


    public static void main(String[] args) {


        Thread thread1 = new Thread(() -> {
            while (true) {

                synchronized (object) {

                    if (i % 2 == 0) {
                        System.out.println(Thread.currentThread().getName() + " ====== " + i);
                        i++;
                    }
                    object.notifyAll();
                }
            }


        });

        Thread thread2 = new Thread(() -> {
            while (true) {

                synchronized (object) {
                    if (i % 2 != 0) {
                        System.out.println(Thread.currentThread().getName() + " ====== " + i);
                        i++;
                    }

                    object.notifyAll();
                }
            }
        });

        thread1.start();
        thread2.start();
    }

    @Test
    public void test2() {



    }


}
