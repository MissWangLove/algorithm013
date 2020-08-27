package com.wz.before.time2.a18;

public class NearestCommonAncestor {

    /**
     * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
     *
     * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
     *
     * 例如，给定如下二叉树: root =[3,5,1,6,2,0,8,null,null,7,4]
     *
     * 示例 1:
     *
     * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
     * 输出: 3
     * 解释: 节点 5 和节点 1 的最近公共祖先是节点 3。
     * 示例2:
     *
     * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
     * 输出: 5
     * 解释: 节点 5 和节点 4 的最近公共祖先是节点 5。因为根据定义最近公共祖先节点可以为节点本身。
     *
     *
     * 说明:
     *
     * 所有节点的值都是唯一的。
     * p、q 为不同节点且均存在于给定的二叉树中。
     */

    /**
     * 思路：
     * 经过昨天的一遍，今天应该可以顺利写下来
     * 1. 深度遍历 DFS，然后一层一层向上找
     * 2. 与第一个方法类似，不过是找到了任意一个节点就返回。
     * 因为总的可能就两种情况
     * 1. 刚好在某个节点的左右节点，这个时候就是根节点
     * 2. 不在左右节点，那就是先找到的目标节点就是公共祖先了
     */

    /**
     * 第二种方案
     * 时间复杂度和空间复杂度都是 O(n)
     */
    /// 第二种方案
    /*public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 终结条件
        if (root == null || root.val == p.val || root.val == q.val) {
            return root;
        }
        // 当前层的逻辑和进入下一层
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) {
            return root;
        }
        return left == null ? right : left;
    }*/

    private static TreeNode result;

    /**
     * 老师讲解的思路
     * 时间复杂度和空间复杂度都是 O(n)
     * 老师的思路就是深度遍历了，重要的是什么时候，这个才是关键
     * 时间复杂度和空间复杂度都是 O(n)
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        getTreeNode(root, p, q);
        return result;
    }


    private static Boolean getTreeNode(TreeNode root, TreeNode p, TreeNode q) {
        // 终止条件
        if (root == null) {
            return false;
        }
        boolean left = getTreeNode(root.left, p, q);
        boolean right = getTreeNode(root.right, p, q);
        if (left && right || ((root.val == p.val || root.val == q.val) && (left || right))) {
            result = root;
        }
        return left || right || (root.val == p.val || root.val == q.val);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}