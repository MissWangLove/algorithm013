package com.wz.before.time2.a2;

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
     * 本来有两种思路，但是有一种思路就是错误的，就是转换成Integer在进行转换，所以思路就只剩下一种，直接在数组上进行操作
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
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i] = (++ digits[i]) % 10;
            if (digits[i] != 0) {
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



    private static void printArr(int[] arr) {
        for (int i : arr) {
            System.out.println(i);
        }
    }

}
