package com.noah.demo.suanfa;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Title: PostorderTraversal.java <br>
 * Description:             <br>
 * Copyright: Copyright (c) 2015<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author yinzo 2021/11/11
 */
public class PostorderTraversal {


    public List<Integer> postorderTraversal(TreeNode root) {

        List<Integer> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode prev = null;

        while (root != null || !stack.isEmpty()) {

            stack.push(root);
            root = root.left;
        }

        root = stack.pop();
        if (root.right == null || root.right == prev) {

            result.add(root.val);
            prev = root;
            root = null;
        } else {
            stack.push(root);
            root = root.right;
        }


        return result;
    }


    public List<Integer> postorderTraversal2(TreeNode root) {

        List<Integer> result = new ArrayList<>();

        postorder(root, result);
        return result;
    }

    public void postorder(TreeNode root, List<Integer> res) {

        if (root == null) {
            return;
        }

        postorder(root.left, res);
        postorder(root.right, res);
        res.add(root.val);

    }


}

//class TreeNode2 {
//    int val;
//    TreeNode left;
//    TreeNode right;
//    TreeNode2() {}
//    TreeNode2(int val) { this.val = val; }
//    TreeNode2(int val, TreeNode left, TreeNode right) {
//        this.val = val;
//        this.left = left;
//        this.right = right;
//    }
//}