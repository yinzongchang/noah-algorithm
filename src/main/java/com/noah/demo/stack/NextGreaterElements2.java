package com.noah.demo.stack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * Title: NextGreaterElements2.java <br>
 * Description:             <br>
 * Copyright: Copyright (c) 2015<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author yinzo 2022/9/3
 */
public class NextGreaterElements2 {


    public int[] nextGreaterElements(int[] nums) {

        int len = nums.length;

        int[] ans = new int[len];

        Arrays.fill(ans, -1);

        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < len * 2 - 1; i++) {


            while (!stack.isEmpty() && nums[i % len] > nums[stack.peek()]) {

                ans[stack.pop()] = nums[i % len];
            }

            stack.push(i % len);
        }

        return ans;
    }

}
