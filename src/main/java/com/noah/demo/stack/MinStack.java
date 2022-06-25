package com.noah.demo.stack;

import java.util.Stack;

/**
 * Title: MinStack.java <br>
 * Description:             <br>
 * Copyright: Copyright (c) 2015<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author yinzo 2022/6/18
 */
public class MinStack {

    Stack<Integer> stack;

    Stack<Integer> minStack;

    public MinStack() {

        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int val) {

        stack.push(val);

        if (minStack.isEmpty()) {
            minStack.push(val);
        } else {

            int top = minStack.peek();
            minStack.push(Math.min(top, val));
        }
    }

    public void pop() {

        stack.pop();
        minStack.pop();

    }

    public int top() {

        return stack.peek();

    }

    public int getMin() {

        return minStack.peek();
    }

}
