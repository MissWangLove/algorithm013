package com.wz.september.time1.a24;

import java.util.IllegalFormatCodePointException;
import java.util.LinkedList;

public class MergeBinaryTree {

    /**
     * 合并二叉树
     *
     * 给定两个二叉树，想象当你将它们中的一个覆盖到另一个上时，两个二叉树的一些节点便会重叠。
     *
     * 你需要将他们合并为一个新的二叉树。合并的规则是如果两个节点重叠，那么将他们的值相加作为节点合并后的新值，否则不为NULL 的节点将直接作为新二叉树的节点。
     *
     * 示例1:
     *
     * 输入:
     * 	Tree 1                     Tree 2
     *           1                         2
     *          / \                       / \
     *         3   2                     1   3
     *        /                           \   \
     *       5                             4   7
     * 输出:
     * 合并后的树:
     * 	     3
     * 	    / \
     * 	   4   5
     * 	  / \   \
     * 	 5   4   7
     * 注意:合并必须从两个树的根节点开始。
     *
     */

    /**
     * 这道题如何考虑呢？ 使用两个链表来实现吧，看看效果，bfs
     * 其实思路就是先补全二叉树，这个时候合并会相对好合并，但是补全的意思是两边至少又一个才补，如果两边都是null，就不能补
     */

    public static void main(String[] args) {
        /*TreeNode root = new TreeNode(1);
        TreeNode root1 = new TreeNode(3);
        TreeNode root2 = new TreeNode(2);
        TreeNode root3 = new TreeNode(5);
        root.left = root1;
        root.right = root2;
        root1.left = root3;

        TreeNode root4 = new TreeNode(2);
        TreeNode root5 = new TreeNode(1);
        TreeNode root6 = new TreeNode(3);
        TreeNode root7 = new TreeNode(4);
        TreeNode root8 = new TreeNode(7);
        root4.left = root5;
        root4.right = root6;
        root5.right = root7;
        root6.right = root8;*/
       /* TreeNode root = null;
        TreeNode root1 = new TreeNode(1);*/

        TreeNode root = new TreeNode(1);
        TreeNode root1 = new TreeNode(2);
        TreeNode root2 = new TreeNode(3);
        root.left = root1;
        root1.left = root2;

        TreeNode root4 = new TreeNode(1);
        TreeNode root5 = new TreeNode(2);
        TreeNode root6 = new TreeNode(3);
        root4.right = root5;
        root5.right = root6;
        TreeNode treeNode = mergeTrees(root, root4);
        System.out.println(treeNode.val);
    }

    /**
     * 时间复杂度和空间复杂度是满二叉树的复杂度（进行了补全，所以是深度 + 1的复杂度）
     */
    public static TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null) {
            return t2;
        }
        LinkedList<TreeNode> linkedList1 = new LinkedList<>();
        LinkedList<TreeNode> linkedList2 = new LinkedList<>();
        linkedList1.add(t1);
        linkedList2.add(t2);
        while (!linkedList2.isEmpty()) {
            TreeNode treeNode1 = linkedList1.pollFirst();
            TreeNode treeNode2 = linkedList2.pollFirst();
            if (treeNode1 != null || treeNode2 != null) {
                if (treeNode1 == null) {
                    treeNode1 = new TreeNode(0);
                }
                if (treeNode2 != null) {
                    treeNode1.val += treeNode2.val;
                    linkedList2.add(treeNode2.left);
                    linkedList2.add(treeNode2.right);
                    if (treeNode2.left != null) {
                        if (treeNode1.left == null) {
                            TreeNode left = new TreeNode(0);
                            treeNode1.left = left;
                            linkedList1.add(left);
                        } else {
                            linkedList1.add(treeNode1.left);
                        }
                    }
                    if (treeNode2.left == null) {
                        if (treeNode1.left == null) {
                            linkedList1.add(null);
                        } else {
                            linkedList1.add(treeNode1.left);
                        }
                    }
                    if (treeNode2.right != null) {
                        if (treeNode1.right == null) {
                            TreeNode right = new TreeNode(0);
                            treeNode1.right = right;
                            linkedList1.add(right);
                        } else {
                            linkedList1.add(treeNode1.right);
                        }
                    }
                    if (treeNode2.right == null) {
                        if (treeNode1.right == null) {
                            linkedList1.add(null);
                        } else {
                            linkedList1.add(treeNode1.right);
                        }
                    }
                } else {
                    linkedList2.add(null);
                    linkedList2.add(null);
                    if (treeNode1.left == null) {
                        linkedList1.add(null);
                    } else {
                        linkedList1.add(treeNode1.left);
                    }
                    if (treeNode1.right == null) {
                        linkedList1.add(null);
                    } else {
                        linkedList1.add(treeNode1.right);
                    }
                }
            }
        }
        return t1;
    }
}

  class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
