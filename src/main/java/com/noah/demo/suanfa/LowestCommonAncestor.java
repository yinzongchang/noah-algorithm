package com.noah.demo.suanfa;

import org.junit.Test;

/**
 * Title: LowestCommonAncestor.java <br>
 * Description:             <br>
 * Copyright: Copyright (c) 2015<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author yinzo 2021/11/11
 */
public class LowestCommonAncestor {


    @Test
    public void test() {


        TreeNode root = new TreeNode(0);
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(3);
        TreeNode d = new TreeNode(4);
        TreeNode e = new TreeNode(5);
        TreeNode f = new TreeNode(6);

        root.left = a;
        root.right = b;
        a.left = c;
        a.right = d;

        b.left = e;
        b.right = f;

        System.out.println(new LowestCommonAncestor().lowestCommonAncestor(root, e, f).val);



    }


    /**
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if (root == null || root == p || root == q) {

            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left == null) {
            return right;
        }

        if (right == null) {
            return left;
        }

        return root;
    }

    /**
     * 二叉搜索树
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {

        TreeNode ancestor = root;

        while (true) {

            if (p.val < ancestor.val && q.val < ancestor.val) {
                ancestor = root.left;
            } else if (p.val > ancestor.val && q.val > ancestor.val) {
                ancestor = root.right;
            } else {
                break;
            }
        }

        return ancestor;
    }

}






class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}