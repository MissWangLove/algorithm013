package com.wz.time2.a3;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author wz157
 */
public class SumOfTwoNumbers {
    /**
     * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
     *
     * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
     *
     * 给定 nums = [2, 7, 11, 15], target = 9
     *
     * 因为 nums[0] + nums[1] = 2 + 7 = 9
     * 所以返回 [0, 1]
     */

    /**
     * 第二遍，拿到题，直接看要求，每一种输入只会对应一种答案，所以相对简单
     * 1. 暴力求解，直接双层for循环暴力求解，简单直接明了
     * 2. 利用哈希表，一层循环，如何做呢？遍历的时候利用target - 当前遍历的值获取另一个值，判断在哈希表中是否存在
     */



    public static void main(String[] args) {
        int[] arr = {2, 7, 11, 15};
        printArr(twoSum(arr, 9));
    }


    /**
     * 两遍哈希表和一遍哈希表，利用哈希表查找快O(1)的时间复杂度，来查找，时间复杂度为O(n)
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return new int[0];
    }

    /**
     * 暴力求解, 时间复杂度为 O(n^2)
     * @return
     */
    /*public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if(nums[i] + nums[j] == target) {
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }
        return new int[0];
    }*/

    private static void printArr(int[] arr) {
        for (int i : arr) {
            System.out.println(i);
        }
    }
}
