package com.noah.demo.back;

import java.util.*;

/**
 * Title: SubsetsWithDup.java <br>
 * Description:             <br>
 * Copyright: Copyright (c) 2015<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author yinzo 2022/7/26
 */
public class SubsetsWithDup {

    public List<List<Integer>> subsetsWithDup(int[] nums) {


        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }

        // 关键步骤 - 要排序
        Arrays.sort(nums);
        Deque<Integer> path = new ArrayDeque<>();


        dfs(nums, path, 0, res);

        return res;
    }

    private void dfs(int[] nums, Deque<Integer> path, int begin, List<List<Integer>> res) {

        res.add(new ArrayList<>(path));

        for (int i = begin; i < nums.length; i++) {

            // 去除重复项
            if (i > begin && nums[i] == nums[i - 1]) {
                continue;
            }

            path.offerLast(nums[i]);

            dfs(nums, path, i + 1, res);

            path.pollLast();
        }
    }

}
