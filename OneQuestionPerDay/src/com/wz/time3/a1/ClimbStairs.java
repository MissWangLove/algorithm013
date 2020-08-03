package com.wz.time3.a1;

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
     * 第三遍做
     * 1. 这个就是斐波那契数列的求解，那就最简单的递归
     * 2. 画出递归树，发现计算了很多相同的值，那就记忆化递归
     * 3. 记忆化递归的变形，利用数组来记录计算的值
     * 4. 计算f（n）只需要知道n-1和n-2，所以只需要记录这两个值就可以
     */

    public static void main(String[] args) {
        // 1836311903
        System.out.println(climbStairs(45));
    }

    /**
     * 斐波那契数列
     * 时间复杂度为O(n)
     * 空间复杂度为O(1)
     * @param n
     * @return
     */
    /*public static int climbStairs(int n) {
        if (n == 1 || n == 2) {
            return n;
        }
        int first = 1;
        int second = 2;
        for (int i = 3; i <= n; i++) {
            int temp = first + second;
            first = second;
            second = temp;
        }
        return second;
    }*/

    /**
     * 动态规划
     * 时间复杂度和空间复杂度都是O(n)
     * @param n
     * @return
     */
    /*public static int climbStairs(int n) {
        if (n == 1 || n == 2) {
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
    public static int climbStairs(int n) {
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
    }

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
