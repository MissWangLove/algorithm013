package time2.a1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SequenceTraversal {
    /**
     * 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
     *
     * 示例：
     * 二叉树：[3,9,20,null,null,15,7],
     *
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     * 返回其层次遍历结果：
     *
     * [
     *   [3],
     *   [9,20],
     *   [15,7]
     * ]
     */

    /**
     * bfs的标准模板代码
     */

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode node1 = new TreeNode(9);
        TreeNode node2 = new TreeNode(20);
        TreeNode node3 = new TreeNode(15);
        TreeNode node4 = new TreeNode(7);
        root.left = node1;
        root.right = node2;
        node2.left = node3;
        node2.right = node4;
        List<List<Integer>> lists = levelOrder(root);
        for (List<Integer> list : lists) {
            for (Integer integer : list) {
                System.out.print(integer + ",");
            }
            System.out.println();
        }
    }

    /**
     * 这个其实就是bfs的模板代码，司机硬背就好，觉得没啥的，标准的代码模版
     * 时间复杂度就是O(n)
     * 空间复杂度也是O(n)
     */
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        LinkedList<TreeNode> linkedList = new LinkedList<>();
        linkedList.push(root);
        while (!linkedList.isEmpty()) {
            int length = linkedList.size();
            List<Integer> list = new ArrayList<>(length);
            for (int i = 0; i < length; i++) {
                TreeNode pop = linkedList.pop();
                list.add(pop.val);
                if (pop.left != null) {
                    linkedList.push(pop.left);
                }
                if (pop.right != null) {
                    linkedList.push(pop.right);
                }
            }
            result.add(list);
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
