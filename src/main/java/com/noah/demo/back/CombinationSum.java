package com.noah.demo.back;

import java.util.*;

/**
 * Title: CombinationSum.java <br>
 * Description:             <br>
 * Copyright: Copyright (c) 2015<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author yinzo 2022/7/26
 */
public class CombinationSum {

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

}
