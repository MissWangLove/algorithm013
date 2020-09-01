package com.wz.september.time2.a1;

public class Palindrome {
    /**
     * 回文数
     * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
     *
     * 示例 1:
     *
     * 输入: 121
     * 输出: true
     * 示例2:
     *
     * 输入: -121
     * 输出: false
     * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
     * 示例 3:
     *
     * 输入: 10
     * 输出: false
     * 解释: 从右向左读, 为 01 。因此它不是一个回文数。
     *
     */

    /**
     * 1. 转化为字符串，然后equals进行比对
     * 2. 转换为字符串再转化为数组，首尾比对
     */

    public static void main(String[] args) {
        System.out.println(isPalindrome(121));
        // System.out.println(isPalindrome(-121));
        System.out.println(isPalindrome(10));
    }

    /**
     * 反转一半的解法(有趣的解法)
     * 时间复杂度O（n）
     * 空间复杂度O（1）
     */
    public static boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }
        int palindrome = 0;
        while (palindrome < x) {
            palindrome = palindrome * 10 + x % 10;
            x /= 10;
        }
        return x == palindrome || x == palindrome / 10;
    }

    /**
     * 不使用字符串，如何解决
     * 时间复杂度为 O（n）
     * 空间复杂度为 O（n）
     * 还有更简单的方法吗？
     */
    /*public static boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        LinkedList<Integer> list = new LinkedList<>();
        while (x > 0) {
            list.add(x % 10);
            x /= 10;
        }
        while (list.size() > 1) {
           if (!Objects.equals(list.pollLast(), list.pollFirst()))  {
               return false;
           }
        }
        return true;
    }*/

    /**
     * 时间复杂度O（n）
     * 空间复杂度O（n）
     */
    /*public static boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        String s = String.valueOf(x);
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length / 2; i++) {
            if (chars[i] != chars[chars.length - 1 - i]) {
                return false;
            }
        }
        return true;
    }*/

    /**
     * 时间复杂度O（n）  reverse消耗时间
     * 空间复杂度O（1）
     */
   /* public static boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        String s = String.valueOf(x);
        StringBuilder reverse = new StringBuilder(s).reverse();
        return reverse.toString().equals(String.valueOf(x));
    }*/
}
