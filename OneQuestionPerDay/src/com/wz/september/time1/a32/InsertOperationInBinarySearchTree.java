package com.wz.september.time1.a32;

import java.util.LinkedList;

public class InsertOperationInBinarySearchTree {
    /**
     * 二叉搜索树中的插入操作
     *
     * 给定二叉搜索树（BST）的根节点和要插入树中的值，将值插入二叉搜索树。 返回插入后二叉搜索树的根节点。 输入数据保证，新值和原始二叉搜索树中的任意节点值都不同。
     *
     * 注意，可能存在多种有效的插入方式，只要树在插入后仍保持为二叉搜索树即可。 你可以返回任意有效的结果。
     *
     *  
     *
     * 例如, 
     *
     * 给定二叉搜索树:
     *
     *         4
     *        / \
     *       2   7
     *      / \
     *     1   3
     *
     * 和 插入的值: 5
     * 你可以返回这个二叉搜索树:
     *
     *          4
     *        /   \
     *       2     7
     *      / \   /
     *     1   3 5
     * 或者这个树也是有效的:
     *
     *          5
     *        /   \
     *       2     7
     *      / \
     *     1   3
     *          \
     *           4
     *
     * 提示：
     *
     * 给定的树上的节点数介于 0 和 10^4 之间
     * 每个节点都有一个唯一整数值，取值范围从 0 到 10^8
     * -10^8 <= val <= 10^8
     * 新值和原始二叉搜索树中的任意节点值都不同。
     */

    /**
     * 遍历一遍，插入到叶子节点
     */
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        LinkedList<TreeNode> linkedList = new LinkedList<>();
        linkedList.add(root);
        while (!linkedList.isEmpty()) {
            TreeNode treeNode = linkedList.pollLast();
            if (treeNode.val < val) {
                if (treeNode.right != null) {
                    linkedList.add(treeNode.right);
                } else {
                    TreeNode temp = new TreeNode(val);
                    treeNode.right = temp;
                }
            } else {
                if (treeNode.left != null) {
                    linkedList.add(treeNode.right);
                } else {
                    TreeNode temp = new TreeNode(val);
                    treeNode.left = temp;
                }
            }
        }
        return root;
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