package com.wz.september.time1.a23;

import java.util.LinkedList;

public class ConvertBstToGreaterTree {
    /**
     * convert-bst-to-greater-tree
     *
     * 给定一个二叉搜索树（Binary Search Tree），把它转换成为累加树（Greater Tree)，使得每个节点的值是原来的节点值加上所有大于它的节点值之和。
     *
     * 例如：
     *
     * 输入: 原始二叉搜索树:
     *               5
     *             /   \
     *            2     13
     *
     * 输出: 转换为累加树:
     *              18
     *             /   \
     *           20     13
     *
     */

    /**
     * 其实比我想的要稍微简单点，因为是二叉搜索树
     *
     * 直接暴力求解，一个结点 = 这个结点 + 右子树的和，不用考虑存储中间结果
     */

    public TreeNode convertBST(TreeNode root) {
        if (root == null) {
            return null;
        }
        LinkedList<TreeNode> linkedList = new LinkedList<>();
        linkedList.add(root);
        while (!linkedList.isEmpty()) {
            TreeNode treeNode = linkedList.pollFirst();
            if (treeNode.right != null) {
                linkedList.add(treeNode.right);
                treeNode.val += getRightSum(treeNode.right);
                treeNode.right.val += treeNode.val;
            }
            if (treeNode.left != null) {
                treeNode.left.val += treeNode.val;
                linkedList.add(treeNode.left);
            }
        }
        return root;
    }

    private int getRightSum(TreeNode right) {
        int sum = 0;
        LinkedList<TreeNode> linkedList = new LinkedList<>();
        linkedList.add(right);
        while (!linkedList.isEmpty()) {
            TreeNode treeNode = linkedList.pollFirst();
            sum += treeNode.val;
            if (treeNode.left != null) {
                linkedList.add(treeNode.left);
            }
            if (treeNode.right != null) {
                linkedList.add(treeNode.right);
            }
        }
        return sum;
    }

}

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
}
