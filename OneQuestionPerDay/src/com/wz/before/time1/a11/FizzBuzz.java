package com.wz.before.time1.a11;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 王智
 */
public class FizzBuzz {

    /**
     * 写一个程序，输出从 1 到 n 数字的字符串表示。
     *
     * 1. 如果n是3的倍数，输出“Fizz”；
     *
     * 2. 如果n是5的倍数，输出“Buzz”；
     *
     * 3.如果n同时是3和5的倍数，输出 “FizzBuzz”。
     *
     * 示例：
     *
     * n = 15,
     *
     * 返回:
     * [
     *     "1",
     *     "2",
     *     "Fizz",
     *     "4",
     *     "Buzz",
     *     "Fizz",
     *     "7",
     *     "8",
     *     "Fizz",
     *     "Buzz",
     *     "11",
     *     "Fizz",
     *     "13",
     *     "14",
     *     "FizzBuzz"
     * ]
     */

    /**
     * 1. 最简单的做法，暴力求解，循环n次，然后每一次都判断（这道题是考察啥的？）
     */

    public static void main(String[] args) {
        List<String> strings = fizzBuzz(15);
        strings.forEach(System.out::println);
    }

    /**
     * 时间复杂度O(n^2)
     */
    public static List<String> fizzBuzz(int n) {
        List<String> result = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if(i % 15 == 0) {
                result.add("FizzBuzz");
            } else if (i % 3 == 0) {
                result.add("Fizz");
            } else if (i % 5 == 0) {
                result.add("Buzz");
            } else {
                result.add(String.valueOf(i));
            }
        }
        return result;
    }

}