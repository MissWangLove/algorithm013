package com.wz.september.time1.a7;

import java.util.*;

public class LevelTraversalOfBinaryTreeII {
    /**
     * 二叉树的层次遍历 II
     *
     * 给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
     *
     * 例如：
     * 给定二叉树 [3,9,20,null,null,15,7],
     *
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     * 返回其自底向上的层次遍历为：
     *
     * [
     *   [15,7],
     *   [9,20],
     *   [3]
     * ]
     *
     */

    /**
     * dfs和bfs
     */

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
        List<List<Integer>> lists = levelOrderBottom(root);
        for (List<Integer> list : lists) {
            for (Integer integer : list) {
                System.out.print(integer + ",");
            }
            System.out.println();
        }
    }

    /**
     * 先使用bfs吧
     * 时间复杂度和空间复杂度都是O（n）
     */
    /// bfs
    /*public static List<List<Integer>> levelOrderBottom(TreeNode root) {
        LinkedList<List<Integer>> result = new LinkedList<>();
        if (root == null) {
            return result;
        }
        LinkedList<TreeNode> linkedList = new LinkedList<>();
        linkedList.add(root);
        while (!linkedList.isEmpty()) {
            int len = linkedList.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < len; i++) {
                TreeNode treeNode = linkedList.pollFirst();
                list.add(treeNode.val);
                if (treeNode.left != null) {
                    linkedList.addLast(treeNode.left);
                }
                if (treeNode.right != null) {
                    linkedList.addLast(treeNode.right);
                }
            }
            result.addFirst(list);
        }
        return result;
    }*/

    /**
     * dfs
     * 为什么深度遍历给我的感觉更耗时呢？
     * 明明时间复杂度和空间复杂度都是O（n），奇怪，估计是递归的写法jvm的调用栈问题把。
     */
    public static List<List<Integer>> levelOrderBottom(TreeNode root) {
        LinkedList<List<Integer>> result = new LinkedList<>();
        if (root == null) {
            return result;
        }
        LinkedHashMap<Integer, List<Integer>> map = new LinkedHashMap<>();
        dfs(0, root, map);
        for (List<Integer> value : map.values()) {
            result.addFirst(value);
        }
        return result;
    }

    private static void dfs(int level, TreeNode root, Map<Integer, List<Integer>> map) {
        if (root == null) {
            return;
        }
        List<Integer> list = map.computeIfAbsent(level, k -> new ArrayList<>());
        list.add(root.val);
        dfs(level + 1, root.left, map);
        dfs(level + 1, root.right, map);
    }
}

class TreeNode {
     int val;
      TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
}
