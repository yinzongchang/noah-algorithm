package com.noah.demo.limiter;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Title: TestSimpleLimiter.java <br>
 * Description:             <br>
 * Copyright: Copyright (c) 2015<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author yinzo 2022/6/20
 */
public class TestSimpleLimiter2 {


    public static void main(String[] args) {


        SimpleLimiter2 simpleLimiter = new SimpleLimiter2();

        ExecutorService executorService = new ThreadPoolExecutor(
                10,
                10,
                0,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(100));

        for (int i = 0; i < 30; i++) {

            long start = System.nanoTime();
            AtomicLong startAtomic = new AtomicLong(start);

//            if (i % 5 == 0) {
//
//                try {
//                    TimeUnit.SECONDS.sleep(5);
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
//
//            }

            int finalI = i;
            simpleLimiter.acquire();

            executorService.submit(() -> {

                long end = System.nanoTime();

//                System.out.println(Thread.currentThread().getName() + "提交任务" + finalI + "===" + (end - start) / 1000000);
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                System.out.println(Thread.currentThread().getName() + "完成任务" + finalI + "===" + (end - startAtomic.get()) / 1000000);
                startAtomic.set(end);
            });

        }


    }


}
