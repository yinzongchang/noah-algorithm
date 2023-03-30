package com.noah.nowcoder.stack;

import java.util.*;

/**
 * FindPeakElement.java
 *
 * @author yinzongchang
 * 创建时间 2023/1/31
 * @since 1.0
 */
public class FindPeakElement {

    /**
     * BM19 寻找峰值
     * <p>
     * <a href="https://www.nowcoder.com/practice/fcf87540c4f347bcb4cf720b5b350c76?tpId=295&tqId=2227748&ru=%2Fpractice%2Fd3df40bd23594118b57554129cadf47b&qru=%2Fta%2Fformat-top101%2Fquestion-ranking&sourceUrl=%2Fexam%2Foj">...</a>
     * 描述
     * 给定一个长度为n的数组nums，请你找到峰值并返回其索引。数组可能包含多个峰值，在这种情况下，返回任何一个所在位置即可。
     * 1.峰值元素是指其值严格大于左右相邻值的元素。严格大于即不能有等于
     * 2.假设 nums[-1] = nums[n] =−∞
     * 3.对于所有有效的 i 都有 nums[i] != nums[i + 1]
     * 4.你可以使用O(logN)的时间复杂度实现此问题吗？
     */
    public int findPeakElement(int[] nums) {

//        Stack<Integer> stack = new Stack<>();
        Deque<Integer> stack = new ArrayDeque<>();

        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {

            if (stack.isEmpty()) {
                stack.offer(i);
            } else {

                if (nums[i] < nums[stack.peek()]) {

                    // 证明有相等的数据
                    if (stack.size() > 1) {
                        while (!stack.isEmpty()) {
                            stack.pop();
                        }
                    } else {
                        res.add(stack.pop());
                    }
                } else if (nums[i] == nums[stack.peek()]) {
                    stack.push(i);
                } else {
                    stack.pop();
                    stack.push(i);
                }
            }
        }

        if (stack.size() == 1) {
            res.add(stack.pop());
        }

        return res.size() == 0 ? -1 : res.get(0);
    }

    public static void main(String[] args) {

        int[] arr = {2, 4, 1, 2, 7, 8, 4};

        System.out.println(new FindPeakElement().findPeakElement(arr));

    }

}
