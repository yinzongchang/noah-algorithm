package com.noah.demo.back;

import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * Title: CombinationSum.java <br>
 * Description:             <br>
 * Copyright: Copyright (c) 2015<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author yinzo 2022/7/26
 */
public class CombinationSum {

    /**
     * 给你一个 无重复元素 的整数数组 candidates 和一个目标整数 target ，
     * 找出 candidates 中可以使数字和为目标数 target 的 所有 不同组合 ，并以列表形式返回。你可以按 任意顺序 返回这些组合。
     * candidates 中的 同一个 数字可以 无限制重复被选取 。如果至少一个数字的被选数量不同，则两种组合是不同的。
     * 对于给定的输入，保证和为 target 的不同组合数少于 150 个。
     * <p>
     * 示例 1：
     * 输入：candidates = [2,3,6,7], target = 7
     * 输出：[[2,2,3],[7]]
     * 解释：
     * 2 和 3 可以形成一组候选，2 + 2 + 3 = 7 。注意 2 可以使用多次。
     * 7 也是一个候选， 7 = 7 。
     * 仅有这两种组合。
     * <p>
     * 示例 2：
     * 输入: candidates = [2,3,5], target = 8
     * 输出: [[2,2,2,2],[2,3,3],[3,5]]
     * <p>
     * 链接: https://leetcode.cn/problems/combination-sum/
     *
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        if (candidates == null || candidates.length == 0) {
            return new ArrayList<>();
        }

        List<List<Integer>> res = new ArrayList<>();

        Deque<Integer> path = new ArrayDeque<>();

        dfs(candidates, target, path, 0, 0, res);

        return res;
    }


    public void dfs(int[] candidates, int target, Deque<Integer> path, int sum, int begin, List<List<Integer>> res) {

        if (sum > target) {
            return;
        }

        if (sum == target) {

            res.add(new ArrayList<>(path));
        }

        for (int i = begin; i < candidates.length; i++) {

            path.offerLast(candidates[i]);

            dfs(candidates, target, path, sum + candidates[i], i, res);

            path.pollLast();
        }
    }

    @Test
    public void test() {

        int[] candidates = {2, 3, 6, 7};
        int target = 7;

        List<List<Integer>> combinationSum = combinationSum(candidates, target);
        System.out.println(JSONObject.toJSONString(combinationSum));


    }

}
