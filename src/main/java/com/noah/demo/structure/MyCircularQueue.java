package com.noah.demo.structure;

/**
 * Title: MyCircularQueue.java <br>
 * Description:             <br>
 * Copyright: Copyright (c) 2015<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author yinzo 2022/8/2
 */
public class MyCircularQueue {

    // 头节点
    private int front;

    // 尾节点
    private int rear;

    // 容量
    private final int capacity;

    // 存储元素数组
    private final int[] elements;


    public MyCircularQueue(int k) {

        this.capacity = k + 1;
        this.elements = new int[capacity];
        this.front = 0;
        this.rear = 0;
    }


    /**
     * 在队列的尾部插入一个元素，并同时将队尾的索引 rear 更新为 (rear + 1) % capacity。
     *
     * @param value
     * @return
     */
    public boolean enQueue(int value) {

        if (isFull()) {
            return false;
        }

        elements[rear] = value;

        rear = (rear + 1) % capacity;
        return true;
    }


    /**
     * 出队 - 返回队首元素
     *
     * @return
     */
    public boolean deQueue() {

        if (isEmpty()) {
            return false;
        }

        front = (front + 1) % capacity;
        return true;
    }

    /**
     * 返回队首的元素，需要检测队列是否为空
     *
     * @return
     */
    public int front() {

        if (isEmpty()) {
            return -1;
        }

        return elements[front];
    }


    /**
     * 返回队尾元素
     *
     * @return
     */
    public int rear() {

        if (isEmpty()) {
            return -1;
        }

        return elements[(rear - 1 + capacity) % capacity];
    }


    private boolean isFull() {

        return (this.rear + 1) % this.capacity == this.front;
    }

    private boolean isEmpty() {

        return this.front == this.rear;
    }


}
