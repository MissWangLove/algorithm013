package com.wz.time1.a18;


import java.util.ArrayList;
import java.util.List;

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
     * 没有思路，走一步看一步。
     * 递归来做，四步走（失败了），看题解
     * 题解的递归有意思，我竟然看不到四步骤，难受，直接说思路吧
     * 深度遍历，从叶子开始向上遍历，直到根节点，整个过程中用一个私有变量存储可能是根节点的节点
     */

    /**
     * 跟简单的写法
     * 最近公共祖先只有两种情况
     * 1. 左右节点刚好是目标节点
     * 2. 左右节点不是目标节点，那就是最先找到的节点最近公共祖先节点
     * 时间复杂度为O(n)
     * 空间复杂度为O(n)
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 终止条件
        if (root == null || root.val == p.val || root.val == q.val) {
            return root;
        }
        // 下一层
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        // 当前层
        if (left != null && right != null) {
            // 说明左右节点更好是目标节点，返回根节点
            return root;
        }
        // 找到最先找到的目标节点，肯定就是最近公共祖先
        return left == null ? right : left;
    }

    /*private TreeNode treeNode;*/

    /**
     * 这道递归题的难点是 终止条件  本层业务逻辑  进入下层太难考虑到了，感觉自己要废了，这里再记录一下
     * 1. 终止条件其实就是很简单的当前节点是null，返回false
     * 2. 当前层的业务逻辑，这到题其实是进入上一层，当前层的业务逻辑才是比较难的，难在什么时候赋予可能为最大深度的公共祖先节点，
     * 什么时候当前层返回true，或者返回false，这个dfs用的太有深意了。
     * 3. 进入上一层
     * 时间复杂度为O(n)
     * 空间复杂度为O(n)
     */
   /* public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        getResult(root, p, q);
        return treeNode;
    }

    private Boolean getResult(TreeNode root, TreeNode p, TreeNode q) {
        // 终止条件,如果当前节点是null,直接返回false
        // 如果当前节点的值等于目标节点的任何一个返回false，或者左子树或者右子树中包含目标节点，返回true
        if (root == null) {
            return false;
        }
        // 从最后一层开始向上升，这里的代码简单，但是逻辑很复杂 **不要人肉递归太重要了，看到这的代码情不自禁就像人肉递归思考下**
        // 需要依靠归纳法和重复子问题
        boolean right = getResult(root.left, p, q);
        boolean left = getResult(root.right, p, q);
        // 处理当前层业务逻辑，当两个都为true或者(当前层的节点等于某个节点并且左子树或右子树有一个包含目标节点)
        // 这里其实就是归纳法和重复子问题的关键点
        if ((right && left) || ((root.val == p.val || root.val == q.val) && (right || left))) {
            treeNode = root;
        }
        return right || left || (root.val == p.val || root.val == q.val) ;
    }*/

}

class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;
  TreeNode(int x) { val = x; }
}