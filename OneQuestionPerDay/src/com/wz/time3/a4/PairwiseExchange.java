package com.wz.time3.a4;

/**
 * @author 王智
 */
public class PairwiseExchange {

    /**
     * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
     *
     * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
     *
     * 示例:
     *
     * 给定 1->2->3->4, 你应该返回 2->1->4->3.
     */

    /**
     * 这个题第三遍做我都有点害怕，哎，阴影呀。
     * 1. 用循环来做吧，只要保证头结点，内部交换就好
     * 2. 递归来做，递归做法的重点就在于每次交换完节点之后返回交换后的第一个节点
     */



    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        ListNode listNode1 = new ListNode(2);
        ListNode listNode2 = new ListNode(3);
        ListNode listNode3 = new ListNode(4);
        listNode.next = listNode1;
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = null;
        print(swapPairs(listNode));
    }

    private static void print(ListNode listNode) {
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

    /**
     * 奇数偶数分开处理，这个逻辑有点难，没想通
     * @param head
     * @return
     */
    /*public static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode result = new ListNode(-1);
        result.next = head;
        ListNode temp = result;
        while (head != null && head.next != null) {
            ListNode first = head;
            ListNode second = head.next;

            // 保留头结点，前两个节点交换之后的头结点就是原来的第二个节点
            temp.next = second;
            first.next = second.next;
            second.next = first;

            // temp指向第二个节点
            temp = first;
            // head指向了第三个结点
            head = first.next;
        }


        return result.next;
    }*/


    /**
     * 两两交换， 核心就在于递归，递归返回两个节点交换的头结点，这点很重要
     * @param head
     * @return
     */
    public static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode first = head;
        ListNode second = head.next;
        first.next = swapPairs(second.next);
        second.next = first;
        return second;
    }

}


class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
