package com.wz.august.time1.a27;

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

    /**
     * 直接看题解，发现代码很简单，但是思路就是很容易想到了，简单的说就是判断前面的子数组之和和下一位之和与下一位比较
     * 就是 sum + a(i) 和 a(i)比较，但是注意的是计算过程中需要保留最大值，否则最大值在计算过程中会丢失
     * 比较前面子数组的和与当前位的和是否大于当前位，如果大，就保留前者，否则保留后者
     */

    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
    }

    /**
     * 时间复杂度为O(n)
     * 空间复杂度为O(1)
     */
    public static int maxSubArray(int[] nums) {
        int pre = nums[0];
        // 保留当前最大值
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            // 比较前面子数组的和与当前位的和是否大于当前位，如果大，就保留前者，否则保留后者
            pre = Math.max(nums[i] + pre, nums[i]);
            // 比较计算过后的pre是否大于之前的最大值，谁大返回谁
            max = Math.max(pre, max);
        }
        return max;
    }
}
