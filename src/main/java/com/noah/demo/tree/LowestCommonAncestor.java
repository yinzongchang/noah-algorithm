package com.noah.demo.tree;

/**
 * Title: LowestCommonAncestor.java <br>
 * Description:             <br>
 * Copyright: Copyright (c) 2015<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author yinzo 2022/7/24
 */
public class LowestCommonAncestor {


    TreeNode ans = null;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        dfs(root, p, q);
        return ans;

    }


    public boolean dfs(TreeNode root, TreeNode p, TreeNode q) {

        if (root == null) {
            return false;
        }

        boolean left = dfs(root.left, p, q);
        boolean right = dfs(root.right, p, q);

        if (left && right
                // 判断本身节点相同
                || ((root == p || root == q) && (left || right))) {
            ans = root;
        }

        return root == p || root == q || left || right;
    }

}