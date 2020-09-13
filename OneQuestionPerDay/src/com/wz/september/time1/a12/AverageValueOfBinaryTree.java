package com.wz.september.time1.a12;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class AverageValueOfBinaryTree {

    /**
     * 给定一个非空二叉树, 返回一个由每层节点平均值组成的数组。
     *
     * 示例 1：
     *
     * 输入：
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     * 输出：[3, 14.5, 11]
     * 解释：
     * 第 0 层的平均值是 3 ,  第1层是 14.5 , 第2层是 11 。因此返回 [3, 14.5, 11] 。
     *
     * 提示：
     *
     * 节点值的范围在32位有符号整数范围内。
     */

    /**
     * 这道题简单，直接bfs来实现
     */

    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<>();
        if (root ==null) {
            return result;
        }
        LinkedList<TreeNode> linkedList = new LinkedList<>();
        linkedList.add(root);
        while (!linkedList.isEmpty()) {
            int size = linkedList.size();
            double sum = 0.0;
            for (int i = 0; i < size; i++) {
                TreeNode treeNode = linkedList.pollFirst();
                if (treeNode.left != null) {
                    linkedList.add(treeNode.left);
                }
                if (treeNode.right != null) {
                    linkedList.add(treeNode.right);
                }
                sum += treeNode.val;
            }
            result.add(sum / size);
        }
        return result;
    }
}

 class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
