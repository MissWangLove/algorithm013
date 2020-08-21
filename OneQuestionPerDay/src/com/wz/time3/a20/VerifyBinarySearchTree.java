package com.wz.time3.a20;

import java.util.Stack;

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

    /**
     * 二叉搜索树的中序遍历是升序的，所以利用二叉搜索树的中序遍历进行判断，
     * 记录上一个访问的结点，然后比对就好。
     * 时间复杂度O(n)
     * 空间复杂度为O(n)
     */
    public static boolean isValidBST(TreeNode root) {

        return true;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
