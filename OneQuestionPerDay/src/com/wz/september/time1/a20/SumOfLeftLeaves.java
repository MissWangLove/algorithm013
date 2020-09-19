package com.wz.september.time1.a20;

import java.util.LinkedList;

public class SumOfLeftLeaves {
    /**
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
     * bfs和dfs，题目没看清，是叶子节点，所以关键点在于如何判断是否为左叶子节点
     */

    /**
     * 看题解，优化自己的写法
     */
    public static int sumOfLeftLeaves(TreeNode root) {
        return root == null ? 0 : dfs(root);
    }

    private static int dfs(TreeNode root) {
        int ans = 0;
        if (root.left != null) {
            ans += isLead(root.left) ? root.left.val : dfs(root.left);
        }
        if (root.right != null && !isLead(root.right)) {
            ans += dfs(root.right);
        }
        return ans;
    }

    private static boolean isLead(TreeNode right) {
        return right.left == null && right.right == null;
    }

    // bfs
   /* public static int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }
        LinkedList<TreeNode> linkedList = new LinkedList<>();
        int result = 0;
        linkedList.add(root);
        while (!linkedList.isEmpty()) {
            int loop = linkedList.size();
            for (int i = 0; i < loop; i++) {
                TreeNode treeNode = linkedList.pollFirst();
                if (treeNode.left != null) {
                    // 这里是关键点
                    if (treeNode.left.left == null && treeNode.left.right == null) {
                        result += treeNode.left.val;
                    } else {
                        linkedList.add(treeNode.left);
                    }
                }
                if (treeNode.right != null) {
                    if (treeNode.right.left == null && treeNode.right.right == null) {

                    } else {
                        linkedList.add(treeNode.right);
                    }
                }
            }
        }
        return result;
    }*/

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
