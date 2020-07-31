package com.wz.time1.a5;

import java.util.List;

/**
 * @author 王智
 */
public class MergeTwoOrderedLinkedLists {

    /**
     * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
     *
     * 示例：
     *
     * 输入：1->2->4, 1->3->4
     * 输出：1->1->2->3->4->4
     *
     */

    /**
     * 思路：
     * 1. 脑海中第一个思路，暴力求解。while循环来做,思路没错，又卡在如何返回上面了
     * 2. 递归来做吧(思路没错，代码又没写出来，哎，凉凉)
     */




    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode listNode2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        print(mergeTwoLists(listNode1, listNode2));
    }

    /**
     * 递归来做，思路没错，但是代码没写出来
     * 总结写不出来的原因：
     * 1. 对于链表结构熟悉程度不够（甚至可以说是java对象引用等基础不扎实）
     * 2. 对于递归的理解还是不深刻，递归的边界条件是什么？ 什么时候返回
     * @param l1
     * @param l2
     * @return
     */
    /*public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }*/


    /**
     * 暴力求解，已知有序，就相对容易
     * @param l1  第一个
     * @param l2  第二个
     * @return
     */
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(-1);
        ListNode node = result;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                node.next = l1;
                l1 = l1.next;
            } else {
                node.next = l2;
                l2 = l2.next;
            }
            // node的改变不等于result的改变
            // 这里应该就是引用的区别的
            node = node.next;
        }
        if (l1 == null) {
            node.next = l2;
        }
        if (l2 == null) {
            node.next = l1;
        }
        return result.next;
    }

    private static void print(ListNode listNode) {
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }


}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
