package com.noah.demo.tree;

/**
 * Title: DiameterOfBinaryTree.java <br>
 * Description:             <br>
 * Copyright: Copyright (c) 2015<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author yinzo 2022/7/24
 */
public class DiameterOfBinaryTree {

    int ans = 0;

    public int diameterOfBinaryTree(TreeNode root) {

        dfs(root);

        return ans;
    }

    public int dfs(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int left = dfs(root.left);
        int right = dfs(root.right);

        ans = Math.max(ans, left + right);

        return Math.max(left, right) + 1;
    }

}
