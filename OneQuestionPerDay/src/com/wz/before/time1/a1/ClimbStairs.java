package com.wz.before.time1.a1;

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
     * 这道题我第一眼看完全没有思路，找不到规律，于是就去看了题解，才发现规律就是斐波那契数列，
     * 斐波那契数列最普通最常用的方法就是递归
     */

    public static void main(String[] args) {

        // 1. 递归解决
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
        if (n == 1) {
            return 1;
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
        // 没有n=1的话，当n==1的时候就会出现越界异常
        if (n == 1) {
            return 1;
        }
        int[] memoryArr = new int[n + 1];
        memoryArr[1] = 1;
        memoryArr[2] = 2;
        for (int i = 3; i <= n; i++) {
            memoryArr[i] = memoryArr[i - 1] + memoryArr[i - 2];
        }
        return memoryArr[n];
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
        return climbSumStairs(n, memoryArr);
    }

    private static int climbSumStairs(int n, int[] nums) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
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
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        return climbStairs(n - 2) + climbStairs(n - 1);
    }*/

}
