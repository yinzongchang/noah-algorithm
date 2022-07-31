package com.noah.demo.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Title: BinaryTreePaths.java <br>
 * Description:             <br>
 * Copyright: Copyright (c) 2015<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author yinzo 2022/7/26
 */
public class BinaryTreePaths {

    public List<String> binaryTreePaths(TreeNode root) {

        if (root == null) {

            return new ArrayList<>();
        }

        List<String> paths = new ArrayList<>();

        dfs(root, "", paths);

        return paths;
    }

    public void dfs(TreeNode root, String path, List<String> paths) {

        if (root == null) {
            return;
        }

        path += (root.val);

        // 当前节点是叶子节点
        if (root.left == null && root.right == null) {
            // 把路径加入到答案中
            paths.add(path);
        } else {

            path += "->";  // 当前节点不是叶子节点，继续递归遍历
            dfs(root.left, path, paths);
            dfs(root.right, path, paths);
        }
    }

}
