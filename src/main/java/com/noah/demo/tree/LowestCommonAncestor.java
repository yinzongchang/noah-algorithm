package com.noah.demo.tree;

/**
 * Title: LowestCommonAncestor.java <br>
 * Description:             <br>
 * Copyright: Copyright (c) 2015<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author yinzo 2022/7/24
 */
public class LowestCommonAncestor {


    TreeNode ans = null;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        dfs(root, p, q);
        return ans;

    }


    public boolean dfs(TreeNode root, TreeNode p, TreeNode q) {

        if (root == null) {
            return false;
        }

        boolean left = dfs(root.left, p, q);
        boolean right = dfs(root.right, p, q);

        if (left && right
                // 判断本身节点相同
                || ((root == p || root == q) && (left || right))) {
            ans = root;
        }

        return root == p || root == q || left || right;
    }


    /**
     * 剑指 Offer 68 - I. 二叉搜索树的最近公共祖先
     * <p>
     * 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
     * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
     * 例如，给定如下二叉搜索树: root = [6,2,8,0,4,7,9,null,null,3,5]
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/er-cha-sou-suo-shu-de-zui-jin-gong-gong-zu-xian-lcof
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {

        TreeNode ancestorNode = root;


        while (true) {

            if (ancestorNode.val > p.val && ancestorNode.val > q.val) {

                ancestorNode = ancestorNode.left;
            } else if (ancestorNode.val < p.val && ancestorNode.val < q.val) {

                ancestorNode = ancestorNode.right;
            } else {
                break;
            }
        }

        return ancestorNode;
    }


}