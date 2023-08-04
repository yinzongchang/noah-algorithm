package com.noah.design.bridge;

/**
 * BridgePatternDemo.java
 *
 * @author yinzongchang
 * 创建时间 2023/8/1
 * @since 1.0
 * 
 */
public class BridgePatternDemo {


    public static void main(String[] args) {

        Shape redCircle = new Circle(100, 100, 10, new RedCircle());
        Shape greenCircle = new Circle(100, 100, 10, new GreenCircle());

        redCircle.draw();
        greenCircle.draw();
    }
}
