package com.noah.demo.thread;

/**
 * Title: TestABCHolder.java <br>
 * Description:             <br>
 * Copyright: Copyright (c) 2015<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author yinzo 2022/7/30
 */
public class TestABCHolder {

    private int count = 0;


    public void printA() throws InterruptedException {


        synchronized (this) {

            while (count % 3 != 0) {

                this.wait();
            }

            System.out.println(Thread.currentThread().getName() + " A ");
            count++;

            this.notifyAll();
        }
    }

    public void printB() throws InterruptedException {


        synchronized (this) {

            while (count % 3 != 1) {

                this.wait();
            }

            System.out.println(Thread.currentThread().getName() + " B ");
            count++;

            this.notifyAll();
        }
    }

    public void printC() throws InterruptedException {


        synchronized (this) {

            while (count % 3 != 2) {

                this.wait();
            }

            System.out.println(Thread.currentThread().getName() + " C ");
            count++;

            this.notifyAll();
        }
    }

    public static void main(String[] args) {

        TestABCHolder abcHolder = new TestABCHolder();

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {

                for (int i = 0; i < 10; i++) {
                    try {
                        abcHolder.printA();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {

                for (int i = 0; i < 10; i++) {
                    try {
                        abcHolder.printB();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        });

        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {

                for (int i = 0; i < 10; i++) {
                    try {
                        abcHolder.printC();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        });

        thread1.start();
        thread2.start();
        thread3.start();


    }

}
