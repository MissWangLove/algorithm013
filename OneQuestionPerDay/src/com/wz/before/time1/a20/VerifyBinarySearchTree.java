package com.wz.before.time1.a20;

import java.util.*;

public class VerifyBinarySearchTree {

    /**
     * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
     *
     * 假设一个二叉搜索树具有如下特征：
     *
     * 节点的左子树只包含小于当前节点的数。
     * 节点的右子树只包含大于当前节点的数。
     * 所有左子树和右子树自身必须也是二叉搜索树。
     * 示例1:
     *
     * 输入:
     *     2
     *    / \
     *   1   3
     * 输出: true
     * 示例2:
     *
     * 输入:
     *     5
     *    / \
     *   1   4
     *     / \
     *    3   6
     * 输出: false
     * 解释: 输入为: [5,1,4,null,null,3,6]。
     *     根节点的值为 5 ，但是其右子节点值为 4 。
     *
     */

    /**
     * 思路：递归来做，千万不要人肉递归
     * 左子树 < 根节点 < 右子树
     * 终止条件：左子树大于根节点或者右右子树小于根节点，返回false，或者递归完成，知道根节点为null为止
     * 当前层逻辑：判断根节点是否大于左结点，是否小于右结点'
     * 进入下一层：分别进入左结点和右结点
     * 清理当前层逻辑：不需要
     * 思路错误，错误在只判断了当前根和左右结点，而非左右子树
     * =============================
     * 换种思路，二叉搜索树的中序遍历是升序的，那只要中序遍历完成之后，排序，然后比对排序前和排序后就可以了
     */

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        TreeNode left1 = new TreeNode(5);
        TreeNode right1 = new TreeNode(15);
        TreeNode right1Left1 = new TreeNode(6);
        TreeNode right1Right1 = new TreeNode(20);
        root.left = left1;
        root.right = right1;
        right1.left = right1Left1;
        right1.right = right1Right1;
        System.out.println(isValidBST(root));
    }

    /**
     * 优化中序遍历
     * 在递归的过程中判断，因为现在不是中序遍历，所以可以在中序遍历的时候保留上一次的结点，如果当前值小于上一次的值，那就必然不是搜索二叉树。
     * 时间复杂度和空间复杂度都是O(n)
     */
    public static boolean isValidBST(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null;
        // 中序遍历
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            TreeNode pop = stack.pop();
            if (pre != null && pre.val >= pop.val) {
                return false;
            }
            pre = pop;
            root = pop.right;
        }
        return true;
    }

    /**
     * 先中序遍历，然后排序比对
     * 时间复杂度就是 O(n log n)
     * 空间复杂度为O(n)
     */
    /*public static boolean isValidBST(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        // 中序遍历
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            TreeNode pop = stack.pop();
            result.add(pop.val);
            root = pop.right;
        }
        List<Integer> newList = new ArrayList<>(new HashSet<>(result));
        // 考虑有重复元素的情况，必然不是搜索二叉树
        if (newList.size() != result.size()) {
            return false;
        }
        Collections.sort(newList);
        // 比较
        for (int i = 0; i < newList.size(); i++) {
            if (!newList.get(i).equals(result.get(i))) {
                return false;
            }
        }
        return true;
    }*/

    /**
     * 错误思路
     */
    /*public static boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        // 深度遍历
        boolean left = isValidBST(root.left);
        boolean right = isValidBST(root.right);
        return left && right && (root.left == null || root.val > root.left.val) && (root.right == null || root.val < root.right.val);
    }*/

}



class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}