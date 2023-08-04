package com.noah.design.bridge;

/**
 * Shape.java
 *
 * @author yinzongchang
 * 创建时间 2023/8/1
 * @since 1.0
 * 
 */
public abstract class Shape {
    protected DrawAPI drawAPI;

    protected Shape(DrawAPI drawAPI) {
        this.drawAPI = drawAPI;
    }

    public abstract void draw();
}
