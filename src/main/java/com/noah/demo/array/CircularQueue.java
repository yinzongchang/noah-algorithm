package com.noah.demo.array;

/**
 * Title: CircularQueue.java <br>
 * Description:             <br>
 * Copyright: Copyright (c) 2015<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author yinzo 2022/5/21
 */
public class CircularQueue {

    // 数组，大小为n
    private String[] items;

    private int n;

    /**
     * head表示队头，tail表示队尾巴
     */
    private int head = 0;

    private int tail = 0;

    // 申请大小为capacity 的数组

    public CircularQueue(int capacity) {

        items = new String[capacity];
        n = capacity;
    }

    /**
     * 入队
     *
     * @param item
     * @return
     */
    public boolean enqueue(String item) {

        // 如果队列满了
        if ((tail + 1) % n == head) {
            return false;
        }

        items[tail] = item;
        tail = (tail + 1) % n;
        return true;
    }

    /**
     * 出队
     *
     * @return
     */
    public String dequeue() {

        // 如果队列唯恐
        if (head == tail) {

            return null;
        }

        String result = items[head];
        head = (head + 1) % n;
        return result;
    }


}
