package com.noah.demo.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Title: TestThreadPrint3_1.java <br>
 * Description:             <br>
 * Copyright: Copyright (c) 2015<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author yinzo 2022/7/30
 */
public class TestThreadPrint3_1 {


    public static void main(String[] args) {


        ReentrantLock reentrantLock = new ReentrantLock();

        Condition condition1 = reentrantLock.newCondition();
        Condition condition2 = reentrantLock.newCondition();
        Condition condition3 = reentrantLock.newCondition();


        Runnable runnable1 = new Runnable() {

            @Override
            public void run() {

                reentrantLock.lock();

                try {
                    for (int i = 0; i < 10; i++) {

                        System.out.println(Thread.currentThread().getName() + " A " + i);

                        condition2.signalAll();
                        condition1.await();
                    }

                    condition2.signalAll();
                } catch (Exception e) {
                    e.printStackTrace();

                } finally {
                    reentrantLock.unlock();
                }
            }
        };

        Runnable runnable2 = new Runnable() {
            @Override
            public void run() {

                reentrantLock.lock();

                try {
                    for (int i = 0; i < 10; i++) {

                        System.out.println("B" + i);

                        condition3.signalAll();
                        condition2.await();
                    }

                    condition3.signalAll();
                } catch (Exception e) {
                    e.printStackTrace();

                } finally {
                    reentrantLock.unlock();
                }

            }
        };


        Runnable runnable3 = new Runnable() {
            @Override
            public void run() {
                reentrantLock.lock();

                try {
                    for (int i = 0; i < 10; i++) {

                        System.out.println("C" + i);

                        condition1.signal();
                        condition3.await();
                    }

                    condition1.signalAll();
                } catch (Exception e) {
                    e.printStackTrace();

                } finally {
                    reentrantLock.unlock();
                }

            }
        };


        Thread thread1 = new Thread(runnable1);
        Thread thread2 = new Thread(runnable2);
        Thread thread3 = new Thread(runnable3);

        Thread thread4 = new Thread(runnable1);

        thread1.start();
        thread4.start();

        thread2.start();
        thread3.start();



    }

}
