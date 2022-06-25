package com.noah.demo.concurrent.semaphore;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.Semaphore;
import java.util.function.Function;

/**
 * Title: ObjPool.java <br>
 * Description:             <br>
 * Copyright: Copyright (c) 2015<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author yinzo 2019-10-11
 */
public class ObjPool<T, R> {

    final List<T> pool;
    final Semaphore sem; // 用信号量实现限流器

    // 构造函数
    ObjPool(int size, T t) {
        pool = new Vector<T>() {
            private static final long serialVersionUID = 5805651677699256081L;
        };
        for (int i = 0; i < size; i++) {
            pool.add(t);
        }
        sem = new Semaphore(size);
    }

    // 利用对象池的对象，调用 func
    R exec(Function<T, R> func) throws InterruptedException {
        T t = null;
        sem.acquire();
        try {
            t = pool.remove(0);
            return func.apply(t);
        } finally {
            pool.add(t);
            sem.release();
        }
    }


    public static void main(String[] args) {


        // 创建对象池
        ObjPool<Long, String> pool = new ObjPool<>(10, 2L);
        // 通过对象池获取 t，之后执行
        try {
            pool.exec(t -> {
                System.out.println(t);
                return t.toString();
            });
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        Collections.synchronizedList(new ArrayList<>());
    }


}


