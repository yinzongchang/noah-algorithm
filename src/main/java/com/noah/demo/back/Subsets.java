package com.noah.demo.back;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * Title: Subsets.java <br>
 * Description:             <br>
 * Copyright: Copyright (c) 2015<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author yinzo 2022/7/26
 */
public class Subsets {

    /**
     * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
     *
     * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
     *
     * 示例 1：
     *
     * 输入：nums = [1,2,3]
     * 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
     */
    public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }

        Deque<Integer> path = new ArrayDeque<>();


        dfs(nums, path, 0, res);

        return res;
    }

    private void dfs(int[] nums, Deque<Integer> path, int begin, List<List<Integer>> res) {

        res.add(new ArrayList<>(path));

        for (int i = begin; i < nums.length; i++) {

            path.offerLast(nums[i]);

            dfs(nums, path, i + 1, res);

            path.pollLast();
        }
    }
}
