package com.noah.thread;

import java.util.concurrent.atomic.AtomicLong;

/**
 * TestAtomic.java
 *
 * @author yinzongchang
 * 创建时间 2023/2/21
 * @since 1.0
 */
public class TestAtomic {

    public static void main(String[] args) {

        AtomicLong atomicLong = new AtomicLong(1L);

        atomicLong.getAndIncrement();

        System.out.println(atomicLong.get());


    }

}
