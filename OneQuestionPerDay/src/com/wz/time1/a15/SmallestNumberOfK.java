package com.wz.time1.a15;

import java.util.Arrays;
import java.util.PriorityQueue;

public class SmallestNumberOfK {

    /**
     * 剑指offer - 40 最小的k个数
     * 输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
     *
     *
     *
     * 示例 1：
     *
     * 输入：arr = [3,2,1], k = 2
     * 输出：[1,2] 或者 [2,1]
     * 示例 2：
     *
     * 输入：arr = [0,1,2,1], k = 1
     * 输出：[0]
     *
     *
     * 限制：
     *
     * 0 <= k <= arr.length <= 10000
     * 0 <= arr[i]<= 10000
     *
     */

    /**
     * 思路
     * 1. 将数组进行排序，然后取前几个就好
     * 没思路了，看视频
     * 2. 使用小顶堆
     */

    public static void main(String[] args) {
        int[] arr = new int[]{3,2,1};
        int[] leastNumbers = getLeastNumbers(arr, 2);
        printArr(leastNumbers);
    }

    private static void printArr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    /**
     * 小顶堆实现
     * 时间复杂度为 O(n * log k)
     * 空间复杂度为 O(n)
     * 但是比较下来还是先排序，再取的时间更短
     */
    public static int[] getLeastNumbers(int[] arr, int k) {
        int[] result = new int[k];
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(arr.length);
        for (int i = 0; i < arr.length; i ++) {
            priorityQueue.add(arr[i]);
        }
        for (int i = 0; i < result.length; i++) {
            result[i] = priorityQueue.poll();
        }
        return result;
    }

    /**
     * 排序取值
     * 时间复杂度为 O(n * log n)
     * 空间复杂度为 O(k)
     */
    /*public static int[] getLeastNumbers(int[] arr, int k) {
        int[] result = new int[k];
        int index = 0;
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i ++) {
            if (index == result.length) {
                break;
            }
            result[index ++] = arr[i];
        }
        return result;
    }*/

}
