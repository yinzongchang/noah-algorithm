package com.noah.demo.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Title: FindFrequentTreeSum.java <br>
 * Description:             <br>
 * Copyright: Copyright (c) 2015<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author yinzo 2022/6/19
 */
public class FindFrequentTreeSum {

    Map<Integer, Integer> treeSumMap = new HashMap<>();

    int maxSum = 0;

    public int[] findFrequentTreeSum(TreeNode root) {

        dfs(root);

        List<Integer> list = new ArrayList<>();

        for (Map.Entry<Integer, Integer> entry : treeSumMap.entrySet()) {

            Integer key = entry.getKey();
            Integer value = entry.getValue();

            if (value == maxSum) {
                list.add(key);
            }
        }

        int[] ans = new int[list.size()];
        for (int i = 0; i < list.size(); ++i) {
            ans[i] = list.get(i);
        }
        return ans;
    }

    public int dfs(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int val = root.val;

        int left = dfs(root.left);
        int right = dfs(root.right);

        int sum = val + left + right;

        treeSumMap.put(sum, treeSumMap.getOrDefault(val, 0) + 1);

        maxSum = Math.max(maxSum, treeSumMap.get(sum));
        return sum;
    }

}
