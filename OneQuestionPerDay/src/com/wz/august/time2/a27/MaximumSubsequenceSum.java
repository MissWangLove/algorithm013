package com.wz.august.time2.a27;

public class MaximumSubsequenceSum {
    /**
     * 最大子序和
     * 给定一个整数数组 nums，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
     *
     * 示例:
     *
     * 输入: [-2,1,-3,4,-1,2,1,-5,4] =
     * 输出: 6
     * 解释:连续子数组[4,-1,2,1] 的和最大，为6。
     * 进阶:
     *
     * 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
     */

    /**
     * 连续子数组和最大，至少包含一个元素，所以说最大值可以是1个数，暴力求解，枚举出所有可能情况
     * 这种写法太费时，思考有没有简单方法。
     */


    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
    }

    /**
     * 时间复杂度为O(n)
     * 空间复杂度为O(1)
     */
    public static int maxSubArray(int[] nums) {
        // 最大值
        int max = nums[0];
        // 前一位
        int pre = nums[0];
        for (int i = 1; i < nums.length; i++) {
            pre = Math.max(pre + nums[i], nums[i]);
            max = Math.max(pre, max);
        }
        return max;
    }
}
