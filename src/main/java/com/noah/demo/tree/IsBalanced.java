package com.noah.demo.tree;

/**
 * Title: IsBalanced.java <br>
 * Description:             <br>
 * Copyright: Copyright (c) 2015<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author yinzo 2022/8/27
 */
public class IsBalanced {


    /**
     * 110. 平衡二叉树
     * <p>
     * 给定一个二叉树，判断它是否是高度平衡的二叉树。
     * 本题中，一棵高度平衡二叉树定义为：
     * <p>
     * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1 。
     */
    public boolean isBalanced(TreeNode root) {

        return height(root) >= 0;
    }


    public int height(TreeNode root) {

        if (root == null) {
            return 0;
        }

        // 左子树的高度
        int leftHeight = height(root.left);


        // 右子树的高度
        int rightHeight = height(root.right);

        if (leftHeight == -1 || rightHeight == -1
                || Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        } else {

            return Math.max(leftHeight, rightHeight) + 1;
        }
    }

}
