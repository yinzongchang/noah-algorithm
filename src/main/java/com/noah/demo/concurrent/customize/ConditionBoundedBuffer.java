package com.noah.demo.concurrent.customize;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Title: ConditionBoundedBuffer.java <br>
 * Description:             <br>
 * Copyright: Copyright (c) 2015<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author yinzo 2019-11-15
 */
public class ConditionBoundedBuffer<T> {

    private final int BUFFER_SIZE = 100;

    protected final Lock lock = new ReentrantLock();

    // 条件谓词：notFull (count < items.length)
    private final Condition notFull = lock.newCondition();

    // 条件谓词：notEmpty (count > 0)
    private final Condition notEmpty = lock.newCondition();

    private final T[] items = (T[]) new Object[BUFFER_SIZE];

    private int tail, head, count;

    // 阻塞并直到：notFull
    public void put(T x) throws InterruptedException {
        lock.lock();
        try {
            while (count == items.length) {
                notFull.await();
            }
            items[tail] = x;
            if (++tail == items.length) {
                tail = 0;
            }
            ++count;
            notEmpty.signal();
        } finally {
            lock.unlock();
        }
    }

    // 阻塞并直到：notEmpty
    public T take() throws InterruptedException {
        lock.lock();
        try {
            while (count == 0) {
                notEmpty.await();
            }
            T x = items[head];
            items[head] = null;
            if (++head == items.length) {
                head = 0;
            }
            --count;
            notFull.signal();
            return x;
        } finally {
            lock.unlock();
        }
    }

}
