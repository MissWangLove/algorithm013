package com.wz.september.time1.a30;

import java.util.LinkedList;

public class FillNextRigthNode2 {
    /**
     * 填充每个节点的下一个右侧节点指针 II
     *
     * 给定一个二叉树
     *
     * struct Node {
     *   int val;
     *   Node *left;
     *   Node *right;
     *   Node *next;
     * }
     * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
     *
     * 初始状态下，所有next 指针都被设置为 NULL。
     *
     * 进阶：
     *
     * 你只能使用常量级额外空间。
     * 使用递归解题也符合要求，本题中递归程序占用的栈空间不算做额外的空间复杂度。
     *
     * 示例：
     *
     * 输入：root = [1,2,3,4,5,null,7]
     * 输出：[1,#,2,3,#,4,5,7,#]
     * 解释：给定二叉树如图 A 所示，你的函数应该填充它的每个 next 指针，以指向其下一个右侧节点，如图 B 所示。
     */

    /**
     * 直接bfs就好, 这道题目的意思理解了之后其实不难，直接bfs就可以理解
     * 时间复杂度为 O(n)
     * 空间复杂度为 O(n)
     */

    public Node connect(Node root) {
        if (root == null) {
            return root;
        }
        LinkedList<Node> linkedList = new LinkedList<>();
        linkedList.add(root);
        while (!linkedList.isEmpty()) {
            int loop = linkedList.size();
            for (int i = 0; i < loop; i++) {
                Node node = linkedList.pollFirst();
                if (i != loop - 1) {
                    Node right = linkedList.peekFirst();
                    node.next = right;
                    /*if (right != null) {
                        node.next = new Node(right.val, null, null, null);
                    } else {
                        node.next = null;
                    }*/
                }
                if (node.left != null) {
                    linkedList.add(node.left);
                }
                if (node.right != null) {
                    linkedList.add(node.right);
                }
            }

        }

        return root;
    }

    public static void main(String[] args) {
        Node node4 = new Node(4, null, null, null);
        Node node5 = new Node(5, null, null, null);
        Node node7 = new Node(7, null, null, null);
        Node node2 = new Node(2, node4, node5, null);
        Node node3 = new Node(3, null, node7, null);
        Node node1 = new Node(1, node2, node3, null);
        FillNextRigthNode2 fillNextRigthNode2 = new FillNextRigthNode2();
        Node connect = fillNextRigthNode2.connect(node1);
        System.out.println(connect.val);
    }
}


class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
