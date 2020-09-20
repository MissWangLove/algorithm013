package com.wz.september.time2.a20;

import java.util.LinkedList;

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

    /**
     * bfs,不同的题目，哪怕相似的题目，有时候dfs和bfs的感觉还是不同的。
     * 时间复杂度和空间复杂度不用说了，时间复杂度是O（n），空间复杂度为 O（n）
     */
    public static int sumOfLeftLeaves(TreeNode root) {
        int result = 0;
        LinkedList<TreeNode> linkedList = new LinkedList<>();
        linkedList.add(root);
        while (!linkedList.isEmpty()) {
            int loop = linkedList.size();
            for (int i = 0; i < loop; i++) {
                TreeNode treeNode = linkedList.pollFirst();
                if (treeNode.left != null) {
                    if (isLeftLeave(treeNode.left)) {
                        result += treeNode.left.val;
                    } else {
                        linkedList.add(treeNode.left);
                    }

                }
                if (treeNode.right != null && !isLeftLeave(treeNode.right)) {
                    linkedList.add(treeNode.right);
                }
            }
        }
        return result;
    }

    /**
     * dfs,写的没问题，自信一点。
     */
    /*public static int sumOfLeftLeaves(TreeNode root) {
        return root == null ? 0 : dfs(root);
    }

    private static int dfs(TreeNode root) {
        int ans = 0;
        if (root.left != null) {
            ans += isLeftLeave(root.left) ? root.left.val : dfs(root.left);
        }
        if (root.right != null) {
            ans += isLeftLeave(root.right) ? 0 : dfs(root.right);
        }
        return ans;
    }*/

    private static boolean isLeftLeave(TreeNode left) {
        return left.left == null && left.right == null;
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

