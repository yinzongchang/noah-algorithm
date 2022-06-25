package com.noah.demo.concurrent.latch;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * Title: Preloader.java <br>
 * Description:             <br>
 * Copyright: Copyright (c) 2015<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author yinzo 2019-10-20
 */
public class Preloader {

    private final FutureTask<ProductInfo> futureTask = new FutureTask<ProductInfo>(new Callable<ProductInfo>() {

        @Override
        public ProductInfo call() throws Exception {

            return null;
        }
    });

    private final Thread thread = new Thread(futureTask);

    public void start() {
        thread.start();
    }

    public ProductInfo get() throws InterruptedException {

        try {
            return futureTask.get();
        } catch (ExecutionException e) {
            Throwable cause = e.getCause();
//            if (cause instanceof Throwable) {
//            }
            throw launderThrowable(cause);
        }

    }


    public static RuntimeException launderThrowable (Throwable t) {

        if (t instanceof RuntimeException) {
            return (RuntimeException) t;
        } else if (t instanceof Error) {
            throw (Error) t;
        } else {
            throw new IllegalStateException("Not unchecked", t);
        }

    }

}
