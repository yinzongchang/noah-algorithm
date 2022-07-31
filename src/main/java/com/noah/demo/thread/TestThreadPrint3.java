package com.noah.demo.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Title: TestThreadPrint3.java <br>
 * Description:             <br>
 * Copyright: Copyright (c) 2015<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author yinzo 2022/7/28
 */
public class TestThreadPrint3 {


    public static void main(String[] args) {


        ReentrantLock reentrantLock = new ReentrantLock();

        Condition condition1 = reentrantLock.newCondition();
        Condition condition2 = reentrantLock.newCondition();
        Condition condition3 = reentrantLock.newCondition();

        Thread thread1 = new Thread(new Runnable() {

            @Override
            public void run() {

                reentrantLock.lock();

                try {
                    for (int i = 0; i < 10; i++) {

                        System.out.println("A" + i);

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
        });

        Thread thread2 = new Thread(new Runnable() {

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
        });

        Thread thread3 = new Thread(new Runnable() {

            @Override
            public void run() {

                reentrantLock.lock();

                try {
                    for (int i = 0; i < 10; i++) {

                        System.out.println("C" + i);

                        condition1.signalAll();
                        condition3.await();
                    }

                    condition1.signalAll();
                } catch (Exception e) {
                    e.printStackTrace();

                } finally {
                    reentrantLock.unlock();
                }

            }
        });

        thread1.start();
        thread2.start();
        thread3.start();



    }


}
