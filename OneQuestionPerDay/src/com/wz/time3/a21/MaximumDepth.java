package com.wz.time3.a21;

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

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode root1 = new TreeNode(9);
        TreeNode root2 = new TreeNode(02);
        TreeNode root3 = new TreeNode(15);
        TreeNode root4 = new TreeNode(7);
        root.left = root1;
        root.right = root2;
        root2.left = root3;
        root2.right = root4;
        System.out.println(maxDepth(root));
    }

    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
        }
    }
    /**
     * 时间复杂度O(n)
     * 空间复杂度O(深度) 递归函数需要栈空间
     */
    /*public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return getResult(root, 1);

    }

    private static int getResult(TreeNode root, int num) {
        if (root.left == null && root.right == null) {
            return num;
        }
        int left = 0;
        int right = 0;
        if (root.left != null) {
            left = getResult(root.left, num + 1);
        }
        if (root.right != null) {
            right = getResult(root.right, num + 1);
        }
        return  Math.max(left, right);
    }*/
}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
