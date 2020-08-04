package com.wz.time2.a8;

import com.sun.crypto.provider.BlowfishCipher;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
     * 1. map存放键和出现的次数，只用一个map，然后在遍历另一个的时候，减这个map的次数，次数为0的时候删除
     * 2. 排序，求交集，一个循环，while循环
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
        List<Integer> list = new ArrayList<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int first = 0;
        int second = 0;

        while (first < nums1.length && second < nums2.length) {
            if (nums1[first] < nums2[second]) {
                first ++;
            } else if (nums1[first] > nums2[second]) {
                second ++;
            } else {
                list.add(nums1[first]);
                first ++;
                second ++;
            }
        }

        int[] ints = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ints[i] = list.get(i);
        }
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
