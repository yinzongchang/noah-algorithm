package com.noah.demo.back;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * Title: CombinationSum3.java <br>
 * Description:             <br>
 * Copyright: Copyright (c) 2015<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author yinzo 2022/7/26
 */
public class CombinationSum3 {

    public List<List<Integer>> combinationSum3(int k, int n) {

        List<List<Integer>> res = new ArrayList<>();

        int[] candidates = {1, 2, 3, 4, 5, 6, 7, 8, 9};

        // 保存结果
        Deque<Integer> path = new ArrayDeque<>();

        dfs(candidates, k, n, path, 0, 0, res);

        return res;

    }

    private void dfs(int[] candidates, int k, int n, Deque<Integer> path, int begin, int sum, List<List<Integer>> res) {

        if (path.size() > k || sum > n) {
            return;
        }

        if (path.size() == k && sum == n) {

            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = begin; i < 9; i++) {

            path.offerLast(candidates[i]);

            dfs(candidates, k, n, path, i + 1, sum + candidates[i], res);

            path.pollLast();

        }
    }

}
