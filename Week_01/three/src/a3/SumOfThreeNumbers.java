package a3;

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
     * 这个其实就是两数之和的变形 a + b = -c，不过两数之和答案只有一种，但是这个有多重情况，结果不能包含重复的。
     * 1. 暴力求解：三层for循环，枚举所有情况
     * 2. 一层for + while循环
     * 3. 就是借助两数之和的写法，两个map+shuangfor循环，但是没有第二种方法牛掰
     */




    public static void main(String[] args) {
        int[] nums = { 3,0,-2,-1,1,2 };
        print(threeSum(nums));
    }

    private static void print(List<List<Integer>> threeSum) {
        for (List<Integer> integers : threeSum) {
            integers.forEach(System.out::println);
            System.out.println("----------------------");
        }
    }

    /**
     * 双指针移动法
     * @param nums
     * @return
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> result = new LinkedHashSet<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int first = i + 1;
            int end = nums.length - 1;
            while (first < end) {
                int sum = nums[first] + nums[end] + nums[i];
                if (sum < 0) {
                    // while循环减少重复的数据，很重要，没有while循环，时间会大大延长
                    while (first < end && nums[first] == nums[++ first]) {};
                } else if (sum > 0) {
                    while (first < end && nums[end] == nums[-- end]) {};
                } else {
                    List<Integer> integers = Arrays.asList(nums[i], nums[first], nums[end]);
                    integers.sort(Comparator.naturalOrder());
                    result.add(integers);
                    while (first < end && nums[first] == nums[++ first]) {};
                    while (first < end && nums[end] == nums[-- end]) {};
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
        for (int i = 0; i < nums.length - 1; i++) {
            int target = - nums[i];
            // 接下来就是两数之和的解法
            Map<Integer, Integer> map = new LinkedHashMap<>(nums.length - i);
            for (int j = i + 1; j < nums.length; j++) {
                if (map.containsKey(target - nums[j])) {
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
