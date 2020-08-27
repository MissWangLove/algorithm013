package com.wz.before.time1.a17;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

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
     * 1. 使用map来做，数组的值做key，出现的次数做键，然后根据值来进行来排序
     * 2. 使用大顶堆来做
     */


    public static void main(String[] args) {
        int[] nums = new int[]{4,1,-1,2,-1,2,3};
        int[] ints = topKFrequent(nums, 2);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }

    /**
     * 把List换成大顶堆试试
     * 时间复杂度是 O(n)，for循环，小顶堆实现的时候插入和删除的时间复杂度是O(log n)
     * 空间复杂度是 O(n)
     */
    public static int[] topKFrequent(int[] nums, int k) {
        int[] result = new int[k];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            // 优化map赋值
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            /// 上面的写法优化下面这种判断
            /*if (map.containsKey(nums[i])) {
                Integer value = map.get(nums[i]);
                map.put(nums[i], ++ value);
            } else {
                map.put(nums[i], 1);
            }*/
        }
        /// 这里使用了大顶堆,如果使用小顶堆，可以再次简化一下
        /*PriorityQueue<Map.Entry<Integer, Integer>> priorityQueue = new PriorityQueue<>((o1, o2) -> o1.getValue() - o2.getValue());
        for (Map.Entry<Integer, Integer> integerIntegerEntry : map.entrySet()) {
            priorityQueue.add(integerIntegerEntry);
        }
        int index = 0;
        while (index < k) {
            result[index ++] = priorityQueue.poll().getKey();
        }*/
        // 小顶堆实现
        PriorityQueue<Map.Entry<Integer, Integer>> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(Map.Entry::getValue));
        for (Map.Entry<Integer, Integer> integerIntegerEntry : map.entrySet()) {
            priorityQueue.add(integerIntegerEntry);
            if (priorityQueue.size() > k) {
                priorityQueue.poll();
            }
        }
        int index = 0;
        while (!priorityQueue.isEmpty()) {
            result[index ++] = priorityQueue.poll().getKey();
        }
        return result;
    }

    /**
     * Map + List排序
     * 时间复杂度为O(n * log n)
     * 空间复杂度为O(n)
     *
     */
    /*public static int[] topKFrequent(int[] nums, int k) {
        int[] result = new int[k];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                Integer value = map.get(nums[i]);
                map.put(nums[i], ++ value);
            } else {
                map.put(nums[i], 1);
            }
        }
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, (o1, o2) -> o2.getValue() - o1.getValue());
        int index = 0;
        for (Map.Entry<Integer, Integer> integerIntegerEntry : list) {
            if (index == result.length) {
                break;
            }
            result[index ++] = integerIntegerEntry.getKey();
        }
        return result;
    }*/
}
