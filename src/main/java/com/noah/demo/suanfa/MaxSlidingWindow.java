package com.noah.demo.suanfa;

import org.junit.Test;

import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * Title: MaxSlidingWindow.java <br>
 * Description:             <br>
 * Copyright: Copyright (c) 2015<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author yinzo 2021/11/7
 */
public class MaxSlidingWindow {


    @Test
    public void test() {

        new MaxSlidingWindow().maxSlidingWindow2(new int[]{1, -1}, 1);

    }

    public int[] maxSlidingWindow(int[] nums, int k) {

        int n = nums.length;

        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] != o2[1] ? o2[0] - o1[0] : o2[1] - o1[1];
            }
        });

        for (int i = 0; i < k; i++) {

            priorityQueue.offer(new int[]{nums[i], i});
        }

        int[] ans = new int[n - k + 1];
        ans[0] = priorityQueue.peek()[0];

        for (int i = k; i < n; i++) {

            priorityQueue.offer(new int[]{nums[i], i});
            while (priorityQueue.peek()[1] <= i - k) {
                priorityQueue.poll();
            }
            ans[i - k + 1] = priorityQueue.peek()[0];
        }

        return ans;
    }


    public int[] maxSlidingWindow2(int[] nums, int k) {

        int n = nums.length;

        // 维护一个队列
        Deque<Integer> deque = new LinkedList<>();

        for (int i = 0; i < k; i++) {

            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                deque.pollLast();
            }

            deque.offerLast(i);
        }

        int[] ans = new int[n - k + 1];
        ans[0] = nums[deque.peekFirst()];

        for (int i = k; i < n; i++) {

            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                deque.pollLast();
            }

            deque.offerLast(i);

            while (deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }

            ans[i - k + 1] = nums[deque.peekFirst()];

        }

        return ans;
    }

}
