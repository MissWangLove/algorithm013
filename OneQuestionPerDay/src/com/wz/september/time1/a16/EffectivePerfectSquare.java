package com.wz.september.time1.a16;

public class EffectivePerfectSquare {
    /**
     * 有效的完全平方数
     *
     * 给定一个正整数 num，编写一个函数，如果 num 是一个完全平方数，则返回 True，否则返回 False。
     *
     * 说明：不要使用任何内置的库函数，如 sqrt。
     *
     * 示例 1：
     *
     * 输入：16
     * 输出：True
     * 示例 2：
     *
     * 输入：14
     * 输出：False
     */

    /**
     * 不使用库函数的话，可以直接暴力求解，我一个一个试不行吗？
     * 暴力求解： 超出时间限制
     * 继续思考：二分查找，时间复杂度O（log n）
     */

    public static boolean isPerfectSquare(int num) {
        if (num == 0 || num == 1) {
            return true;
        }
        // 为什么使用long类型，因为在计算平方的时候可能超出范围。
        long left = 2;
        long right = num / 2;
        long middle;
        long square;
        while (left <= right) {
            middle = left + (right - left) / 2;
            square = middle * middle;
            if (square == num) {
                return true;
            }
            if (square > num) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }
        return false;
    }

    // 暴力求解
    /*public static boolean isPerfectSquare(int num) {
        if (num == 0 || num == 1) {
            return true;
        }
        int sqrt = 1;
        while (sqrt * sqrt < num) {
            sqrt ++;
        }
        return sqrt * sqrt == num;
    }*/

    public static void main(String[] args) {
        System.out.println(isPerfectSquare(16));
        System.out.println(isPerfectSquare(14));
        System.out.println(isPerfectSquare(808201));
    }
}
