package com.wz.before.time3.a14;


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
     * 迭代写法
     * 这种解法又忘记了，不过我可以背下来，这个和前序遍历混了一些，懵了。
     */
    public static List<Integer> postorder(Node root) {
        LinkedList<Integer> result = new LinkedList<>();
        Stack<Node> stack = new Stack<>();
        stack.add(root);
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
     * 递归做法
     */
    /*public static List<Integer> postorder(Node root) {
        List<Integer> result = new ArrayList<>();
        getResult(root, result);
        return result;
    }

    private static void getResult(Node root, List<Integer> result) {
        if (root != null) {
            if (root.children != null) {
                for (Node child : root.children) {
                    getResult(child, result);
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
