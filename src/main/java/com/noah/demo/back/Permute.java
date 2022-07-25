package com.noah.demo.back;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * Title: Permute.java <br>
 * Description:             <br>
 * Copyright: Copyright (c) 2015<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author yinzo 2022/7/24
 */
public class Permute {

    /**
     * 46. 全排列
     * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
     * 示例 1：
     * <p>
     * 输入：nums = [1,2,3]
     * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
     * <p>
     * https://leetcode.cn/problems/permutations/
     */
    public List<List<Integer>> permute(int[] nums) {

        int len = nums.length;
        if (len == 0) {
            return new ArrayList<>();
        }

        // 保存最终结果
        List<List<Integer>> result = new ArrayList<>();

        // 保存排列结果
        Deque<Integer> deque = new ArrayDeque<>();

        // 元素是否使用
        boolean[] used = new boolean[len];


        dfs(nums, len, 0, deque, used, result);

        return result;
    }

    private void dfs(int[] nums, int len, int depth, Deque<Integer> deque, boolean[] used, List<List<Integer>> result) {

        // 深度 = 数组长度，说明所有元素都排列了
        if (len == depth) {

            result.add(new ArrayList<>(deque));
            return;
        }

        for (int i = 0; i < len; i++) {

            if (used[i]) {
                continue;
            }

            deque.offerLast(nums[i]);
            used[i] = true;

            dfs(nums, len, depth + 1, deque, used, result);

            deque.pollLast();
            used[i] = false;
        }
    }

    public List<List<Integer>> permute2(int[] nums) {

        int len = nums.length;
        if (len == 0) {
            return new ArrayList<>();
        }


        return null;
    }


}
