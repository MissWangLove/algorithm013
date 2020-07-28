package com.wz.time1.a2;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author 王智
 */
public class ArrAddOne {

    /**
     * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
     *
     * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
     *
     * 你可以假设除了整数 0 之外，这个整数不会以零开头。
     *
     * 示例 1:
     *
     * 输入: [1,2,3]
     * 输出: [1,2,4]
     * 解释: 输入数组表示数字 123。
     * 示例 2:
     *
     * 输入: [4,3,2,1]
     * 输出: [4,3,2,2]
     * 解释: 输入数组表示数字 4321。
     */

    /**
     * 我觉得这道题应该就是要看为9的情况，加1会变成10
     * 1. 先将数组中的数字进行合并成一个，int加一之后再分割  时间复杂度是O(1)  (数组过长就会失败，因为中间用到了转换String和转换Integer)
     * 2. 直接在数组上进行操作，最后一位加1，如果大于9，进1， 需要考虑扩容的问题，这里使用数组的拷贝来解决扩容的问题（那这个题的难点就在于 考虑 9,9,9等多个9的情况）
     */


    public static void main(String[] args) {
        int[] digits = {9,9};
        printArr(plusOne(digits));
    }

    /**
     * 思路一样，流程优化下
     * @param digits
     * @return
     */
    public static int[] plusOne(int[] digits) {
        for (int length = digits.length - 1; length >= 0; length--) {
            digits[length] ++;
            digits[length] = digits[length] % 10;
            if (digits[length] != 0) {
                return digits;
            }
        }
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }

    /**
     * 时间的复杂度为O(n)
     * @param digits
     * @return
     */
    /*public static int[] plusOne(int[] digits) {
        int[] result = new int[digits.length + 1];
        for (int length = digits.length - 1; length >= 0; length--) {
            digits[length] = digits[length] + 1;
            if(digits[length] <= 9) {
                break;
            } else if (length != 0){
                digits[length] = 0;
            } else {
                digits[length] = 0;
                System.arraycopy(digits, 0, result, 1, digits.length);
                result[0] = 1;
            }
        }
        if (result[0] == 1) {
            return result;
        } else {
            return digits;
        }


    }*/

    /**
     * 方法失败  不适用于数组太长的情况
     * @param arr
     */
   /* public static int[] plusOne(int[] digits) {
        List<Integer> collect = Arrays.stream(digits).boxed().collect(Collectors.toList());
        String str = collect.stream().map(String::valueOf).collect(Collectors.joining());
        Integer i = Integer.parseInt(str) + 1;
        int[] ints = Arrays.stream(String.valueOf(i).split("")).mapToInt(temp -> Integer.parseInt(temp)).toArray();
        return ints;

    }*/

    private static void printArr(int[] arr) {
        for (int i : arr) {
            System.out.println(i);
        }
    }

}
