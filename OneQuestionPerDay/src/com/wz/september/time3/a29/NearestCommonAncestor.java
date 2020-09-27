package com.wz.september.time3.a29;

import java.util.LinkedList;

public class NearestCommonAncestor {
    /**
     * 二叉搜索树的最近公共祖先
     *
     * 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
     *
     * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
     *
     * 例如，给定如下二叉搜索树: root =[6,2,8,0,4,7,9,null,null,3,5]
     *
     *
     * 示例 1:
     *
     * 输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
     * 输出: 6
     * 解释: 节点 2 和节点 8 的最近公共祖先是 6。
     * 示例 2:
     *
     * 输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
     * 输出: 2
     * 解释: 节点 2 和节点 4 的最近公共祖先是 2, 因为根据定义最近公共祖先节点可以为节点本身。
     *
     * 说明:
     *
     * 所有节点的值都是唯一的。
     * p、q 为不同节点且均存在于给定的二叉搜索树中。
     */

    /**
     * 二叉搜索树  直接暴力求解
     * 根据条件判断;
     *  1. 两个目标节点的任意一个等于当前遍历节点，当前遍历节点就是最近公共祖先
     *  2. 两个节点一个大于当前节点，一个小于当前节点，当前节点就是最近公共祖先
     *  递归判断就好
     */

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return root;
        }
        TreeNode result = null;
        LinkedList<TreeNode> linkedList = new LinkedList<>();
        linkedList.add(root);
        while (!linkedList.isEmpty()) {
            TreeNode treeNode = linkedList.pollLast();
            if (judgeTreeNode(treeNode, p, q)) {
                return treeNode;
            }
            if (p.val < treeNode.val && q.val < treeNode.val) {
                linkedList.add(treeNode.left);
            }
            if (p.val > treeNode.val && q.val > treeNode.val) {
                linkedList.add(treeNode.right);
            }
        }
        return result;
    }

    private Boolean judgeTreeNode(TreeNode root, TreeNode p, TreeNode q) {
        if (root.val == p.val || root.val == q.val) {
            return true;
        }
        if (root.val > p.val && root.val < q.val) {
            return true;
        }
        if (root.val < p.val && root.val > q.val) {
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(6);
        TreeNode root1 = new TreeNode(2);
        TreeNode root2 = new TreeNode(8);
        TreeNode root3 = new TreeNode(0);
        TreeNode root4 = new TreeNode(4);
        TreeNode root5 = new TreeNode(7);
        TreeNode root6 = new TreeNode(9);
        root.left = root1;
        root.right = root2;
        root1.left = root3;
        root1.right = root4;
        root2.left = root5;
        root2.right = root6;
        NearestCommonAncestor nearestCommonAncestor = new NearestCommonAncestor();
        TreeNode treeNode = nearestCommonAncestor.lowestCommonAncestor(root, new TreeNode(2), new TreeNode(8));
        System.out.println(treeNode.val);
        TreeNode treeNode1 = nearestCommonAncestor.lowestCommonAncestor(root, new TreeNode(2), new TreeNode(4));
        System.out.println(treeNode1.val);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
