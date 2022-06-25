package com.noah.demo.tree;

/**
 * Title: SumRootToLeaf.java <br>
 * Description:             <br>
 * Copyright: Copyright (c) 2015<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author yinzo 2022/5/30
 */
public class SumRootToLeaf {

    int result = 0;

    public int sumRootToLeaf(TreeNode root) {

        dfs(root, 0);

        return result;
    }


    public void dfs(TreeNode root, int preSum) {

        if (root == null) {
            return;
        }

        preSum = preSum * 2 + root.val;

        if (root.left == null && root.right == null) {

            result = result + preSum;
        }

        dfs(root.left, preSum);
        dfs(root.right, preSum);

    }

}
