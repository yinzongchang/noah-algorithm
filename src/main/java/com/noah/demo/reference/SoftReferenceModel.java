package com.noah.demo.reference;

import java.lang.ref.SoftReference;

/**
 * Title: SoftReferenceModel.java <br>
 * Description:             <br>
 * Copyright: Copyright (c) 2015<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author yinzo 2019-09-30
 */
public class SoftReferenceModel {

    private SoftReference<byte[]> cache;

    public void setCache() {

        byte[] cacheData = new byte[100 * 1024 * 1024];
        cache = new SoftReference<>(cacheData);
    }

    public SoftReference<byte[]> getCache() {
        return cache;
    }

}
