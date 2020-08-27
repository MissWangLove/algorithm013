package com.wz.before.time2.a1;

/**
 * @author 王智
 */
public class ClimbStairs {


    /**
     * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
     * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
     * 注意：给定 n 是一个正整数。
     */

    /**
     * 第二遍做,首先拿到这个题就知道这个其实是求斐波那契数列，既然求第n想斐波那契数列，那就简单了
     * 1. 直接递归
     * 2. 记忆性递归（递归树上有很多重复的计算）
     * 3. 不需要递归，将每一个计算都看做一个状态，上面两个都是逆着计算，逆推，这里用正推推到Fn
     * 4. 借用第三个，不用记录每一个状态，只需要记录前两个状态就好
     *
     * 四种方案写完之后大概花了15分钟左右吧，也没认真计时，总之没有看题解，自己手敲出来的。
     */

    public static void main(String[] args) {
        System.out.println(climbStairs(45));
    }

    /**
     * 斐波那契数列
     * 时间复杂度为O(n)
     * 空间复杂度为O(1)
     * @param n
     * @return
     */
    public static int climbStairs(int n) {
        if (n == 1 || n == 2 || n == 0) {
            return n;
        }
        int temp = 0;
        int first = 1;
        int second = 2;
        for (int i = 3; i <= n; i++) {
            temp = first + second;
            first = second;
            second = temp;
        }
        return second;
    }

    /**
     * 动态规划
     * 时间复杂度和空间复杂度都是O(n)
     * @param n
     * @return
     */
    /*public static int climbStairs(int n) {
        if (n == 1 || n == 2 || n == 0) {
            return n;
        }
        int[] arr = new int[n + 1];
        arr[1] = 1;
        arr[2] = 2;
        for (int i = 3; i <= n; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }
        return arr[n];
    }*/

    /**
     * 记忆化递归
     * 时间复杂度为O(n)
     * 空间复杂度为O(n)
     * @param n
     * @return
     */
    /*public static int climbStairs(int n) {
        int[] memoryArr = new int[n + 1];
        memoryArr[0] = 0;
        memoryArr[1] = 1;
        memoryArr[2] = 2;
        return climbSumStairs(n, memoryArr);
    }

    private static int climbSumStairs(int n, int[] nums) {
        if (nums[n] > 0) {
            return nums[n];
        }
        nums[n] = climbSumStairs(n - 1, nums) + climbSumStairs(n - 2, nums);
        return nums[n];
    }*/

    /**
     * 递归解决 最简单直观的解决方案
     * 时间复杂度为 O(2^n)
     * @param n
     * @return
     */
    /*public static int climbStairs(int n) {
        if (n == 1 || n == 2 || n == 0) {
            return n;
        }
        return climbStairs(n - 1) + climbStairs(n - 2);
    }*/

}
