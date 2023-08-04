package com.noah.design.bridge;

/**
 * RedCircle.java
 *
 * @author yinzongchang
 * 创建时间 2023/8/1
 * @since 1.0
 * 
 */
public class RedCircle implements DrawAPI {
    @Override
    public void drawCircle(int radius, int x, int y) {
        System.out.println("Drawing Circle[ color: red, radius: "
                + radius + ", x: " + x + ", " + y + "]");
    }
}