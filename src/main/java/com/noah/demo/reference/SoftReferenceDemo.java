package com.noah.demo.reference;

/**
 * Title: SoftReferenceDemo.java <br>
 * Description:             <br>
 * Copyright: Copyright (c) 2015<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author yinzo 2019-09-26
 */

import java.lang.ref.SoftReference;

/**
 * 软引用何时被收集
 * 运行参数 -Xmx200m -XX:+PrintGC
 * Created by ccr at 2018/7/14.
 */
public class SoftReferenceDemo {



    public static void main(String[] args) throws InterruptedException {


        SoftReferenceModel softReferenceModel = new SoftReferenceModel();
        softReferenceModel.setCache();

        System.out.println("对象初始化了" + softReferenceModel.getCache().get());



        //100M的缓存数据
        byte[] cacheData = new byte[100 * 1024 * 1024];

        //将缓存数据用软引用持有
        SoftReference<byte[]> cacheRef = new SoftReference<>(cacheData);

        System.out.println("对象应该被回收了" + softReferenceModel.getCache().get());


        //将缓存数据的强引用去除
        cacheData = null;
        System.out.println("第一次GC前" + cacheData);
        System.out.println("第一次GC前" + cacheRef.get());
        //进行一次GC后查看对象的回收情况
        System.gc();
        //等待GC
        Thread.sleep(500);
        System.out.println("第一次GC后" + cacheData);
        System.out.println("第一次GC后" + cacheRef.get());

        //在分配一个120M的对象，看看缓存对象的回收情况
        byte[] newData = new byte[120 * 1024 * 1024];
        System.out.println("分配后" + cacheData);
        System.out.println("分配后" + cacheRef.get());
        System.gc();
        System.out.println(cacheRef.isEnqueued());
    }

}
