package com.noah.demo.cache.lfu;

/**
 * Title: TestLFU.java <br>
 * Description:             <br>
 * Copyright: Copyright (c) 2015<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author yinzo 2022/9/2
 */
public class TestLFU {

    public static void main(String[] args) {

        LFUCache lfuCache = new LFUCache(2);

        lfuCache.put(1, 1);
        lfuCache.put(2, 2);

        System.out.println(lfuCache.get(1));

        lfuCache.put(3, 3);

        System.out.println(lfuCache.get(2));
        System.out.println(lfuCache.get(3));

        lfuCache.put(4, 4);
        System.out.println(lfuCache.get(1));
        System.out.println(lfuCache.get(3));
        System.out.println(lfuCache.get(4));


    }

}
