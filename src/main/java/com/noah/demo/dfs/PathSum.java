package com.noah.demo.dfs;

import com.noah.demo.tree.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Title: PathSum.java <br>
 * Description:             <br>
 * Copyright: Copyright (c) 2015<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author yinzo 2022/7/22
 */
public class PathSum {

    List<List<Integer>> result = new ArrayList<>();

    Deque<Integer> deque = new LinkedList<>();


    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {

        dfs(root, 0, targetSum);

        return result;
    }

    public void dfs(TreeNode root, int sum, int targetSum) {


        if (root == null) {
            return;
        }

        deque.offerLast(root.val);

        if (root.val + sum == targetSum
                && root.left == null && root.right == null) {

            result.add(new LinkedList<>(deque));
        }

        dfs(root.left, sum + root.val, targetSum);
        dfs(root.right, sum + root.val, targetSum);

        deque.pollLast();

    }


}
