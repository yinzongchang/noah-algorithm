package com.noah.demo.tree;

/**
 * MaxDepth.java
 *
 * @author yinzongchang
 * 创建时间 2023/1/9
 * @since 1.0
 */
public class MaxDepth {


    /**
     * 104. 二叉树的最大深度
     * <a href="https://leetcode.cn/problems/maximum-depth-of-binary-tree/description/">...</a>
     *
     * 给定一个二叉树，找出其最大深度。
     * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
     * 说明: 叶子节点是指没有子节点的节点。
     *
     * 示例：
     * 给定二叉树 [3,9,20,null,null,15,7]，
     *
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     * 返回它的最大深度 3 。
     */
    public int maxDepth(TreeNode root) {

        if (root == null) {
            return 0;
        } else {

            int left = maxDepth(root.left);
            int right = maxDepth(root.right);

            return Math.max(left, right) + 1;
        }
    }


}
