package com.wz.before.time1.a4;

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
     * 第一遍： 自己尝试写
     * 思路，奇数和偶数分开处理(又失败了)，看到官方题解，这种思路是对的，就是我的代码写失败了，吐血了都，看看别人的代码怎么写去
     * 1. 每次交换两个节点，所以只传两个节点就好，返回第二个节点, first和second
     * 2. 奇数偶数分开处理难住我的其实是如何返回节点，官方题解给了思路，试试, 还是没写出来，原来有思路代码也不是那么容易写出来的，吐了
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
    public static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy  = new ListNode(-1);
        dummy.next = head;
        ListNode prevNode = dummy;
        while (head != null && head.next != null) {
            ListNode first = head;
            ListNode second = head.next;

            // 指向头结点
            prevNode.next = second;
            first.next = second.next;
            second.next = first;

            // 跳转到第三个
            prevNode = first;
            head = first.next;

        }
        return dummy.next;
    }


    /**
     * 两两交换， 核心就在于递归，递归返回两个节点交换的头结点，这点很重要
     * @param head
     * @return
     */
    /*public static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode first = head;
        ListNode second = head.next;
        first.next = swapPairs(second.next);
        second.next = first;
        return second;
    }
*/

}


class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
