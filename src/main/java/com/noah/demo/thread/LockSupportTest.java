package com.noah.demo.thread;

import java.util.concurrent.locks.LockSupport;

/**
 * Title: LockSupportTest.java <br>
 * Description:             <br>
 * Copyright: Copyright (c) 2015<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author yinzo 2022/4/20
 */
public class LockSupportTest {


    static int i = 0;

    static Thread t1 = null;
    static Thread t2 = null;


    public static void main(String[] args) {

        t1 = new Thread(() -> {

            while (true) {

                LockSupport.park();

                System.out.println(Thread.currentThread().getName() + " === " + i);
                i++;

                LockSupport.unpark(t2);

                if (i >= 10) {
                    return;
                }
            }

        });


        t2 = new Thread(() -> {

            while (true) {

                LockSupport.park();

                System.out.println(Thread.currentThread().getName() + " === " + i);
                i++;

                LockSupport.unpark(t1);
                if (i >= 10) {
                    return;
                }

            }
        });

        t1.start();
        t2.start();

        LockSupport.unpark(t1);


    }



}
