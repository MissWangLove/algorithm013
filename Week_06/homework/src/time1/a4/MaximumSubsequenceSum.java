package time1.a4;

public class MaximumSubsequenceSum {
    /**
     *  最大子序和
     * 给定一个整数数组 nums，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
     *
     * 示例:
     *
     * 输入: [-2,1,-3,4,-1,2,1,-5,4]
     * 输出: 6
     * 解释:连续子数组[4,-1,2,1] 的和最大，为6。
     * 进阶:
     *
     * 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
     *
     */

    /**
     * 思路呢：dp
     * 1. 寻找重复子问题： problem（i） = Math.max(subProblem(i - 1) + f[i], f[i]);
     * 2. 状态数组：max[i]
     * 3. 状态方程： max = Math.max(max(i - 1) + f[i], f[i]);
     *
     * 状态方程错误，导致产生了错误的题解：
     * max（i） = Math.max(pre（i）+ f[i], max（i - 1）);
     * pre表示当前层计算的和，max表示上一层所求的最大子序列和。保留当前层的计算结果很重要。在下一层的时候要使用
     *
     * 最大子序列和 = 当前元素自身最大或者包含之前最大后最大
     */

    public static int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int max = nums[0];
        int pre = nums[0];
        for (int i = 1; i < nums.length; i++) {
            pre = Math.max(pre + nums[i], nums[i]);
            max = Math.max(pre, max);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
    }
}
