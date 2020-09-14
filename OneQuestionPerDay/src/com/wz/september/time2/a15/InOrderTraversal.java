package com.wz.september.time2.a15;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InOrderTraversal {
    /**
     * 二叉树的中序遍历
     *
     * 给定一个二叉树，返回它的中序遍历。
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
     * 输出: [1,3,2]
     * 进阶:递归算法很简单，你可以通过迭代算法完成吗？
     */

    /**
     * 无非就是dfs，要使用迭代算法，那就是bfs
     * 中序遍历： 左 - 根 - 右
     */

    /**
     * 这个迭代写法还是不熟悉，还得练。总的思路就是先把所有的左结点（包括根结点）先放入到栈中，然后取出最后一个，开始遍历他的右结点。如此如此。
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        return result;
    }



}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}