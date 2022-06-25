package com.noah.demo.thread;

/**
 * Title: Print.java <br>
 * Description:             <br>
 * Copyright: Copyright (c) 2015<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author yinzo 2022/4/20
 */
public class Print {

    boolean currentA = true;


    public synchronized void printA() {

        while (!currentA) {

            try {
                this.wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }

        System.out.println(Thread.currentThread().getName() + " === " + "printA");
        currentA = false;
        this.notifyAll();
    }


    public synchronized void printB() {

        while (currentA) {

            try {
                this.wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println(Thread.currentThread().getName() + " === " + "printB");
        currentA = true;
        this.notifyAll();

    }


    public static void main(String[] args) {

        Print print = new Print();

        Thread thread1 = new Thread(() -> {

           for (int i = 0; i < 10; i++) {
               print.printA();
           }

        });


        Thread thread2 = new Thread(() -> {

            for (int i = 0; i < 10; i++) {
                print.printB();
            }

        });

        thread1.start();
        thread2.start();

    }


}
