package com.noah.demo.queue;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Title: MaxQueue.java <br>
 * Description:             <br>
 * Copyright: Copyright (c) 2015<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author yinzo 2022/7/6
 */
public class MaxQueue {

    Queue<Integer> queue;
    Deque<Integer> maxQueue;

    public MaxQueue() {

        queue = new LinkedList<>();
        maxQueue = new LinkedList<>();
    }

    public int max_value() {

        if (maxQueue.isEmpty()) {
            return -1;
        }

        return maxQueue.peekFirst();
    }

    /**
     * 必须使用双端队列
     * <p>
     * 原队列  [4, 0, 2, 3]
     * 最大队列 [4, 3]
     */
    public void push_back(int value) {

        queue.offer(value);

        while (!maxQueue.isEmpty() && value > maxQueue.peekLast()) {
            maxQueue.pollLast();
        }

        maxQueue.offerLast(value);
    }

    public int pop_front() {

        if (queue.isEmpty()) {
            return -1;
        }

        int value = queue.poll();
        if (!maxQueue.isEmpty() && maxQueue.peekFirst() == value) {
            maxQueue.pollFirst();
        }

        return value;
    }

}
