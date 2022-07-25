package com.noah.demo.tree;

/**
 * Title: KthLargest.java <br>
 * Description:             <br>
 * Copyright: Copyright (c) 2015<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author yinzo 2022/7/24
 */
public class KthLargest {

    int ans = 0;
    int k;

    public int kthLargest(TreeNode root, int k) {

        this.k = k;

        dfs(root);

        return ans;
    }


    public void dfs(TreeNode root) {

        if (root == null) {
            return;
        }

        // 中序遍历 - 反转
        dfs(root.right);

        if (k == 0) {
            return;
        }

        if (--k == 0) {
            ans = root.val;
        }

        dfs(root.left);
    }
}
