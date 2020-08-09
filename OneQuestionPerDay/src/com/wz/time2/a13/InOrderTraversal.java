package com.wz.time2.a13;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author wangzhi
 */
public class InOrderTraversal {

    /**
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
     * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
     */

    /**
     * 1. 递归
     * 2. 栈结构
     */

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
//        TreeNode node3 = new TreeNode(1);
        root.left = null;
        root.right = node1;
        node1.left = node2;
        node1.right = null;
        List<Integer> integers = inorderTraversal(root);
        integers.forEach(System.out::println);
    }

    /**
     * 看了题解的栈结构
     * 思路就是先把所有的左结点全部入栈，然后弹出一个，判断右结点，和递归的思路是一样的
     * 时间复杂度为O(n)
     * 空间复杂度为O(n)
     */
    /*public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            result.add(curr.val);
            curr = curr.right;
        }

        return result;
    }*/

    /**
     * 说实话，递归我没做出来，没做出来的原因是不知道什么给List中添加元素，一直在考虑什么时候添加左子树，什么时候添加右子树，什么时候添加根结底，
     * 其实不用考虑这么多，每个结点都是根结点，只要讲根结点保存到集合中，那就将所有的结点的都保存到集合中了。
     * 时间复杂度其实就是 O(n)，每个结点只访问一次
     * 空间复杂度利用了list，所以也是O(n)
     */
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        getTreeNode(root, list);
        return list;
    }

    public static void getTreeNode(TreeNode node, List<Integer> list) {
        if (node != null) {
            if (node.left != null) {
                getTreeNode(node.left, list);
            }
            list.add(node.val);
            if (node.right != null) {
                getTreeNode(node.right, list);
            }
        }

    }


}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
