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
public class ValidBST {

    List<Integer> list = new ArrayList<>();

    public boolean isValidBST(TreeNode root) {

        list.clear();

        dfs(root);

        System.out.println(JSONObject.toJSONString(list));

        for (int i = 1; i < list.size(); i++) {

            if (list.get(i - 1) >= list.get(i)) {
                return false;
            }
        }

        return true;
    }


    public void dfs(TreeNode node) {

        if (node == null) {
            return;
        }


        dfs(node.left);

        list.add(node.val);

        dfs(node.right);
    }

    @Test
    public void test() {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(1);

        System.out.println(new ValidBST().isValidBST(root));

    }

}
