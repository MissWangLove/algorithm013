package com.wz.september.time1.a26;

import sun.reflect.generics.tree.Tree;

import java.util.HashMap;
import java.util.Map;

public class ConstructABinaryTree {
    /**
     * 从中序与后序遍历序列构造二叉树
     *
     * 根据一棵树的中序遍历与后序遍历构造二叉树。
     *
     * 注意:
     * 你可以假设树中没有重复的元素。
     *
     * 例如，给出
     *
     * 中序遍历 inorder = [9,3,15,20,7]
     * 后序遍历 postorder = [9,15,7,20,3]
     * 返回如下的二叉树：
     *
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     */

    /**
     * 发现我最近飘了，不想动脑子了，稍微懂点脑子，就不想思考了，这道题其实就是一个找规律的问题。
     * 后续遍历的最后一个节点永远是根节点，右根节点，左根节点
     * 再根据中序遍历来划分左子树和右子树就可以
     */
    int post_idx;
    int[] postorder;
    int[] inorder;
    Map<Integer, Integer> idx_map = new HashMap<Integer, Integer>();

    // 迭代的写法后面再看
    public TreeNode buildTree(int[] inorder, int[] postorder) {

        return null;
    }

    /// 递归写法 时间复杂度为 O(n)  空间复杂度为O(n)
    /*public TreeNode buildTree(int[] inorder, int[] postorder) {
       post_idx = postorder.length - 1;
       this.postorder = postorder;
       this.inorder = inorder;
        for (int i = 0; i < inorder.length; i++) {
            idx_map.put(inorder[i], i);
        }
       return getTreeNode(0, inorder.length - 1);
    }

    private TreeNode getTreeNode(int left, int right) {
        if (left > right) {
            return null;
        }
        // 构建根节点
        TreeNode root = new TreeNode(postorder[post_idx]);
        // 获取节点索引
        Integer index = idx_map.get(postorder[post_idx]);
        post_idx --;
        // 构建树结构
        root.right = getTreeNode(index + 1, right);
        root.left = getTreeNode(left, index - 1);
        return root;
    }*/

    public static void main(String[] args) {
        ConstructABinaryTree constructABinaryTree = new ConstructABinaryTree();
        TreeNode treeNode = constructABinaryTree.buildTree(new int[]{9, 3, 15, 20, 7}, new int[]{9, 15, 7, 20, 3});
        System.out.println(treeNode.val);
    }

}

class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;
  TreeNode(int x) { val = x; }
}