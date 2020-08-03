package com.wz.time1.a8;

import java.util.*;
import java.util.stream.IntStream;

public class ArrayIntersection {

    /**
     * 给定两个数组，编写一个函数来计算它们的交集。
     * 示例 1：
     *
     * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
     * 输出：[2,2]
     * 示例 2:
     *
     * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
     * 输出：[4,9]
     *
     *
     * 说明：
     *
     * 输出结果中每个元素出现的次数，应与元素在两个数组中出现次数的最小值一致。
     * 我们可以不考虑输出结果的顺序。
     * 进阶：
     *
     * 如果给定的数组已经排好序呢？你将如何优化你的算法？
     * 如果nums1的大小比nums2小很多，哪种方法更优？
     * 如果nums2的元素存储在磁盘上，磁盘内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？
     */

    /**
     * 思路：
     * 1. 暴力求解： 两个map，一个数组
     * 2. 如果数组已经排序了呢？排好序之后可以一次循环来求得结果，也是可以
     * 那有没有更简单的方法呢？在存储的过程中利用了list，因为不知道重复的元素有多少个，可以可以优化呢？使用数组的拷贝吗？
     * 不合适，这里我觉得不能优化？那能优化的还有哪呢？想不出来了，看题解！！！
     * 官方题解对第一个思路做了优化，只用了一个map，然后遍历另一个map的时候，减去map里面出现的次数，知道map的值为0为止，
     * 相对的，我的思路空间复杂度较高
     *
     */

    public static void main(String[] args) {
        int[] nums1 = {1,2,2,1};
        int[] nums2 = {2,2};
        printArr(intersect(nums1, nums2));
    }

    private static void printArr(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }

    /**
     * 如果数组已经排序了呢？可以如何做？循环试试,可以
     * 排序需要耗时。
     * @param nums1
     * @param nums2
     * @return
     */
    public static int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length == 0 || nums2.length == 0) {
            return new int[0];
        }
        List<Integer> list = new ArrayList<>();
        int firstLength = 0;
        int secondLength = 0;
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        while (firstLength < nums1.length && secondLength < nums2.length) {
            if (nums1[firstLength] < nums2[secondLength]) {
                firstLength ++;
            } else if (nums1[firstLength] > nums2[secondLength]) {
                secondLength ++;
            } else {
                list.add(nums1[firstLength]);
                firstLength ++;
                secondLength ++;
            }
        }
        // 这个操作的话相对于创建一个数组，然后for循环，那个更快呢？
        // 试试证明创建数组for循环复制更快。
        System.out.println(System.currentTimeMillis());
        // int[] ints = list.stream().mapToInt(s -> s).toArray();
        int[] ints = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ints[i] = list.get(i);
        }
        System.out.println(System.currentTimeMillis());
        return ints;
    }

    /**
     * 暴力求解
     */
    /*public static int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length == 0 || nums2.length == 0) {
            return new int[0];
        }
        List<Integer> list = new ArrayList<>();
        Map<Integer, Integer> map1 = new HashMap<>(nums1.length);
        Map<Integer, Integer> map2 = new HashMap<>(nums2.length);
        getArrayMap(nums1, map1);
        getArrayMap(nums2, map2);
        for (Map.Entry<Integer, Integer> integerIntegerEntry : map1.entrySet()) {
            Integer key = integerIntegerEntry.getKey();
            if (map2.containsKey(key)) {
                int num = map1.get(key) > map2.get(key) ? map2.get(key) : map1.get(key);
                for (int i = 0; i < num; i++) {
                    list.add(key);
                }
            }
        }
        int[] ints = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ints[i] = list.get(i);
        }
        return ints;
    }

    private static void getArrayMap(int[] nums, Map<Integer, Integer> map) {
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                Integer num = map.get(nums[i]);
                num ++;
                map.put(nums[i], num);
            } else {
                map.put(nums[i], 1);
            }
        }
    }*/


}
