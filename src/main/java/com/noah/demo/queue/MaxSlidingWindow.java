package com.noah.demo.queue;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Title: MaxSlidingWindow.java <br>
 * Description:             <br>
 * Copyright: Copyright (c) 2015<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author yinzo 2022/6/30
 */
public class MaxSlidingWindow {

    public int[] maxSlidingWindow(int[] nums, int k) {

        int len = nums.length;

        if (len == 0 || k == 0) {
            return new int[0];
        }

        Deque<Integer> deque = new LinkedList<>();

        for (int i = 0; i < k; i++) {

            while (!deque.isEmpty() && nums[i] > nums[deque.peekLast()]) {
                deque.pollLast();
            }

            deque.offerLast(i);
        }

        int[] ans = new int[len - k + 1];
        ans[0] = nums[deque.peekFirst()];

        for (int i = k; i < len; i++) {

            while (!deque.isEmpty() && nums[i] > nums[deque.peekLast()]) {
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
