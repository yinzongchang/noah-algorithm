package com.noah.demo.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Title: InorderTraversal.java <br>
 * Description:             <br>
 * Copyright: Copyright (c) 2015<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author yinzo 2022/4/17
 */
public class InorderTraversal {



    public List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> result = new ArrayList<>();

        traverse(root, result);

        return result;
    }

    /**
     * 递归方法
     *
     * @param root
     * @param result
     */
    public void traverse(TreeNode root, List<Integer> result) {

        if (root == null) {
            return;
        }

        traverse(root.left, result);
        result.add(root.val);
        traverse(root.right, result);
    }



    public List<Integer> inorderTraversal2(TreeNode root) {

        List<Integer> result = new ArrayList<>();

        Stack<TreeNode> stack = new Stack<>();

        while (root != null || !stack.isEmpty()) {

            while (root != null) {

                stack.push(root);
                root = root.left;
            }

            root = stack.pop();
            result.add(root.val);
            root = root.right;
        }

        return result;
    }




}


