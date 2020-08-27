package com.wz.before.time2.a11;

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
     * 由于第一遍顺利做出来，并且没花费多久时间，所以今天第二遍就用不同的思路来做
     */

    public static void main(String[] args) {
        List<String> strings = fizzBuzz(15);
        strings.forEach(System.out::println);
    }


    public static List<String> fizzBuzz(int n) {
        List<String> result = new ArrayList<>();
        int three = 0;
        int five = 0;
        for (int i = 1; i <= n; i++) {
            three ++;
            five ++;
            if (three == 3 && five == 5) {
                result.add("FizzBuzz");
                three = 0;
                five = 0;
            } else if (three == 3) {
                result.add("Fizz");
                three = 0;
            } else if (five == 5) {
                result.add("Buzz");
                five = 0;
            } else {
                result.add(String.valueOf(i));
            }

        }

        return result;
    }

    /**
     * 时间复杂度O(n^2)
     */
    /*public static List<String> fizzBuzz(int n) {
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
    }*/

}
