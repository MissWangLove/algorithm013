package com.wz.september.time1.a28;

import java.util.*;

public class PathSumII {

    /**
     * 路径总和 II
     *
     * 给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
     *
     * 说明:叶子节点是指没有子节点的节点。
     *
     * 示例:
     * 给定如下二叉树，以及目标和sum = 22，
     *
     *               5
     *              / \
     *             4   8
     *            /   / \
     *           11  13  4
     *          /  \    / \
     *         7    2  5   1
     * 返回:
     *
     * [
     *    [5,4,11,2],
     *    [5,8,4,5]
     * ]
     */

    /**
     * dfs试试
     */

    List<List<Integer>> result = new ArrayList<>();

    Map<TreeNode, TreeNode> map = new HashMap<>();

    /**
     * bfs 这个有个新思路，就是可以利用map来存储树的访问路径，这个倒是个新的思路
     */
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null) {
            return result;
        }
        LinkedList<TreeNode> treeNodeLinkedList = new LinkedList<>();
        LinkedList<Integer> integerLinkedList = new LinkedList<>();
        treeNodeLinkedList.add(root);
        integerLinkedList.add(0);
        while (!treeNodeLinkedList.isEmpty()) {
            TreeNode treeNode = treeNodeLinkedList.pollLast();
            int temp = integerLinkedList.pollLast() + treeNode.val;
            if (treeNode.left == null && treeNode.right == null) {
                if (temp == sum) {
                    getPath(treeNode);
                }
            } else {
                if (treeNode.left != null) {
                    map.put(treeNode.left, treeNode);
                    treeNodeLinkedList.add(treeNode.left);
                    integerLinkedList.add(temp);
                }
                if (treeNode.right != null) {
                    map.put(treeNode.right, treeNode);
                    treeNodeLinkedList.add(treeNode.right);
                    integerLinkedList.add(temp);
                }
            }
        }

        return result;
    }

    private void getPath(TreeNode treeNode) {
        LinkedList<Integer> temp = new LinkedList<>();
        while (treeNode != null) {
            temp.addFirst(treeNode.val);
            treeNode = map.get(treeNode);
        }
        result.add(new ArrayList<>(temp));
    }

    /**
     * dfs 时间复杂度为 O（n ^ 2）
     * 空间复杂度为 O（n）
     */
    /*public List<List<Integer>> pathSum(TreeNode root, int sum) {
        dfs(root, sum, new LinkedList<Integer>());
        return result;
    }

    private void dfs(TreeNode root, int sum, LinkedList<Integer> linkedList) {
        if (root == null) {
            return ;
        }
        linkedList.add(root.val);
        sum -= root.val;
        if (sum == 0 && root.left == null && root.right == null) {
            result.add(new ArrayList<>(linkedList));
        }
        dfs(root.left, sum, linkedList);
        dfs(root.right, sum, linkedList);
        // 只有叶子结点才可以走到这一步
        linkedList.pollLast();
    }*/

}
 class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }