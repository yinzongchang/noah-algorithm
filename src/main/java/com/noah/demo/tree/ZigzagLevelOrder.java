package com.noah.demo.tree;

import org.junit.Test;

import java.util.*;

/**
 * Title: ZigzagLevelOrder.java <br>
 * Description:             <br>
 * Copyright: Copyright (c) 2015<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author yinzo 2022/7/24
 */
public class ZigzagLevelOrder {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        if (root == null) {
            return new ArrayList<>();
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int order = 0;

        List<List<Integer>> ans = new ArrayList<>();
        while (!queue.isEmpty()) {

            int size = queue.size();


            int[] arr = new int[size];

            for (int i = 0; i < size; i++) {

                TreeNode node = queue.poll();

                if (order % 2 == 1) {

                    arr[i] = node.val;
                } else {
                    arr[size - i - 1] = node.val;
                }


                if (node.left != null) {
                    queue.offer(node.left);
                }

                if (node.right != null) {
                    queue.offer(node.right);
                }
            }

            List<Integer> levelList = new ArrayList<>(size);

            for (int i = 0; i < size; i++) {
                levelList.add(arr[i]);
            }


            ans.add(levelList);
            order++;
        }

        return ans;
    }


    @Test
    public void test() {

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);




        new ZigzagLevelOrder().zigzagLevelOrder(root);


    }

}
