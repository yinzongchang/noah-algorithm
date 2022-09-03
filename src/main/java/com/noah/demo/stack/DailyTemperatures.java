package com.noah.demo.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Title: DailyTemperatures.java <br>
 * Description:             <br>
 * Copyright: Copyright (c) 2015<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author yinzo 2022/9/3
 */
public class DailyTemperatures {


    public int[] dailyTemperatures(int[] temperatures) {

        int len = temperatures.length;

        // 结果
        int[] ans = new int[len];

        // 单调栈 - 递减栈 (存放下标)
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < len; i++) {

            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {

                int index = stack.pop();

                ans[index] = i - index;

            }

            stack.push(i);
        }

        while (!stack.isEmpty()) {
            ans[stack.pop()] = 0;
        }


        return ans;
    }

}
