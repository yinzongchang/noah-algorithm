package com.noah.demo.concurrent;

/**
 * Title: VolatileExample.java <br>
 * Description:             <br>
 * Copyright: Copyright (c) 2015<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author yinzo 2019-09-06
 */
public class VolatileExample {

    int x = 0;
    volatile boolean v = false;

    public void writer() {
        x = 42;
        v = true;
    }

    public void reader() {
        if (v == true) {
            // 这里 x 会是多少呢？
        }
    }





    public static void main(String[] args) throws InterruptedException {


        VolatileExample example = new VolatileExample();

        Thread threadA = new Thread(example::writer);
        Thread threadB = new Thread(example::writer);

        Thread threadC = new Thread(() -> {
            example.reader();
        });
        Thread threadD = new Thread(() -> {
            example.reader();
        });

        threadC.start();
        threadD.start();
        threadA.start();
        threadB.start();

        threadA.join();
        System.out.println(example.x);
        threadC.join();
        threadD.join();

        threadB.join();

    }
}
