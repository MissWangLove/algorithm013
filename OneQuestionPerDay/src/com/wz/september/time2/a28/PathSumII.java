package com.wz.september.time2.a28;

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


    // 存储路径
    Map<TreeNode, TreeNode> pathMap = new HashMap<>();
    // 存储路径和
    LinkedList<Integer> sumLinkedList = new LinkedList<>();

    /**
     * 广度遍历
     */
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null) {
            return result;
        }
        sumLinkedList.add(0);
        LinkedList<TreeNode> linkedList = new LinkedList<>();
        linkedList.add(root);
        while (!linkedList.isEmpty()) {
            TreeNode treeNode = linkedList.pollLast();
            int tempSum = sumLinkedList.pollLast() + treeNode.val;
            if (tempSum == sum && treeNode.left == null && treeNode.right == null) {
                getPath(treeNode);
            }
            if (treeNode.left != null) {
                linkedList.add(treeNode.left);
                sumLinkedList.add(tempSum);
                pathMap.put(treeNode.left, treeNode);
            }
            if (treeNode.right != null) {
                linkedList.add(treeNode.right);
                sumLinkedList.add(tempSum);
                pathMap.put(treeNode.right, treeNode);
            }
        }
        return result;
    }


    private void getPath(TreeNode node) {
        LinkedList<Integer> temp = new LinkedList<>();
        while (node != null) {
            temp.addFirst(node.val);
            node = pathMap.get(node);
        }
        result.add(new ArrayList<>(temp));
    }
    /**
     * 递归的写法
     * 时间复杂度为 O(n ^ 2)
     * 空间复杂度为 O(n)
     */
    List<List<Integer>> result = new ArrayList<>();
    /*public List<List<Integer>> pathSum(TreeNode root, int sum) {
        bfs(root, sum, new LinkedList<Integer>());
        return result;
    }

    private void bfs(TreeNode root, int sum, LinkedList<Integer> linkedList) {
        if (root == null) {
            return ;
        }
        sum -= root.val;
        linkedList.add(root.val);
        if (root.left == null && root.right == null && sum == 0) {
            result.add(new ArrayList<>(linkedList));
        }
        bfs(root.left, sum, linkedList);
        bfs(root.right, sum, linkedList);
        linkedList.pollLast();
    }*/

}

class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }