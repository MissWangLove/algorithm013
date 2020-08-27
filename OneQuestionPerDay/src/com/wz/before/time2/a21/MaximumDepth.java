package com.wz.before.time2.a21;

public class MaximumDepth {

    /**
     * 给定一个二叉树，找出其最大深度。
     *
     * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
     *
     * 说明:叶子节点是指没有子节点的节点。
     *
     * 示例：
     * 给定二叉树 [3,9,20,null,null,15,7]，
     *
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     * 返回它的最大深度3 。
     */

    /**
     * 这道题递归来实现，只要判断左右子树哪个结点更深即可
     * 想法对着，可是我一直想着人肉递归，然后就绕进去了，就懵逼了
     */

    /**
     * 时间复杂度O(n)
     * 空间复杂度O(深度) 递归函数需要栈空间
     */
    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
        }

    }
}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
