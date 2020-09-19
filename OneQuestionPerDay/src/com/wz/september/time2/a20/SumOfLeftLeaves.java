package com.wz.september.time2.a20;

public class SumOfLeftLeaves {
    /**
     * 左叶子之和
     * 计算给定二叉树的所有左叶子之和。
     *
     * 示例：
     *
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     *
     * 在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24
     */

    public static int sumOfLeftLeaves(TreeNode root) {

        return 0;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode root1 = new TreeNode(9);
        TreeNode root2 = new TreeNode(20);
        TreeNode root3 = new TreeNode(15);
        TreeNode root4 = new TreeNode(7);
        root.left = root1;
        root.right = root2;
        root2.left = root3;
        root2.right = root4;
        System.out.println(sumOfLeftLeaves(root));
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

