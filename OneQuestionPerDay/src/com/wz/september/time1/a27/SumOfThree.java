package com.wz.september.time1.a27;

import java.lang.reflect.Array;
import java.util.*;

public class SumOfThree {

    /**
     * 三数之和
     *
     * 给你一个包含 n 个整数的数组nums，判断nums中是否存在三个元素 a，b，c ，使得a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
     *
     * 注意：答案中不可以包含重复的三元组。
     * 示例：
     *
     * 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
     *
     * 满足要求的三元组集合为：
     * [
     *   [-1, 0, 1],
     *   [-1, -1, 2]
     * ]
     */

    public static List<List<Integer>> threeSum(int[] nums) {
        HashSet<List<Integer>> result = new HashSet<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
           int first = i + 1;
           int end = nums.length - 1;
           while (first < end) {
               int sum = nums[i] + nums[first] + nums[end];
               if (sum < 0) {
                   while (first < end && nums[first] == nums[++ first]);
               }
               if (sum > 0) {
                   while (first < end && nums[end] == nums[-- end]);
               }
               if (sum == 0) {
                   List<Integer> list = Arrays.asList(nums[i], nums[first], nums[end]);
                   result.add(list);
                   while (first < end && nums[first] == nums[++ first]);
                   while (first < end && nums[end] == nums[-- end]);

               }
               /*if ( nums[i] + nums[first] + nums[end] == 0) {
                   ArrayList<Integer> list = new ArrayList<>();
                   list.add(nums[i]);
                   list.add(nums[first]);
                   list.add(nums[end]);
                   result.add(list);
                   first ++;
                   end --;
               } else if (nums[first] + nums[end] > - nums[0]) {
                   end --;
               } else if (nums[first] + nums[end] < - nums[0]) {
                   first ++;
               }*/
           }
        }
        return new ArrayList<>(result);
    }

    public static void main(String[] args) {
        List<List<Integer>> lists = threeSum(new int[]{-1, 0, 1, 2, -1, -4});
        for (List<Integer> list : lists) {
            for (Integer integer : list) {
                System.out.print(integer + ", ");
            }
            System.out.println();
        }
    }
}
