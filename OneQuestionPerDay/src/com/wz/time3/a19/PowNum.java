package com.wz.time3.a19;

public class PowNum {

    /**
     * 实现pow(x, n)，即计算 x 的 n 次幂函数。
     *
     * 示例 1:
     *
     * 输入: 2.00000, 10
     * 输出: 1024.00000
     * 示例2:
     *
     * 输入: 2.10000, 3
     * 输出: 9.26100
     * 示例3:
     *
     * 输入: 2.00000, -2
     * 输出: 0.25000
     * 解释: 2-2 = 1/22 = 1/4 = 0.25
     * 说明:
     *
     * -100.0 <x< 100.0
     * n是 32 位有符号整数，其数值范围是[−231,231− 1] 。
     */

    /**
     * 递归实现，其实就是分为奇数和偶数的不同算法
     */

    public static void main(String[] args) {
        System.out.println(myPow( 2.00000D, -2147483648));
    }

    /**
     * 第三遍做
     * 递归实现
     * 时间复杂度是O(log n)
     * 空间复杂度是O(log n)
     */
    public static double myPow(double x, int n) {
        if (x == 1 || n == 0) {
            return 1.0;
        }
        long N = n;
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }
        return getResult(x, N);
    }

    private static double getResult(double x, long N) {
        if (x == 1 || N == 0) {
            return 1;
        }
        return N % 2 == 0 ? getResult(x * x, N / 2) : x * getResult(x * x, N / 2);
    }

}
