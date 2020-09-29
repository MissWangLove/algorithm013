package com.wz.september.time1.a31;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PostOrderTraversal {
    /**
     * 给定一个二叉树，返回它的 后序遍历。
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
     * 输出: [3,2,1]
     * 进阶递归算法很简单，你可以通过迭代算法完成吗？
     */

    /**
     * 后续遍历： 左 - 右 - 根
     * bfs或者dfs
     * bfs就是迭代
     * dfs就是递归
     */

     List<Integer> result = new ArrayList<>();

    /*public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<TreeNode> linkedList = new LinkedList<>();
        LinkedList<Integer> result = new LinkedList<>();
        if (root == null) {
            return result;
        }
        // 思路错误
        linkedList.add(root);
        while (!linkedList.isEmpty()) {
            TreeNode treeNode = linkedList.pollFirst();
            TreeNode right = treeNode.right;
            while (right != null) {
                if (treeNode.right != null) {
                    linkedList.addFirst(treeNode.right);
                }
                if (treeNode.left != null) {
                    linkedList.addFirst(treeNode.left);
                }
            }
            result.addFirst(treeNode.val);
        }
        return new ArrayList<>(result);
    }*/

    // 递归
    // 时间复杂度和空间复杂度都是 O(n)
    public List<Integer> postorderTraversal(TreeNode root) {
        dfs(root);
        return result;
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return ;
        }
        if (root.left != null) {
            dfs(root.left);
        }
        if (root.right != null) {
            dfs(root.right);
        }
        result.add(root.val);

    }

    public static void main(String[] args) {
        PostOrderTraversal postOrderTraversal = new PostOrderTraversal();
        TreeNode root = new TreeNode(1);
        TreeNode root1 = new TreeNode(2);
        TreeNode root2 = new TreeNode(3);
        root.right = root1;
        root1.left = root2;
        List<Integer> list = postOrderTraversal.postorderTraversal(root);
        list.forEach(System.out::println);
    }
}

class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;
  TreeNode() {}
  TreeNode(int val) { this.val = val; }
  TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
  }
}