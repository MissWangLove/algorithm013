package com.wz.before.time1.a7;

import java.util.ArrayList;

/**
 * @author wangzhi
 */
public class CircularDequeDemo {

    /**
     * 设计实现双端队列。
     * 你的实现需要支持以下操作：
     *
     * MyCircularDeque(k)：构造函数,双端队列的大小为k。
     * insertFront()：将一个元素添加到双端队列头部。 如果操作成功返回 true。
     * insertLast()：将一个元素添加到双端队列尾部。如果操作成功返回 true。
     * deleteFront()：从双端队列头部删除一个元素。 如果操作成功返回 true。
     * deleteLast()：从双端队列尾部删除一个元素。如果操作成功返回 true。
     * getFront()：从双端队列头部获得一个元素。如果双端队列为空，返回 -1。
     * getRear()：获得双端队列的最后一个元素。如果双端队列为空，返回 -1。
     * isEmpty()：检查双端队列是否为空。
     * isFull()：检查双端队列是否满了。
     * 示例：
     *
     * MyCircularDeque circularDeque = new MycircularDeque(3); // 设置容量大小为3
     * circularDeque.insertLast(1);			        // 返回 true
     * circularDeque.insertLast(2);			        // 返回 true
     * circularDeque.insertFront(3);			        // 返回 true
     * circularDeque.insertFront(4);			        // 已经满了，返回 false
     * circularDeque.getRear();  				// 返回 2
     * circularDeque.isFull();				        // 返回 true
     * circularDeque.deleteLast();			        // 返回 true
     * circularDeque.insertFront(4);			        // 返回 true
     * circularDeque.getFront();				// 返回 4
     *
     * 提示：
     *
     * 所有值的范围为 [1, 1000]
     * 操作次数的范围为 [1, 1000]
     * 请不要使用内置的双端队列库。
     *
     *
     */

    /**
     * 双端队列队列的实现，这个的实现首先要看队列的特性
     * 1. 队列是先进先出的特性
     * 2. 双端队列，也就是必须有首尾指针
     *
     * 接下来说实现：脑海中两个思路，一个是数组实现，一个是链表实现，但是看下面的插入操作多，明显链表实现起来更加方便。
     *
     */


    public static void main(String[] args) {
        MyCircularDeque circularDeque = new MyCircularDeque(3); // 设置容量大小为3
        System.out.println(circularDeque.insertLast(1)); // 返回 true
        System.out.println(circularDeque.insertLast(2)); // 返回 true
        System.out.println(circularDeque.insertFront(3)); // 返回 true
        System.out.println(circularDeque.insertFront(4)); // 已经满了，返回 false
        System.out.println(circularDeque.getRear());  // 返回 2
        System.out.println(circularDeque.isFull()); // 返回 true
        System.out.println(circularDeque.deleteLast());	// 返回 true
        System.out.println(circularDeque.insertFront(4)); // 返回 true
        System.out.println(circularDeque.getFront()); // 返回 4

    }
}


class MyCircularDeque {

    private Integer length;
    // Linkedlist本身就是一个双端队列结构
    private ArrayList<Integer> arrayList;


    /** Initialize your data structure here. Set the size of the deque to be k. */
    public MyCircularDeque(int k) {
        length = k;
        arrayList = new ArrayList<>(3);
    }

    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        if (arrayList.size() != length) {
            arrayList.add(0, value);
            return true;
        }
        return false;
    }

    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if (arrayList.size() != length) {
            arrayList.add(value);
            return true;
        }
        return false;
    }

    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if (arrayList.size() != 0) {
            arrayList.remove(0);
            return true;
        }
        return false;
    }

    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if (arrayList.size() != 0) {
            arrayList.remove(arrayList.size() - 1);
            return true;
        }
        return false;
    }

    /** Get the front item from the deque. */
    public int getFront() {
        if (arrayList.size() != 0) {
            return arrayList.get(0);
        }
        return -1;
    }

    /** Get the last item from the deque. */
    public int getRear() {
        if (arrayList.size() != 0) {
            return arrayList.get(arrayList.size() - 1);
        }
        return -1;
    }

    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return arrayList.size() == 0;
    }

    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return arrayList.size() == length;
    }
}

/*class MyCircularDeque {

    private Integer length;
    // Linkedlist本身就是一个双端队列结构
    private LinkedList<Integer> linkedList = new LinkedList<>();
    private Integer rear = -1;

    *//** Initialize your data structure here. Set the size of the deque to be k. *//*
    public MyCircularDeque(int k) {
        length = k;
    }

    *//** Adds an item at the front of Deque. Return true if the operation is successful. *//*
    public boolean insertFront(int value) {
        if (linkedList.size() != length) {
            linkedList.addFirst(value);
            rear = value;
            return true;
        }
        return false;
    }

    *//** Adds an item at the rear of Deque. Return true if the operation is successful. *//*
    public boolean insertLast(int value) {
        if (linkedList.size() != length) {
            linkedList.addLast(value);
            rear = value;
            return true;
        }
        return false;
    }

    *//** Deletes an item from the front of Deque. Return true if the operation is successful. *//*
    public boolean deleteFront() {
        if (linkedList.size() != 0) {
            linkedList.pollFirst();
            return true;
        }
        return false;
    }

    *//** Deletes an item from the rear of Deque. Return true if the operation is successful. *//*
    public boolean deleteLast() {
        if (linkedList.size() != 0) {
            linkedList.pollLast();
            return true;
        }
        return false;
    }

    *//** Get the front item from the deque. *//*
    public int getFront() {
        if (linkedList.size() != 0) {
            return linkedList.peekFirst();
        }
        return -1;
    }

    *//** Get the last item from the deque. *//*
    public int getRear() {
        if (linkedList.size() != 0) {
            return linkedList.peekLast();
        }
        return -1;
    }

    *//** Checks whether the circular deque is empty or not. *//*
    public boolean isEmpty() {
        return linkedList.size() == 0;
    }

    *//** Checks whether the circular deque is full or not. *//*
    public boolean isFull() {
        return linkedList.size() == length;
    }
}*/

