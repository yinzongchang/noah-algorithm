package com.noah.demo.back;

import java.util.*;

/**
 * Title: CombinationSum2.java <br>
 * Description:             <br>
 * Copyright: Copyright (c) 2015<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author yinzo 2022/7/26
 */
public class CombinationSum2 {


    /**
     * 给定一个候选人编号的集合 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
     * <p>
     * candidates 中的每个数字在每个组合中只能使用 一次 。
     * <p>
     * 注意：解集不能包含重复的组合。
     * <p>
     * 示例1:
     * <p>
     * 输入: candidates =[10,1,2,7,6,1,5], target =8,
     * 输出:
     * [
     * [1,1,6],
     * [1,2,5],
     * [1,7],
     * [2,6]
     * ]
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/combination-sum-ii
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        List<List<Integer>> res = new ArrayList<>();
        if (candidates == null || candidates.length == 0) {
            return res;
        }

        Arrays.sort(candidates);

        int len = candidates.length;
        boolean[] used = new boolean[len];

        // 保存结果
        Deque<Integer> path = new ArrayDeque<>();

        dfs(candidates, target, used, path, 0, 0, res);

        return res;
    }

    private void dfs(int[] candidates, int target, boolean[] used, Deque<Integer> path, int begin, int sum, List<List<Integer>> res) {

        if (sum > target) {
            return;
        }

        if (sum == target) {
            res.add(new ArrayList<>(path));
        }

        for (int i = begin; i < candidates.length; i++) {

            if (used[i]) {
                continue;
            }

            // 小剪枝：同一层相同数值的结点，从第 2 个开始，候选数更少，结果一定发生重复，因此跳过，用 continue
            if (i > begin && candidates[i] == candidates[i - 1]) {
                continue;
            }

            path.offerLast(candidates[i]);
            used[i] = true;
            dfs(candidates, target, used, path, i + 1,sum + candidates[i], res);
            path.pollLast();
            used[i] = false;
        }

    }


}
