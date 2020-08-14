package com.wz.time3.a12;

public class AddUpEveryone {

    /**
     * 给定一个非负整数 num，反复将各个位上的数字相加，直到结果为一位数。
     *
     * 示例:
     *
     * 输入: 38
     * 输出: 2
     * 解释: 各位相加的过程为：3 + 8 = 11, 1 + 1 = 2。 由于2 是一位数，所以返回 2。
     * 进阶:
     * 你可以不使用循环或者递归，且在 O(1) 时间复杂度内解决这个问题吗？
     */

    /**
     * 1. 递归来做
     * 2. 数学解法
     */

    public static void main(String[] args) {
        System.out.println(addDigits(38));
    }

    /**
     * 数学解法有点忘记了，其实就是归纳法 + 最小重复单元
     * 时间复杂度和空间复杂度都是 O(1)
     */
    /*public static int addDigits(int num) {
        return (num - 1) % 9 + 1;
    }*/

    /**
     * 递归如何来做
     * 时间复杂度就是 O(2^n)
     * 空间复杂度就是 O(n)
     */
    public static int addDigits(int num) {
        // 终止条件
        if (num < 10) {
            return num;
        }
        // 当前层的逻辑
        int sum = 0;
        // 取余
        while (num != 0) {
            sum += num % 10;
            num /= 10;
        }
        // 进入下层
        return addDigits(sum);
    }

}
