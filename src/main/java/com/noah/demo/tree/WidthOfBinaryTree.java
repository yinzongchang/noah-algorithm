package com.noah.demo.tree;

import javafx.util.Pair;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Title: WidthOfBinaryTree.java <br>
 * Description:             <br>
 * Copyright: Copyright (c) 2015<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author yinzo 2022/8/27
 */
public class WidthOfBinaryTree {


    public int widthOfBinaryTree(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int ans = 1;

        Queue<Pair<TreeNode, Integer>> queue = new ArrayDeque<>();
        queue.offer(new Pair<>(root, 1));

        while (!queue.isEmpty()) {

            int headValue = queue.peek().getValue();

            int size = queue.size();

            for (int i = 0; i < size; i++) {

                Pair<TreeNode, Integer> pair = queue.poll();

                TreeNode node = pair.getKey();
                Integer index = pair.getValue();

                if (node.left != null) {
                    queue.offer(new Pair<>(node.left, index * 2));
                }

                if (node.right != null) {
                    queue.offer(new Pair<>(node.right, index * 2 + 1));
                }

                ans = Math.max(ans, index - headValue + 1);

            }
        }

        return ans;
    }

}
