package com.wz.september.time1.a3;

public class HouseRobbery {
    /**
     * 打家劫舍
     * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
     *
     * 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
     *
     * 示例 1：
     *
     * 输入：[1,2,3,1]
     * 输出：4
     * 解释：偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
     *     偷窃到的最高金额 = 1 + 3 = 4 。
     * 示例 2：
     *
     * 输入：[2,7,9,3,1]
     * 输出：12
     * 解释：偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
     *     偷窃到的最高金额 = 2 + 9 + 1 = 12 。
     * 提示：
     *
     * 0 <= nums.length <= 100
     * 0 <= nums[i] <= 400
     */

    /**
     * 脑海中第一次思路，所有偶数之和相加和所有奇数之和相加，看谁大，就是谁
     * 思路错误
     */

    public static void main(String[] args) {
        System.out.println(rob(new int[]{1,2,3,1}));
        System.out.println(rob(new int[]{2,7,9,3,1}));
    }

    /**
     * 时间复杂度 O(n)
     * 空间复杂度 O(1)
     */
    public static int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int length = nums.length;
        if (length == 1) {
            return nums[0];
        }
        // first表示 i - 2的最大值
        int first = nums[0];
        // second 表示 i - 1的最大值
        int second = Math.max(nums[0], nums[1]);
        int loop = 2;
        while (loop < nums.length) {
            int temp = second;
            second = Math.max(first + nums[loop], second);
            first = temp;
            loop ++;
        }
        return second;
    }


    /**
     * 下面方法超时，优化
     * 考虑登楼梯的那个优化
     * 时间复杂度 O(n)
     * 空间复杂度 O(n)
     */
    /*public static int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int length = nums.length;
        if (length == 1) {
            return nums[0];
        }
        int loop = 2;
        int[] max = new int[length];
        max[0] = nums[0];
        max[1] = Math.max(nums[0], nums[1]);
        while (loop < length) {
            max[loop] = Math.max(max[loop - 2] + nums[loop], max[loop - 1]);
            loop ++;
        }
        return max[length - 1];
    }*/

    /**
     * 这么看来这道题也是动态规划了，看题解，不看代码
     * 关键点在于 第n间房子前面总和等于
     * Math.max(n + max[n - 2], max[n - 1])
     * max表示第几间房子的最大值
     *
     * 超时 优化
     */
    /*public static int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        int[] max = new int[nums.length];
        max[0] = nums[0];
        max[1] = Math.max(nums[0], nums[1]);
        return getResult(nums.length - 1, max, nums);
    }

    private static int getResult(int length, int[] max, int[] nums) {
        if (max[length] != 0 || length == 1 || length == 0) {
            return max[length];
        }
        max[length] = Math.max(getResult(length - 2, max, nums) + nums[length], getResult(length - 1, max, nums));
        return max[length];
    }*/

    /*public static int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int even = 0;
        for (int i = 0; i < nums.length; i+=2) {
            even += nums[i];
        }
        int odd = 0;
        for (int i = 1; i < nums.length; i+=2) {
            odd += nums[i];
        }
        return Math.max(even, odd);
    }*/
}
