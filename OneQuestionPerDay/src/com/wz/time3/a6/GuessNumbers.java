package com.wz.time3.a6;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wangzhi
 */
public class GuessNumbers {

    /**
     * 你在和朋友一起玩 猜数字（Bulls and Cows）游戏，该游戏规则如下：
     *
     * 你写出一个秘密数字，并请朋友猜这个数字是多少。
     * 朋友每猜测一次，你就会给他一个提示，告诉他的猜测数字中有多少位属于数字和确切位置都猜对了（称为“Bulls”, 公牛），有多少位属于数字猜对了
     * 但是位置不对（称为“Cows”, 奶牛）。朋友根据提示继续猜，直到猜出秘密数字。
     *
     * 请写出一个根据秘密数字和朋友的猜测数返回提示的函数，返回字符串的格式为 xAyB ，x 和 y 都是数字，A 表示公牛，用B表示奶牛。
     *
     * xA 表示有 x 位数字出现在秘密数字中，且位置都与秘密数字一致。
     * yB 表示有 y 位数字出现在秘密数字中，但位置与秘密数字不一致。
     * 请注意秘密数字和朋友的猜测数都可能含有重复数字，每位数字只能统计一次。
     *
     *
     *
     * 示例 1:
     *
     * 输入: secret = "1807", guess = "7810"
     * 输出: "1A3B"
     * 解释: 1公牛和3奶牛。公牛是 8，奶牛是 0, 1和 7。
     * 示例 2:
     *
     * 输入: secret = "1123", guess = "0111"
     * 输出: "1A1B"
     * 解释: 朋友猜测数中的第一个 1是公牛，第二个或第三个 1可被视为奶牛。
     *
     *
     * 说明: 你可以假设秘密数字和朋友的猜测数都只包含数字，并且它们的长度永远相等。
     *
     */

    /**
     * 简化题目，其实就是两个数字，有多少位是相同的，有多少位是数字相同但位置是不同
     * 1. 利用数组来实现，思路就是比较的时候判断，声明两个变量存储A和B，比较的时候利用数组
     * 2. 利用Map来做，先求数字出现的总和（A+B），再求A，相减得B
     */

    public static void main(String[] args) {
        System.out.println(getHint("1807", "7810"));
        System.out.println(getHint("1123", "0111"));
    }

    /**
     * 时间复杂度为 O(n)
     * 空间复杂度为 O(1)  虽然利用了数组，可是数组的长度是固定的
     */
    public static String getHint(String secret, String guess) {
        int a = 0;
        int b = 0;
        int[] arr = new int[10];
        for (int i = 0; i < secret.length(); i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                a ++;
            } else {
                // char转换的时候可以利用静态方法
                /*int aIndex = secret.charAt(i) - 48;
                int bIndex = guess.charAt(i) - 48;*/
                int aIndex = Character.getNumericValue(secret.charAt(i));
                int bIndex = Character.getNumericValue(guess.charAt(i));
                if (arr[aIndex] < 0) {
                    b ++;
                }
                if (arr[bIndex] > 0) {
                    b ++;
                }
                arr[aIndex] ++;
                arr[bIndex] --;
            }
        }
        return a + "A" + b + "B";
    }



}
