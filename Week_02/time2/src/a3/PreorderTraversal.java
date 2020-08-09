package a3;

import java.beans.PropertyEditorSupport;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author wangzhi
 */
public class PreorderTraversal {

    /**
     * 给定一个二叉树，返回它的前序遍历。
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
     * 输出: [1,2,3]
     * 进阶:递归算法很简单，你可以通过迭代算法完成吗？
     */

    /**
     * 二叉树的前序遍历，在每日一题中写了二叉树的中序遍历，这里就写一下二叉树的前序遍历
     * 1. 递归
     * 2. 迭代算法
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
        List<Integer> integers = preorderTraversal(root);
        integers.forEach(System.out::println);
    }


    /**
     * 使用迭代
     * 时间复杂度为 O(n) 其实不管哪种方法，每个结点都访问且仅访问一次
     * 空间复杂度为 O(n)
     */
    /*public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode pop = stack.pop();
            result.add(pop.val);
            if (pop.right != null) {
                stack.push(pop.right);
            }
            if (pop.left != null) {
                stack.push(pop.left);
            }
        }

        return result;
    }*/

    /**
     * 递归
     */
    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        addlist(root, result);
        return result;
    }

    public static void addlist(TreeNode treeNode, List<Integer> list) {
        if (treeNode != null) {
            list.add(treeNode.val);
            if (treeNode.left != null) {
                addlist(treeNode.left, list);
            }
            if (treeNode.right != null) {
                addlist(treeNode.right, list);
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
