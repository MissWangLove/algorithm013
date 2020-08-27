package com.wz.before.time1.a14;

import java.util.*;

public class PostOrderTraversal {

    /**
     * 给定一个 N 叉树，返回其节点值的后序遍历。
     *
     * 例如，给定一个 3叉树 :
     * 590: https://leetcode-cn.com/problems/n-ary-tree-postorder-traversal/
     * 返回其后序遍历: [5,6,3,2,4,1].
     */

    /**
     * 继续两个思路：
     * 1. 递归
     * 2. 迭代
     */

    public static void main(String[] args) {
        Node root = new Node(1);
        Node node1 = new Node(3);
        Node node2 = new Node(2);
        Node node3 = new Node(4);
        List<Node> list = new ArrayList<>();
        list.add(node1);
        list.add(node2);
        list.add(node3);
        root.children = list;
        Node node4 = new Node(5);
        Node node5 = new Node(6);
        node1.children = Arrays.asList(node4, node5);
        List<Integer> postorder = postorder(root);
        postorder.forEach(System.out::println);
    }

    /**
     * 栈解法
     * 时间复杂度为 O(n)
     * 空间复杂度为 O(n)
     * 栈解法我做的时候没做出来，因为思路有点问题，利用ArrayList想了好久没想出来怎么处理根节点，在遍历儿子的时候是倒着遍历入栈，其实可以利用
     * 双端队列，遍历儿子的时候正着遍历，插入双端队列的时候倒着插入就好，这个思路很好。
     */
    public static List<Integer> postorder(Node root) {
        LinkedList<Integer> result = new LinkedList<>();
        Stack<Node> stack = new Stack<>();
        if (root == null) {
            return result;
        }
        stack.push(root);
        while (!stack.isEmpty()) {
            Node pop = stack.pop();
            result.addFirst(pop.val);
            if (pop.children != null) {
                for (Node child : pop.children) {
                    stack.push(child);
                }
            }

        }
        return result;
    }



    /**
     * 递归解法
     * 时间复杂度为O(n),无论多少个递归，多少个for循环，每个结点只访问一次
     * 空间复杂度是O(n)，每个结点只访问一次加入到list中
     */
    /*public static List<Integer> postorder(Node root) {
        List<Integer> result = new ArrayList<>();
        getTreeNode(root, result);
        return result;
    }

    private static void getTreeNode(Node root, List<Integer> result) {
        if (root != null) {
            List<Node> children = root.children;
            if (children != null) {
                for (Node child : children) {
                    getTreeNode(child, result);
                }
            }
            result.add(root.val);
        }
    }*/


}

class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}
