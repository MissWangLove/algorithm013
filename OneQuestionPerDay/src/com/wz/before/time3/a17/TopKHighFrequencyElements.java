package com.wz.before.time3.a17;

import java.util.*;

public class TopKHighFrequencyElements {
    /**
     * 给定一个非空的整数数组，返回其中出现频率前k高的元素。
     *
     *
     *
     * 示例 1:
     *
     * 输入: nums = [1,1,1,2,2,3], k = 2
     * 输出: [1,2]
     * 示例 2:
     *
     * 输入: nums = [1], k = 1
     * 输出: [1]
     *
     *
     * 提示：
     *
     * 你可以假设给定的k总是合理的，且 1 ≤ k ≤ 数组中不相同的元素的个数。
     * 你的算法的时间复杂度必须优于 O(n log n) ,n是数组的大小。
     * 题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的。
     * 你可以按任意顺序返回答案。
     */

    /**
     * 1. 利用map来做，用map来存放，然后用List里面放EntrySet，然后排序，取前面的就好
     * 2. 利用大顶堆来做，Java中就是PriorityQueue
     */


    public static void main(String[] args) {
        int[] nums = new int[]{4,1,-1,2,-1,2,3};
        int[] ints = topKFrequent(nums, 2);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }

    /**
     * 利用Map来做
     * 时间复杂度为 O(n log n)
     * 空间复杂度是 O(n)
     */
    /*public static int[] topKFrequent(int[] nums, int k) {
        int[] result = new int[k];
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort((o1, o2) -> o2.getValue() - o1.getValue());
        int index = 0;
        while (index < k) {
            result[index] = list.get(index).getKey();
            index ++;
        }
        return result;
    }*/

    /**
     * 使用大顶堆来实现
     * 时间复杂度为 O(n)
     * 空间复杂度为 O(n)
     */
    // 不同的解法
    public static int[] topKFrequent(int[] nums, int k) {
        int[] result = new int[k];
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>(Comparator.comparingInt(Map.Entry::getValue));
        for (Map.Entry<Integer, Integer> integerIntegerEntry : map.entrySet()) {
            queue.add(integerIntegerEntry);
            if (queue.size() > k) {
                queue.poll();
            }
        }
        int index = 0;
        while (!queue.isEmpty()) {
            result[index ++] = queue.poll().getKey();
        }
        return result;
    }
}
