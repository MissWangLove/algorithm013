package com.wz.before.time1.a30;

import java.util.HashMap;

public class TwoSum {

    /**
     * 两数之和，这道题已经做了很多遍，今天就再复习下
     * 最简单的方法：暴力求解，双层for循环
     * 第二种方法，map保存，利用差来做,思路有了，但是在做的时候一直考虑先保存所有的数组元素，这个是不应该，一边遍历一边保存最好。
     */

    public static void main(String[] args) {
        int[] ints = twoSum(new int[]{3, 3}, 6);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }
    }

    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i ++) {
            int temp = target - nums[i];
            if (map.containsKey(temp)) {
                return new int[]{map.get(temp), i};
            } else {
                map.put(nums[i], i);
            }
        }
        return new int[0];
    }
}
