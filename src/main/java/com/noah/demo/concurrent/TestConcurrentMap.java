package com.noah.demo.concurrent;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Title: TestConcurrentMap.java <br>
 * Description:             <br>
 * Copyright: Copyright (c) 2015<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author yinzo 2019-10-20
 */
public class TestConcurrentMap {

    public static void main(String[] args) {


        ConcurrentHashMap<Integer, Integer> concurrentHashMap = new ConcurrentHashMap<>();

        System.out.println(concurrentHashMap.putIfAbsent(1, 1));
        System.out.println(concurrentHashMap.putIfAbsent(1, 2));

    }

}
