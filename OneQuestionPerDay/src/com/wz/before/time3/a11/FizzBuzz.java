package com.wz.before.time3.a11;

import java.util.ArrayList;
import java.util.List;

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
     * 这道题不难，思路也很简单
     * 1. 取余
     * 2. 计数法，其实就是声明两个变量，一个计算3，一个计算5，当前一个等于3置0 添加Fizz，当后一个等于5置0添加Buzz，同时等于3和5是，添加FizzBuzz
     */

    public static void main(String[] args) {
        List<String> strings = fizzBuzz(15);
        strings.forEach(System.out::println);
    }


    /**
     * 取余
     * 时间复杂度为 O(n)
     * 空间复杂度为 O(n)
     */
    public static List<String> fizzBuzz(int n) {
        List<String> result = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
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
