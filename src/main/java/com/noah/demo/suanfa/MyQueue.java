package com.noah.demo.suanfa;

import java.util.Stack;

/**
 * Title: MyQueue.java <br>
 * Description:             <br>
 * Copyright: Copyright (c) 2015<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author yinzo 2021/11/7
 */
public class MyQueue {

    private Stack<Integer> s1;

    private Stack<Integer> s2;

    private int front;


    public MyQueue() {

        s1 = new Stack<>();
        s2 = new Stack<>();
    }

    public void push(int x) {

        if (s1.empty()) {
            front = x;
        }

        while (!s1.isEmpty()) {
            s2.push(s1.pop());
        }

        s2.push(x);
        while (!s2.isEmpty()) {
            s1.push(s2.pop());
        }


    }

    public int pop() {

        int x = s1.pop();
        if (!s1.isEmpty()) {
            front = s1.peek();
        }

        return x;
    }

    public int peek() {

//        if (!s1.isEmpty()) {
//            return s1.peek();
//        }

        return front;
    }

    public boolean empty() {

        return s1.isEmpty();
    }


}
