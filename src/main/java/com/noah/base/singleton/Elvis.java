package com.noah.base.singleton;

import java.io.Serializable;

/**
 * Elvis.java
 *
 * @author yinzongchang
 * 创建时间 2023/5/29
 * @since 1.0
 */
public class Elvis implements Serializable {

    private static final long serialVersionUID = 2880913153095941918L;

    private static final Elvis INSTANCE = new Elvis();

    private Elvis() {
        if (INSTANCE != null) {
            throw new RuntimeException("实例已经存在，请通过 getInstance()方法获取");
        }
    }

    public static Elvis getInstance() {
        return INSTANCE;
    }

    public void leaveTheBuilding() {
    }

    // readResolve method to preserve singleton property
    private Object readResolve() {
        // Return the one true Elvis and let the garbage collector
        // take care of the Elvis impersonator.
        return INSTANCE;
    }

}
