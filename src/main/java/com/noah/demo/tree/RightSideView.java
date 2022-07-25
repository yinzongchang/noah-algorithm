package com.noah.demo.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Title: RightSideView.java <br>
 * Description:             <br>
 * Copyright: Copyright (c) 2015<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author yinzo 2022/7/24
 */
public class RightSideView {

    List<Integer> ans = new ArrayList<>();

    /**
     * 思路： 我们按照 「根结点 -> 右子树 -> 左子树」 的顺序访问，就可以保证每层都是最先访问最右边的节点的。
     * <p>
     * （与先序遍历 「根结点 -> 左子树 -> 右子树」 正好相反，先序遍历每层最先访问的是最左边的节点）
     * <p>
     * 时间复杂度： O(N)O(N)，每个节点都访问了 1 次。
     * 空间复杂度： O(N)O(N)，因为这不是一棵平衡二叉树，二叉树的深度最少是 logNlogN, 最坏的情况下会退化成一条链表，深度就是 NN，因此递归时使用的栈空间是 O(N)O(N) 的。
     * <p>
     * <p>
     * 链接：https://leetcode.cn/problems/binary-tree-right-side-view/solution/jian-dan-bfsdfs-bi-xu-miao-dong-by-sweetiee/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public List<Integer> rightSideView(TreeNode root) {

        dfs(root, 0);
        return ans;
    }

    public void dfs(TreeNode root, int depth) {

        if (root == null) {
            return;
        }

        // 先访问 当前节点，再递归地访问 右子树 和 左子树。
        // 如果当前节点所在深度还没有出现在res里，说明在该深度下当前节点是第一个被访问的节点，因此将当前节点加入res中。
        if (depth == ans.size()) {

            ans.add(root.val);
        }

        depth++;

        dfs(root.right, depth);
        dfs(root.left, depth);
    }

}
