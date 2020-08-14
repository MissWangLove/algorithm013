package com.wz.time1.a19;

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
     * 自己的写法： while循环，失败，第一次失败在int转long死活转不过去，第二次失败失败在2147483648这个计算量太大
     *
     */

    public static void main(String[] args) {
        System.out.println(myPow( 2.00000D, -2147483648));
    }

    /**
     * 根据外国友人高票改写，这里递归无论如何也不能使用int
     * 时间复杂度为O(log n)
     */
    public static double myPow(double x, long n) {
        if (n == 0 || x == 1) {
            return 1;
        }
        // long N = n;
        if (n < 0) {
            x = 1 / x;
            // N = - N;
            n = - n;
        }
//        return N % 2 == 0 ? myPow(x * x, N / 2) :  x * myPow(x * x, N / 2);
        return n % 2 == 0 ? myPow(x * x, n / 2) :  x * myPow(x * x, n / 2);
    }
    /**
     * 分治的写法：划分子问题
     * 求myPow( x,  n)其实就是求myPow(x,  n/2)，当n是奇数或者偶数要不同的计算
     * 时间复杂度为 O(log n)
     */
    /*public static double myPow(double x, int n) {
        if (n == 0 || x == 1) {
            return 1;
        }
        // 这里必须要有这一步
        long N = n;
        return N > 0 ? myResult(x, N) : 1.0 / myResult(x, -N);
    }

    *//**
     * 这里我懵了一下，不知道这个temp是如何来的？想了一会，这里是我懵了，可能最近有点累了吧，感觉状态不是很好
     *//*
    private static double myResult(double x, long n) {
        // 终止条件
        if (n == 0) {
            return 1.0;
        }
        // 进入下一层
        double temp = myResult(x, n / 2);
        // 当前层的业务逻辑
        return n % 2 == 0 ? temp * temp : temp * temp * x;
    }*/

    /**
     * 失败的写法
     */
    /*public static double myPow(double x, int n) {
        if (n == 0 || x == 1) {
            return 1;
        }
        double num;
        long floor = n;
        if (n > 0) {
            num = x;
        } else {
            num = 1/x;
            x = num;
            floor = - (long) n;
        }

        for (int i = 1; i < floor; i++) {
            x *= num;
        }
        return x;
    }*/
}
