package com.noah.design.bridge;

/**
 * Circle.java
 *
 * @author yinzongchang
 * 创建时间 2023/8/1
 * @since 1.0
 */
public class Circle extends Shape {
    private int x, y, radius;

    public Circle(int x, int y, int radius, DrawAPI drawAPI) {
        super(drawAPI);
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    public void draw() {
        drawAPI.drawCircle(radius, x, y);
    }
}
