package com.noah.demo.stack;

import org.junit.Test;

import java.util.Stack;

/**
 * Title: MinStack.java <br>
 * Description:             <br>
 * Copyright: Copyright (c) 2015<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * https://blog.csdn.net/javalingyu/article/details/124842167
 *
 * @author yinzo 2022/6/17
 */
public class MinStack2 {

    Stack<Integer> stack;

    int min = 0;

    public MinStack2() {

        stack = new Stack<>();
    }

    public void push(int val) {

        // 初始值
        if (stack.isEmpty()) {
            min = val;
            stack.push(0);
            return;
        }

        int x = val - min;

        // 小于最小值
        if (x < 0) {
            min = val;
        }

        stack.push(x);

    }

    public void pop() {

        int top = stack.peek();

        // 栈顶是最小值
        if (top < 0) {
            min = min - top;
        }

        stack.pop();
    }

    public int top() {

        int top = stack.peek();

        int preMin = min;
        // 栈顶是最小值
        if (top < 0) {
            preMin = min - top;
        }

        return preMin + top;
    }

    public int getMin() {

        int top = stack.peek();
        return min;
    }


    @Test
    public void test() {

        MinStack2 minStack = new MinStack2();
        minStack.push(2);
        minStack.push(1);
        minStack.push(3);
        minStack.push(0);

        System.out.println(minStack.top());
        minStack.pop();
        System.out.println(minStack.top());
        minStack.pop();
        System.out.println(minStack.top());
        minStack.pop();
        System.out.println(minStack.top());

    }

}
