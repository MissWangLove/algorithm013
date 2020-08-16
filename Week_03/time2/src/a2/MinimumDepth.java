package a2;


public class MinimumDepth {

    /**
     * 给定一个二叉树，找出其最小深度。
     *
     * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
     *
     * 说明:叶子节点是指没有子节点的节点。
     *
     * 示例:
     *
     * 给定二叉树[3,9,20,null,null,15,7],
     *
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     * 返回它的最小深度 2.
     */

    /**
     * 直接递归来做，最小深度就是取最小值，递归的要素：
     * 1. 终止条件，root为null
     * 2. 当前层业务逻辑，深度加1
     * 3. 进入下一层
     * 4. 清楚当前层的状态
     * 在计算左右子树的最小深度的时候少了一个约束条件，就是left和right结点本身不能为null
     */

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        TreeNode treeNode1 = new TreeNode(2);
        treeNode.left = treeNode1;
        System.out.println(minDepth(treeNode));
    }

    /**
     * 时间复杂度为O(n)
     * 空间复杂度就是最小深度
     */
    public static int minDepth(TreeNode root) {
        
        return  1;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
