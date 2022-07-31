package com.noah.demo.thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

/**
 * Title: TestThreadPrint3_2.java <br>
 * Description:             <br>
 * Copyright: Copyright (c) 2015<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author yinzo 2022/7/30
 */
public class TestThreadPrint3_2 {


    public static void main(String[] args) throws InterruptedException {

        Semaphore semaphore1 = new Semaphore(1);
        Semaphore semaphore2 = new Semaphore(1);
        Semaphore semaphore3 = new Semaphore(1);

        semaphore2.acquire();
        semaphore3.acquire();


        Runnable runnable1 = new Runnable() {
            @Override
            public void run() {

                for (int i = 0; i < 10; i++) {

                    try {
                        semaphore1.acquire();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                    System.out.println(Thread.currentThread().getName() + " A " + i);
                    semaphore2.release();
                }

            }
        };

        Runnable runnable2 = new Runnable() {
            @Override
            public void run() {

                for (int i = 0; i < 10; i++) {

                    try {
                        semaphore2.acquire();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                    System.out.println(Thread.currentThread().getName() + " B " + i);
                    semaphore3.release();
                }

            }
        };

        Runnable runnable3 = new Runnable() {
            @Override
            public void run() {


                for (int i = 0; i < 10; i++) {

                    try {
                        semaphore3.acquire();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                    System.out.println(Thread.currentThread().getName() + " C " + i);
                    semaphore1.release();
                }

            }
        };

        Thread thread1 = new Thread(runnable1);
        Thread thread2 = new Thread(runnable2);
        Thread thread3 = new Thread(runnable3);

        thread1.start();
        thread2.start();
        thread3.start();

    }


}
