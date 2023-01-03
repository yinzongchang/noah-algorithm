package com.noah.demo.queue;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Title: MaxResult.java <br>
 * Description:             <br>
 * Copyright: Copyright (c) 2015<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author yinzo 2022/9/4
 */
public class MaxResult {


    /**
     * 例 4：捡金币游戏
     * <p>
     * 【题目】给定一个数组 A[]，每个位置 i 放置了金币 A[i]，小明从 A[0] 出发。当小明走到 A[i] 的时候，下一步他可以选择 A[i+1, i+k]（当然，不能超出数组边界）。
     * 每个位置一旦被选择，将会把那个位置的金币收走（如果为负数，就要交出金币）。请问，最多能收集多少金币？
     * <p>
     * 输入：[1,-1,-100,-1000,100,3], k = 2
     * <p>
     * 输出：4
     * <p>
     * 解释：从 A[0] = 1 出发，收获金币 1。下一步走往 A[2] = -100, 收获金币 -100。再下一步走到 A[4] = 100，收获金币 100，最后走到 A[5] = 3，收获金币 3。最多收获 1 - 100 + 100 + 3 = 4。没有比这个更好的走法了。
     */
    public int maxResult(int[] arr, int k) {

        if (arr == null || arr.length == 0 || k <= 0) {
            return 0;
        }

        final int len = arr.length;

        // 每个位置最多可收集的金币个数
        int[] get = new int[len];

        // 单调队列 - 递减队列
        Deque<Integer> deque = new ArrayDeque<>();


        for (int i = 0; i < len; i++) {

            // 类似于滑动窗口，维护窗口内元素
            if (i - k > 0) {
                if (!deque.isEmpty() && deque.peekFirst() == get[i - k - 1]) {
                    deque.removeFirst();
                }
            }

            // 根据 get[] 构建单调队列
            // 队列中获取最大值
            int max = deque.isEmpty() ? 0 : deque.peekFirst();

            // i 位置最多可收集的金币数
            get[i] = max + arr[i];

            while (!deque.isEmpty() && deque.peekLast() < get[i]) {
                deque.removeLast();
            }

            deque.addLast(get[i]);
        }


        return get[len - 1];
    }


    public int maxResult2(int[] arr, int k) {

        if (arr == null || arr.length == 0 || k <= 0) {
            return 0;
        }

        final int len = arr.length;

        // 每个位置最多可收集的金币个数
        int[] get = new int[len];

        // 单调队列 - 递减队列
        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < len; i++) {

            if (i - k > 0) {
                if (!deque.isEmpty() && deque.peekFirst() == (i - k - 1)) {
                    deque.removeFirst();
                }
            }

            // 根据 get[] 构建单调队列
            // 队列中获取最大值
            int max = deque.isEmpty() ? 0 : get[deque.peekFirst()];

            // i 位置最多可收集的金币数
            get[i] = max + arr[i];

            while (!deque.isEmpty() && get[deque.peekLast()] < get[i]) {
                deque.removeLast();
            }

            deque.addLast(i);
        }

        return get[len - 1];
    }


    public static void main(String[] args) {


        int[] arr = {1, -1, -100, -1000, 100, 3};
        System.out.println(new MaxResult().maxResult(arr, 2));
        System.out.println(new MaxResult().maxResult2(arr, 2));


    }

}
