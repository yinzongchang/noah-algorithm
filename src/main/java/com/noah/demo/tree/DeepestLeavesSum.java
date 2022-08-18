package com.noah.demo.tree;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Title: DeepestLeavesSum.java <br>
 * Description:             <br>
 * Copyright: Copyright (c) 2015<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author yinzo 2022/8/17
 */
public class DeepestLeavesSum {


    /**
     * 1302. 层数最深叶子节点的和
     * <p>
     * 给你一棵二叉树的根节点 root ，请你返回 层数最深的叶子节点的和 。
     * <p>
     * 输入：root = [1,2,3,4,5,null,6,7,null,null,null,null,8]
     * 输出：15
     * <p>
     * https://leetcode.cn/problems/deepest-leaves-sum/
     *
     * @param root
     * @return
     */
    public int deepestLeavesSum(TreeNode root) {

        if (root == null) {
            return 0;
        }

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);

        int ans = 0;

        while (!queue.isEmpty()) {

            int size = queue.size();

            int sum = 0;

            for (int i = 0; i < size; i++) {


                TreeNode node = queue.poll();
                sum += node.val;

                if (node.left != null) {
                    queue.offer(node.left);
                }

                if (node.right != null) {
                    queue.offer(node.right);
                }
            }

            ans = sum;
        }

        return ans;
    }

}
