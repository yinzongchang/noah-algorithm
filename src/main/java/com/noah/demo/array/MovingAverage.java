package com.noah.demo.array;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Title: MovingAverage.java <br>
 * Description:             <br>
 * Copyright: Copyright (c) 2015<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author yinzo 2022/7/16
 */
public class MovingAverage {

    private int size;

    private double sum;

    private Queue<Integer> queue;

    /**
     * Initialize your data structure here.
     */
    public MovingAverage(int size) {


        this.size = size;
        sum = 0;
        queue = new ArrayDeque<>(size);
    }

    public double next(int val) {

        if (queue.size() == size) {
            sum -= queue.poll();
        }

        queue.offer(val);
        sum += val;
        return sum / queue.size();

    }

}
