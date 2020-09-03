package com.wz.september.time1.a4;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PreorderTraversalOfNAryTree {
    /**
     * N叉树的前序遍历
     * 给定一个 N 叉树，返回其节点值的前序遍历。
     *
     * 例如，给定一个3叉树:
     *
     * 返回其前序遍历: [1,3,5,6,2,4]。
     *
     *
     *
     * 说明:递归法很简单，你可以使用迭代法完成此题吗?
     */

    /**
     * 已经不是第一遍了，回忆一下
     * 前序遍历： 根 - 左 - 右
     */

    public static void main(String[] args) {
        Node root = new Node(1);
        Node root1 = new Node(3);
        Node root2 = new Node(2);
        Node root3 = new Node(4);
        Node root4 = new Node(5);
        Node root5 = new Node(6);
        List<Node> list = new ArrayList<>();
        list.add(root1);
        list.add(root2);
        list.add(root3);
        List<Node> list2 = new ArrayList<>();
        list2.add(root4);
        list2.add(root5);
        root.children = list;
        root1.children = list2;
        List<Integer> preorder = preorder(root);
        preorder.forEach(System.out::println);
    }

    /**
     * 时间复杂度O(n)
     * 空间复杂度O(n)
     */
    public static List<Integer> preorder(Node root) {
        List<Integer> result = new ArrayList<>();
        LinkedList<Node> linkedList = new LinkedList<>();
        while (root != null || !linkedList.isEmpty()) {
            if (root != null) {
                result.add(root.val);
                List<Node> children = root.children;
                if (children != null) {
                    for (int i = children.size() - 1; i >= 0; i--) {
                        linkedList.add(children.get(i));
                    }
                }
            }
            root = linkedList.pollLast();
        }
        return result;
    }
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
};
