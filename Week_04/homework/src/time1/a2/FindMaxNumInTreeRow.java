package time1.a2;

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
    /*public static List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Deque<TreeNode> deque = new LinkedList<>();
        deque.add(root);
        while (!deque.isEmpty()) {
            int length = deque.size();
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < length; i++) {
                TreeNode pop = deque.pop();
                max = Math.max(max, pop.val);
                if (pop.left != null) {
                    deque.addLast(pop.left);
                }
                if (pop.right != null) {
                    deque.addLast(pop.right);
                }
            }
            result.add(max);
        }
        return result;
    }*/

    /**
     * 尝试用dfs去解决
     * 顺利解决，这应该算是我第二次使用dfs解决问题，第一个是生成括号
     * 时间复杂度和空间复杂度都是O(n)
     */
    public static List<Integer> largestValues(TreeNode root) {
        LinkedList<Integer> result = new LinkedList<>();
        if (root == null) {
            return result;
        }
        // 递归实现
        getResult(1, result, root);
        return result;
    }

    private static void getResult(int i, LinkedList<Integer> result, TreeNode root) {
        if (root == null) {
            return;
        }

        // 业务逻辑
        if (result.size() < i) {
            result.add(root.val);
        } else {
            if (result.get(i - 1) < root.val) {
                result.remove(i - 1);
                result.add(i - 1, root.val);
            }
        }


        // 进入下一层
        if (root.left != null) {
            getResult(i + 1, result, root.left);
        }
        if (root.right != null) {
            getResult(i + 1, result, root.right);
        }
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
