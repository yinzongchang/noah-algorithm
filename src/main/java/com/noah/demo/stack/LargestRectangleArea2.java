package com.noah.demo.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Title: LargestRectangleArea2.java <br>
 * Description:             <br>
 * Copyright: Copyright (c) 2015<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author yinzo 2022/8/30
 */
public class LargestRectangleArea2 {

    /**
     * 84. 柱状图中最大的矩形
     * <p>
     * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
     * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
     * <p>
     * 输入：heights = [2,1,5,6,2,3]
     * 输出：10
     * 解释：最大的矩形为图中红色区域，面积为 10
     * <p>
     * https://leetcode.cn/problems/largest-rectangle-in-histogram/
     *
     * @param heights
     * @return
     */
    public int largestRectangleArea(int[] heights) {

        // 如果为空，直接返回0
        if (heights == null || heights.length == 0) {

            return 0;
        }

        // 长度为1，直接返回
        if (heights.length == 1) {
            return heights[0];
        }

        // 最大面积
        int maxArea = 0;


        // 数组长度
        int len = heights.length;

        // 单调递增栈 - 面积 = 长 * 宽，取决于最短边
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < len; i++) {


            // 当前的栈小于栈顶元素，这个时候要开始计算面积
            while (!stack.isEmpty() && heights[stack.peekLast()] > heights[i]) {


                // 单调栈 - 栈顶
                int height = heights[stack.pollLast()];

                // 高度相同的同时出栈，一起计算面积
                while (!stack.isEmpty() && heights[stack.peekLast()] == height) {

                    stack.pollLast();
                }

                // 计算宽度
                int width;

                if (stack.isEmpty()) {
                    width = i;
                } else {
                    width = i - stack.peekLast() - 1;
                }

                maxArea = Math.max(maxArea, height * width);
            }

            stack.offerLast(i);
        }

        // 如果栈不为空
        while (!stack.isEmpty()) {

            int height = heights[stack.pollLast()];

            // 高度相同的同时出栈，一起计算面积
            while (!stack.isEmpty() && heights[stack.peekLast()] == height) {

                stack.pollLast();
            }


            // 计算宽度
            int width;

            // 单调递增栈，都可以扩散到最后的位置
            if (stack.isEmpty()) {
                width = len;
            } else {
                width = len - stack.peekLast() - 1;
            }

            maxArea = Math.max(maxArea, height * width);

        }

        return maxArea;
    }


    public static void main(String[] args) {

        int[] heights = {2, 1, 5, 6, 2, 3};
        new LargestRectangleArea2().largestRectangleArea(heights);

    }

}
