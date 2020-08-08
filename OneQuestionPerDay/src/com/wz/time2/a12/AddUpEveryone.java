package com.wz.time2.a12;

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
     * 数学解法，9一个循环，9的倍数额外处理
     * 时间复杂度 O(1)
     * 空间复杂度 O(1)
     */
    public static int addDigits(int num) {
        return (num - 1) % 9 + 1;
    }

    /**
     * 递归来做
     * 时间复杂度为 O（n）
     * 空间复杂度为 O（1）
     */
    /*public static int addDigits(int num) {
        if (num < 10) {
            return num;
        }
        int temp = 0;
        while (num != 0) {
            temp += num % 10;
            num /= 10;
        }
        return addDigits(temp);
    }*/



}
