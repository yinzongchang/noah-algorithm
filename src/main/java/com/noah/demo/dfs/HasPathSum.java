package com.noah.demo.dfs;

import com.noah.demo.tree.TreeNode;
import org.junit.Test;

/**
 * Title: HasPathSum.java <br>
 * Description:             <br>
 * Copyright: Copyright (c) 2015<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author yinzo 2022/7/20
 */
public class HasPathSum {

    boolean ans = false;

    public boolean hasPathSum(TreeNode root, int targetSum) {

        dfs(root, 0, targetSum);

        return ans;
    }

    public void dfs(TreeNode root, int sum, int targetSum) {

        if (root == null) {
            return;
        }

        if (root.val + sum == targetSum &&
                root.left == null && root.right == null) {
            ans = true;
        }

        dfs(root.left, sum + root.val, targetSum);
        dfs(root.right, sum + root.val, targetSum);
    }


    @Test
    public void test() {

        TreeNode root = new TreeNode(1, new TreeNode(2), new TreeNode(3));

        new HasPathSum().hasPathSum(root, 5);

    }
}
