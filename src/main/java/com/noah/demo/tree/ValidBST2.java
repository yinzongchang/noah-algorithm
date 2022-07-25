package com.noah.demo.tree;

import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Title: ValidBST.java <br>
 * Description:             <br>
 * Copyright: Copyright (c) 2015<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author yinzo 2022/7/16
 */
public class ValidBST2 {


    public boolean isValidBST(TreeNode root) {


        return dfs(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }


    public boolean dfs(TreeNode node, long lower, long upper) {

        if (node == null) {
            return true;
        }

        if (node.val <= lower || node.val >= upper) {
            return false;
        }

        boolean left = dfs(node.left, lower, node.val);

        boolean right = dfs(node.right, node.val, upper);

        return left && right;
    }



}
