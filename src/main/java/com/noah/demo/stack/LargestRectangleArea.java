package com.noah.demo.stack;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * Title: LargestRectangleArea.java <br>
 * Description:             <br>
 * Copyright: Copyright (c) 2015<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author yinzo 2022/7/2
 */
public class LargestRectangleArea {


    public int largestRectangleArea(int[] heights) {

        if (heights == null || heights.length == 0) {
            return 0;
        }

        if (heights.length == 1) {
            return heights[0];
        }

        int len = heights.length;

        int maxArea = 0;
        List<Integer> areaList = new ArrayList<>();

        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < len; i++) {

            while (!stack.isEmpty() && heights[stack.peekLast()] > heights[i]) {

                int height = heights[stack.removeLast()];

                while (!stack.isEmpty() && heights[stack.peekLast()] == height) {
                    stack.removeLast();
                }

                int width;
                if (stack.isEmpty()) {
                    width = i;
                } else {
                    width = i - stack.peekLast() - 1;
                }

                int area = width * height;

                areaList.add(area);
                maxArea = Math.max(maxArea, area);

            }

            stack.offerLast(i);
        }

        while (!stack.isEmpty()) {

            int height = heights[stack.removeLast()];

            while (!stack.isEmpty() && heights[stack.peekLast()] == height) {
                stack.removeLast();
            }

            int width;
            if (stack.isEmpty()) {
                width = len;
            } else {
                width = len - stack.peekLast() - 1;
            }

            int area = width * height;

            areaList.add(area);
            maxArea = Math.max(maxArea, area);
        }


        return maxArea;
    }

    @Test
    public void test() {

//        int[] arr = {6, 7, 5, 2, 4, 5, 9, 3};

        int[] arr = {2, 1, 5, 6, 2, 3};
        System.out.println(new LargestRectangleArea().largestRectangleArea(arr));


    }


}
