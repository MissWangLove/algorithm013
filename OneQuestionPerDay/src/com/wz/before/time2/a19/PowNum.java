package com.wz.before.time2.a19;

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
     * 递归的做法来做，其实是要考虑各种特殊情况
     * 就是long的转换必不可少
     * 时间复杂度是O(log n)
     * 空间复杂度是O(log n)
     */
    public static double myPow(double x, int n) {
        if (x == 1 || n == 0) {
            return 1;
        }
        long N = n;
        return N > 0 ? myResult(x, N) : 1 / myResult(x, - N);
    }

    private static double myResult(double x, long n) {
        if (n == 0) {
            return 1.0;
        }
        double temp = myResult(x, n / 2);
        return n % 2 == 0 ? temp * temp : temp * temp * x;
    }

}
