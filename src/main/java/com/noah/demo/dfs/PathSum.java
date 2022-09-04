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


    /**
     * 113. 路径总和 II
     *
     * 给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。
     *
     * 叶子节点 是指没有子节点的节点。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/path-sum-ii
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param root
     * @param targetSum
     * @return
     */
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {

        // 返回记过
        List<List<Integer>> result = new ArrayList<>();

        Deque<Integer> deque = new LinkedList<>();

        dfs(root, 0, targetSum, deque, result);

        return result;
    }

    public void dfs(TreeNode root, int sum, int targetSum, Deque<Integer> deque, List<List<Integer>> result) {


        if (root == null) {
            return;
        }

        deque.offerLast(root.val);

        if (root.val + sum == targetSum
                && root.left == null
                && root.right == null) {

            result.add(new LinkedList<>(deque));
        }

        dfs(root.left, sum + root.val, targetSum, deque, result);
        dfs(root.right, sum + root.val, targetSum, deque, result);

        deque.pollLast();

    }


}
