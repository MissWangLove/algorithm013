package time2.a2;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class FindMaxNumInTreeRow {
    /**
     * 在每个树行中找最大值
     *
     * 您需要在二叉树的每一行中找到最大的值。
     *
     * 示例：
     *
     * 输入:
     *
     *           1
     *          / \
     *         3   2
     *        / \   \
     *       5   3   9
     *
     * 输出: [1, 3, 9]
     */

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(5);
        TreeNode node4 = new TreeNode(3);
        TreeNode node5 = new TreeNode(9);
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.right = node5;
        List<Integer> list = largestValues(root);
        list.forEach(System.out::println);
    }

    /**
     * 这道题相对简单，使用bfs的话比较好做，其实就是标准的bfs代码就可以处理。
     * 时间复杂度和空间复杂度都是O(n)
     */
    /// bfs的代码
    /*public static List<Integer> largestValues(TreeNode root) {
        LinkedList<Integer> result = new LinkedList<>();
        Deque<TreeNode> deque = new LinkedList<>();
        deque.add(root);
        while (!deque.isEmpty()) {
            int length = deque.size();
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < length; i++) {
                TreeNode poll = deque.poll();
                max = Math.max(max, poll.val);
                if (poll.left != null) {
                    deque.add(poll.left);
                }
                if (poll.right != null) {
                    deque.add(poll.right);
                }
            }
            result.add(max);
        }
        return result;
    }*/

    /**
     * dfs实现
     */
    public static List<Integer> largestValues(TreeNode root) {
        LinkedList<Integer> result = new LinkedList<>();
        getResult(1, root, result);
        return result;
    }

    private static void getResult(int index, TreeNode root, LinkedList<Integer> result) {
        if (root == null) {
            return ;
        }
        if (result.size() < index) {
            result.add(root.val);
        } else {
            if(result.get(index - 1) < root.val) {
                result.remove(index - 1);
                result.add(index - 1, root.val);
            }
        }
        getResult(index + 1, root.left, result);
        getResult(index + 1, root.right, result);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
