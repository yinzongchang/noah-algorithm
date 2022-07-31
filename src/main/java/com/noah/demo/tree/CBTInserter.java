package com.noah.demo.tree;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Title: CBTInserter.java <br>
 * Description:             <br>
 * Copyright: Copyright (c) 2015<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author yinzo 2022/7/25
 */
public class CBTInserter {

    Queue<TreeNode> candidate;
    TreeNode root;

    public CBTInserter(TreeNode root) {

        this.candidate = new ArrayDeque<>();
        this.root = root;

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);

        while (!queue.isEmpty()) {

            TreeNode node = queue.poll();

            if (node.left != null) {
                queue.offer(node.left);
            }

            if (node.right != null) {
                queue.offer(node.right);
            }

            if (node.left == null || node.right == null) {

                candidate.offer(node);
            }
        }

    }

    public int insert(int val) {

        TreeNode childNode = new TreeNode(val);

        TreeNode node = candidate.peek();

        if (node.left == null) {

            node.left = childNode;
        } else {

            node.right = childNode;
            candidate.poll();
        }

        candidate.offer(childNode);

        return node.val;
    }

    public TreeNode get_root() {

        return this.root;
    }

}
