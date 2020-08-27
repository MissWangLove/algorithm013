package com.wz.before.time1.a12;

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
     * 1 递归
     * 看题解
     *
     *
     */

    public static void main(String[] args) {
        System.out.println(addDigits(38));
    }

    /**
     * 找最近循环
     * num如果小于10的时候返回本身
     * 是10-18的话返回的1-9
     * 这么看下来 9是一个轮回
     * 那我们的处理方法可以用对9取余，但是考虑到9的倍数的情况，用1-9举例子，减去1之后对9取余再加上1就可以了
     * 时间复杂度 O(1)
     * 空间复杂度 O(1)
     */
    public static int addDigits(int num) {
        return (num - 1) % 9 + 1;
    }

    /**
     * 递归的优化 取余, 相对于前面的字符串来说，效率更高点
     */
    /*public static int addDigits(int num) {
        if (num >= 0 && num <= 9) {
            return num;
        }
        String s = String.valueOf(num);
        int temp = 0;
        while (num != 0) {
            temp += (num % 10);
            num /= 10;
        }
        return addDigits(temp);
    }*/

    /**
     * 递归做法
     * 时间复杂度是 O(2^n)
     * 空间复杂度为 O(1)
     * @param num
     * @return
     */
    /*public static int addDigits(int num) {
        if (num >= 0 && num <= 9) {
            return num;
        }
        String s = String.valueOf(num);
        int temp = 0;
        for (int i = 0; i < s.length(); i++) {
            temp += (s.charAt(i) - 48);
        }
        return addDigits(temp);
    }*/

}
