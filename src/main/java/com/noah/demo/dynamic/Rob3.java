package com.noah.demo.dynamic;

import com.noah.demo.tree.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Title: Rob3.java <br>
 * Description:             <br>
 * Copyright: Copyright (c) 2015<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author yinzo 2022/6/22
 */
public class Rob3 {


    // 当根节点被选中，左子树和右子树都不能被选中
    // f(o) = g(l) + g(r) + o.val。
    Map<TreeNode, Integer> f = new HashMap<>();

    // 当根节点不被选中
    // g(o) = max(f(l), g(l)) + max(f(r) + g(r))
    Map<TreeNode, Integer> g = new HashMap<>();


    public int rob(TreeNode root) {

        dfs(root);
        int max = Math.max(f.getOrDefault(root, 0), g.getOrDefault(root, 0));

        return max;
    }

    public void dfs(TreeNode root) {

        if (root == null) {
            return;
        }

        dfs(root.left);
        dfs(root.right);

        // 根节点被选中
        f.put(root, root.val + g.getOrDefault(root.left, 0) + g.getOrDefault(root.right, 0));

        int gValue = Math.max(f.getOrDefault(root.left, 0), g.getOrDefault(root.left, 0)) +
                Math.max(f.getOrDefault(root.right, 0), g.getOrDefault(root.right, 0));

        g.put(root, gValue);
    }


}
