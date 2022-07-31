package com.noah.demo.tree;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Title: MaxLevelSum.java <br>
 * Description:             <br>
 * Copyright: Copyright (c) 2015<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author yinzo 2022/7/31
 */
public class MaxLevelSum {

    public int maxLevelSum(TreeNode root) {

        if (root == null) {
            return -1;
        }

        int maxSum = Integer.MIN_VALUE;
        int maxSeq = 0;

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);

        int seq = 1;
        while (!queue.isEmpty()) {

            int size = queue.size();
            int sum = 0;

            for (int i = 0; i < size; i++) {

                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }

                if (node.right != null) {
                    queue.offer(node.right);
                }

                sum += node.val;
            }

            if (sum > maxSum) {
                maxSum = sum;
                maxSeq = seq;
            }

            seq++;
        }

        return maxSeq;
    }
}
