package com.noah.demo.stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * Title: NextGreaterElement.java <br>
 * Description:             <br>
 * Copyright: Copyright (c) 2015<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author yinzo 2022/9/3
 */
public class NextGreaterElement {

    /**
     * 496. 下一个更大元素 I
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {

        int len = nums1.length;


        // 单调栈 - 递减栈
        Deque<Integer> stack = new ArrayDeque<>();

        Map<Integer, Integer> map = new HashMap<>();


        for (int i = nums2.length - 1; i >= 0; i--) {

            int num = nums2[i];

            while (!stack.isEmpty() && num >= stack.peek()) {

                stack.pop();
            }

            map.put(num, stack.isEmpty() ? -1 : stack.peek());
            stack.push(num);
        }

        int[] ans = new int[len];

        for (int i = 0; i < len; i++) {

            ans[i] = map.get(nums1[i]);

        }

        return ans;
    }

}
