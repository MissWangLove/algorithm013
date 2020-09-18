package com.wz.september.time2.a17;

import sun.reflect.generics.tree.Tree;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class FlipBinaryTree {

    /**
     * 翻转一棵二叉树。
     *
     * 示例：
     *
     * 输入：
     *
     *      4
     *    /   \
     *   2     7
     *  / \   / \
     * 1   3 6   9
     * 输出：
     *
     *      4
     *    /   \
     *   7     2
     *  / \   / \
     * 9   6 3   1
     */

    /**
     * 直接反转试试，遍历每一个节点
     */


    /**
     * 递归的写法
     */
    public static TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }

    /**
     * 递归的写法，时间复杂度是O(n)
     * 这个算上调用栈也是o(n)的
     */
    /*public static TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        Deque<TreeNode> deque = new LinkedList<>();
        deque.add(root);
        while (!deque.isEmpty()) {
            TreeNode treeNode = deque.pollFirst();
            TreeNode left = treeNode.left;
            TreeNode right = treeNode.right;
            treeNode.right = left;
            treeNode.left = right;
            if (treeNode.left != null) {
                deque.add(treeNode.left);
            }
            if (treeNode.right != null) {
                deque.add(treeNode.right);
            }
        }
        return root;
    }*/

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        TreeNode root1 = new TreeNode(2);
        TreeNode root2 = new TreeNode(7);
        TreeNode root3 = new TreeNode(1);
        TreeNode root4 = new TreeNode(3);
        TreeNode root5 = new TreeNode(6);
        TreeNode root6 = new TreeNode(9);
        root.left = root1;
        root.right = root2;
        root1.left = root3;
        root1.right = root4;
        root2.left = root5;
        root2.right = root6;
        TreeNode treeNode = invertTree(root);
        System.out.println(treeNode);
    }
}

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;

      TreeNode(int x) {
          val = x;
      }
  }
