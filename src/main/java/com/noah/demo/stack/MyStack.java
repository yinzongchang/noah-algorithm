package com.noah.demo.stack;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Title: MyStack.java <br>
 * Description:             <br>
 * Copyright: Copyright (c) 2015<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author yinzo 2022/9/2
 */
public class MyStack {

    Queue<Integer> queue;

    public MyStack() {

        queue = new ArrayDeque<>();
    }

    public void push(int x) {

        int size = queue.size();

        queue.offer(x);

        for (int i = 0; i < size; i++) {
            queue.offer(queue.poll());
        }
    }

    public int pop() {

        return queue.poll();
    }

    public int top() {

        return queue.peek();
    }

    public boolean empty() {

        return queue.isEmpty();
    }


}
