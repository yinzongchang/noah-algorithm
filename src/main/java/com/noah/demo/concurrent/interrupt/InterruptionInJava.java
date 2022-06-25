package com.noah.demo.concurrent.interrupt;

/**
 * Title: InterruptionInJava.java <br>
 * Description:             <br>
 * Copyright: Copyright (c) 2015<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author yinzo 2019-10-29
 */
public class InterruptionInJava implements Runnable {

    private volatile static boolean on = false;

    /**
     * When an object implementing interface <code>Runnable</code> is used
     * to create a thread, starting the thread causes the object's
     * <code>run</code> method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method <code>run</code> is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
    @Override
    public void run() {

//        try {
//            Thread.sleep(5000L);
//        } catch (InterruptedException e) {
//
//            System.out.println("进入中断标记：" + Thread.currentThread().isInterrupted());
//            Thread.currentThread().interrupt();
//
//            System.out.println("重置中断标记：" + Thread.currentThread().isInterrupted());
//            e.printStackTrace();
//        }

//        while (true) {
//            if (Thread.currentThread().isInterrupted()) {
//                try {
//                    Thread.sleep(50L);
//                } catch (InterruptedException e) {
//
//                    System.out.println("正常中断标记：" + Thread.currentThread().isInterrupted());
//
//
//                    Thread.currentThread().interrupt();
//                    e.printStackTrace();
//                }
//                System.out.println("Yes,I am interruted,but I am still running");
//                return;
//
//            } else {
//                try {
//                    Thread.sleep(5000L);
//                } catch (InterruptedException e) {
//
//                    System.out.println("异常中断标记：" + Thread.currentThread().isInterrupted());
//                    Thread.currentThread().interrupted();
//                    e.printStackTrace();
//                }
//                System.out.println("not yet interrupted");
//            }
//        }

        while (!on) {

            try {
                Thread.sleep(10000000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("caught exception: " + e);

            }
        }


    }


    public static void main(String[] args) throws InterruptedException {

//        Thread testThread = new Thread(new InterruptionInJava(), "InterruptionInJava");
//        //start thread
//        testThread.start();
//        Thread.sleep(1000);
//        //interrupt thread
//        testThread.interrupt();
//
//        System.out.println("main end");

        Thread testThread = new Thread(new InterruptionInJava(),"InterruptionInJava");
        //start thread
        testThread.start();
        Thread.sleep(1000);
        InterruptionInJava.on = true;
        testThread.interrupt();

        System.out.println("InterruptionInJava 中断标识：" + testThread.isInterrupted());

        System.out.println("main end");


    }
}
