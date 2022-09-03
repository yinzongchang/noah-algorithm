package com.noah.demo.cache.lru;

/**
 * Title: TestLRUCache.java <br>
 * Description:             <br>
 * Copyright: Copyright (c) 2015<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author yinzo 2022/9/2
 */
public class TestLRUCache {


    public static void main(String[] args) {

        LRUCache lruCache = new LRUCache(2);

        lruCache.put(1, 1);
        lruCache.put(2, 2);

        System.out.println(lruCache.get(1));

        lruCache.put(3, 3);

        System.out.println(lruCache.get(2));

    }
}
