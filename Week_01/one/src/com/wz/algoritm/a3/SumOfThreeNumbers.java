package com.wz.algoritm.a3;

import java.util.*;

public class SumOfThreeNumbers {

    /**
     * 给你一个包含 n 个整数的数组nums，判断nums中是否存在三个元素 a，b，c ，使得a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
     *
     * 注意：答案中不可以包含重复的三元组。
     *
     *
     * 示例：
     *
     * 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
     *
     * 满足要求的三元组集合为：
     * [
     *   [-1, 0, 1],
     *   [-1, -1, 2]
     * ]
     *
     */

    /**
     * 拿到这个题是懵逼的状态，直接看题解吧
     * 1. 暴力解法： 三层for循环，关键在于不能重复的三元组，题解中使用了set，我想到了吗？（答案是没有） 时间复杂度为O(n^3)
     * 2. 哈希表+两次for循环：第一层喜欢获取target，然后用map存储第二层for循环的内容，记住两数之和的解法
     * 3. 双指针夹逼法：这个解法就非常巧妙了，至少让我现在想想不出来，看了题解才稍微有点印象
     * 开始敲吧，三种都敲一下吧
     */


    public static void main(String[] args) {
        int[] nums = { -1, 0, 1, 2, -1, -4 };
        print(threeSum(nums));
    }

    private static void print(List<List<Integer>> threeSum) {
        for (List<Integer> integers : threeSum) {
            integers.forEach(System.out::println);
            System.out.println("----------------------");
        }
    }

    /**
     * 左右夹逼法: 左右两个指针，看和小于target还是大于还是等于，小于移动左指针，大于移动右指针，等于移动两个指针
     * 前提必须是数组进行了排序，否则的话双指针的移动就是错误的。
     * @param nums
     * @return
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length < 3) {
            return new ArrayList<>();
        }
        Arrays.sort(nums);
        Set<List<Integer>> result = new LinkedHashSet<>();
        for (int i = 0; i < nums.length; i++) {
            int first = i + 1;
            int last = nums.length - 1;
            while (first < last) {
                int sum = nums[first] + nums[last] + nums[i];
                if (sum > 0) {
                    // 这个while循环简直就是神来之笔呀，看呆我了，第一遍看完默写没写出来，又看了一遍才写出来
                    // 这里的while循环两个作用：判断first和last，后面的作用是排除掉相同的元素，简直了，学到了学到了
                    while (first < last && nums[last] == nums[-- last]){};
                } else if (sum < 0) {
                    while (first < last && nums[first] == nums[++ first]){};
                } else {
                    result.add(Arrays.asList(nums[i], nums[first], nums[last]));
                    while (first < last && nums[last] == nums[-- last]){};
                    while (first < last && nums[first] == nums[++ first]){};
                }
            }
        }
        return new ArrayList<>(result);
    }

    /**
     *
     * 哈希表加双循环的写法， 时间复杂度为O(n^2), 时间还是很长，接下里试试左右夹逼法，感觉很牛逼的样子
     * @param nums
     * @return
     */
    /*public static List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length < 3) {
            return new ArrayList<>();
        }
        Set<List<Integer>> result = new LinkedHashSet<>();
        for (int i = 0; i < nums.length - 2; i++) {
            Map<Integer, Integer> map = new HashMap<>(nums.length - i);
            int target = - nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                if (map.containsKey(target - nums[j])) {
                    // 这里需要将List进行排序，否则无法去重
                    List<Integer> lists = Arrays.asList(nums[i], target - nums[j], nums[j]);
                    lists.sort(Comparator.naturalOrder());
                    result.add(lists);
                } else {
                    map.put(nums[j], j);
                }
            }
        }
        return new ArrayList<>(result);
    }*/


    /**
     * 暴力求解，这种解法最简单直接，但是答案不尽如意，超出了时间限制  时间复杂度为O(n^3)
     * @param nums
     * @return
     */
    /*public static List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length < 3) {
            return new ArrayList<>();
        }
        Arrays.sort(nums);
        Set<List<Integer>> result = new LinkedHashSet<>();
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if ( nums[i] + nums[j] + nums[k] == 0 ) {
                        result.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    }
                }
            }
        }
        return new ArrayList<>(result);
    }*/


}
