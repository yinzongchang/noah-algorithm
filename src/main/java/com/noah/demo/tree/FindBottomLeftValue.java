package com.noah.demo.tree;

import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Title: FindBottomLeftValue.java <br>
 * Description:             <br>
 * Copyright: Copyright (c) 2015<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author yinzo 2022/6/22
 */
public class FindBottomLeftValue {

    public int findBottomLeftValue(TreeNode root) {

        if (root == null) {
            return 0;
        }


        int bottomLeftValue = 0;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {

            int size = queue.size();

            for (int i = 0; i < size; i++) {

                if (i == 0) {
                    bottomLeftValue = queue.peek().val;
                }

                TreeNode node = queue.poll();

                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }

        }

        return bottomLeftValue;
    }

}
