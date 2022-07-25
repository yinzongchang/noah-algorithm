package com.noah.demo.back;

import java.util.*;

/**
 * Title: PermuteUnique.java <br>
 * Description:             <br>
 * Copyright: Copyright (c) 2015<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author yinzo 2022/7/24
 */
public class PermuteUnique {


    public List<List<Integer>> permuteUnique(int[] nums) {

        int len = nums.length;
        if (len == 0) {
            return new ArrayList<>();
        }

        // 返回的结果
        List<List<Integer>> result = new ArrayList<>();

        // 排列组合
        Deque<Integer> deque = new ArrayDeque<>();

        // 是否已经使用
        boolean[] used = new boolean[len];

        Arrays.sort(nums);

        dfs(nums, len, 0, deque, used, result);

        return result;
    }

    private void dfs(int[] nums, int len, int depth, Deque<Integer> deque, boolean[] used, List<List<Integer>> result) {

        if (len == depth) {

            result.add(new ArrayList<>(deque));
            return;
        }

        for (int i = 0; i < len; i++) {

            if (used[i]) {
                continue;
            }

            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }

            deque.offerLast(nums[i]);
            used[i] = true;

            dfs(nums, len, depth + 1, deque, used, result);

            deque.pollLast();
            used[i] = false;
        }

    }
}
