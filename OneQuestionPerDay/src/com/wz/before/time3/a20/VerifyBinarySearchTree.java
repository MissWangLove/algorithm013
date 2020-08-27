package com.wz.before.time3.a20;

import java.util.*;

public class VerifyBinarySearchTree {

    /**
     * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
     *
     * 假设一个二叉搜索树具有如下特征：
     *
     * 节点的左子树只包含小于当前节点的数。
     * 节点的右子树只包含大于当前节点的数。
     * 所有左子树和右子树自身必须也是二叉搜索树。
     * 示例1:
     *
     * 输入:
     *     2
     *    / \
     *   1   3
     * 输出: true
     * 示例2:
     *
     * 输入:
     *     5
     *    / \
     *   1   4
     *     / \
     *    3   6
     * 输出: false
     * 解释: 输入为: [5,1,4,null,null,3,6]。
     *     根节点的值为 5 ，但是其右子节点值为 4 。
     *
     */

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(2);
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(3);
        treeNode.left = treeNode1;
        treeNode.right = treeNode2;
        System.out.println(isValidBST(treeNode));
    }

    /**
     * 将二叉树中序遍历的结果放到集合中，然后存放下一个元素的时候判断是否比上一个元素大
     * 左 - 根 - 右
     * 时间复杂度O(n)
     * 空间复杂度为O(n)
     */
    public static boolean isValidBST(TreeNode root) {
        TreeNode pre = null;
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.add(root);
                root = root.left;
            }
            TreeNode pop = stack.pop();
            if (pre != null && pre.val > pop.val) {
                return false;
            }
            pre = pop;
            root = pop.right;
        }
        return true;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
