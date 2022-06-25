package com.noah.demo.cache;

import org.junit.Test;

/**
 * Title: TestLRU.java <br>
 * Description:             <br>
 * Copyright: Copyright (c) 2015<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author yinzo 2022/5/21
 */
public class TestLRU {


    @Test
    public void test() {


        LRUCache lruCache = new LRUCache(2);

        lruCache.put(1, 1);
        lruCache.put(2, 2);
        lruCache.get(1);
        lruCache.put(3, 3);

    }
}
