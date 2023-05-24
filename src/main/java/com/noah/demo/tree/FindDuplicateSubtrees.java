package com.noah.demo.tree;

//import javafx.util.Pair;

import java.util.*;

/**
 * Title: FindDuplicateSubtrees.java <br>
 * Description:             <br>
 * Copyright: Copyright (c) 2015<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author yinzo 2022/9/5
 */
public class FindDuplicateSubtrees {

//    Map<String, Pair<TreeNode, Integer>> seen = new HashMap<>();

    Set<TreeNode> repeat = new HashSet<>();

    int idx = 0;

    /**
     * 652. 寻找重复的子树
     * <p>
     * 给定一棵二叉树 root，返回所有重复的子树。
     * 对于同一类的重复子树，你只需要返回其中任意一棵的根结点即可。
     * 如果两棵树具有相同的结构和相同的结点值，则它们是重复的。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/find-duplicate-subtrees
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param root
     * @return
     */
//    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
//
//        dfs(root);
//
//        return new ArrayList<>(repeat);
//    }
//
//    private int dfs(TreeNode root) {
//
//        if (root == null) {
//            return 0;
//        }
//
//        int[] tri = {root.val, dfs(root.left), dfs(root.right)};
//
//        String hash = Arrays.toString(tri);
//
//        if (seen.containsKey(hash)) {
//
//            Pair<TreeNode, Integer> pair = seen.get(hash);
//            repeat.add(pair.getKey());
//
//            return pair.getValue();
//        } else {
//            seen.put(hash, new Pair<>(root, ++idx));
//            return idx;
//        }
//    }


}
