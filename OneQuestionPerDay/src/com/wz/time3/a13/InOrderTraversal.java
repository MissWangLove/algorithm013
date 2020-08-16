package com.wz.time3.a13;

import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InOrderTraversal {

    /**
     * 给定一个二叉树，返回它的中序遍历。
     *
     * 示例:
     *
     * 输入: [1,null,2,3]
     *    1
     *     \
     *      2
     *     /
     *    3
     *
     * 输出: [1,3,2]
     * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
     */

    /**
     * 二叉树的中序遍历
     * 1. 递归
     * 2. 迭代
     */

    /**
     * 迭代
     * 无论是迭代还是递归，时间复杂度都是O(n)
     * 空间复杂度也是一样
     */
    /*public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            TreeNode pop = stack.pop();
            result.add(pop.val);
            root = pop.right;
        }
        return result;
    }*/


    /**
     * 递归
     */
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        getResult(root, result);
        return result;
    }

    private static void getResult(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            getResult(root.left, result);
        }
        result.add(root.val);
        if (root.right != null) {
            getResult(root.right, result);
        }
    }

}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}