package com.wz.september.time3.a6;

public class HouseRobberyII {
    /**
     * 打家劫舍II
     * 你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都围成一圈，这意味着第一个房屋和最后一个房屋是紧挨着的。
     * 同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
     *
     * 给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。
     *
     * 示例1:
     *
     * 输入: [2,3,2]
     * 输出: 3
     * 解释: 你不能先偷窃 1 号房屋（金额 = 2），然后偷窃 3 号房屋（金额 = 2）, 因为他们是相邻的。
     * 示例 2:
     *
     * 输入: [1,2,3,1]
     * 输出: 4
     * 解释: 你可以先偷窃 1 号房屋（金额 = 1），然后偷窃 3 号房屋（金额 = 3）。
     *     偷窃到的最高金额 = 1 + 3 = 4 。
     */

    /**
     * 相对于打家劫舍1加了一个条件，就是第一间房子和最后一间房子是相邻的，这会造成什么影响呢？
     * 答案就是dp方程会发生变化
     *
     * dp：
     * 1. 重复子问题： problem（i） = Math.max(subProblem(i - 2) + 自己 , subProblem(i - 1))
     * 2. 状态数组： f（i）
     * 3， dp方程：与打家劫舍1相同，只是在计算f【i】的时候分两种，第一个和最后一个 f[i] = Mahth.max(f[i - 1], f[i - 2] + 自己)
     *
     *
     */

    /// 打家劫舍的代码如下，接下来就是拆分两个单列了
   /* public static int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        if (dp.length == 1) {
            return dp[0];
        }
        dp[1] = Math.max(dp[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[nums.length - 1];
    }*/

    public static int rob(int[] nums) {

        return 0;
    }


    public static void main(String[] args) {
        System.out.println(rob(new int[]{1,2,3,1}));
        System.out.println(rob(new int[]{2,3,2}));
    }
}
