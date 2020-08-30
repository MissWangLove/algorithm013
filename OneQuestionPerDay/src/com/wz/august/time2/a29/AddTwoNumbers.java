package com.wz.august.time2.a29;

import java.util.LinkedList;

public class AddTwoNumbers {
    /**
     * 两数相加
     * 给出两个非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照逆序的方式存储的，并且它们的每个节点只能存储一位数字。
     *
     * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
     *
     * 您可以假设除了数字 0 之外，这两个数都不会以 0开头。
     *
     * 示例：
     *
     * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
     * 输出：7 -> 0 -> 8
     * 原因：342 + 465 = 807
     */

    /**
     * 利用双端队列来实现，明天看下题解。
     * 时间复杂度O（n）
     * 空间复杂度O（n）
     */

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(2);
        ListNode listNode2 = new ListNode(4);
        ListNode listNode3 = new ListNode(3);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        ListNode listNode4 = new ListNode(5);
        ListNode listNode5 = new ListNode(6);
        ListNode listNode6 = new ListNode(4);
        listNode4.next = listNode5;
        listNode5.next = listNode6;
        ListNode listNode = addTwoNumbers(listNode1, listNode4);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }

    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        LinkedList<ListNode> linkedList = new LinkedList<>();
        // 进位
        int pre = 0;
        while (l1 != null || l2 != null || pre != 0) {
            ListNode temp = new ListNode(pre);
            if (l1 != null) {
                temp.val += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                temp.val += l2.val;
                l2 = l2.next;
            }
            pre = temp.val / 10;
            temp.val = temp.val % 10;
            if (linkedList.size() != 0) {
                linkedList.peekLast().next = temp;
            }
            linkedList.add(temp);
        }
        return linkedList.pollFirst();
    }
}

class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
}