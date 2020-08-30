package com.wz.august.time3.a29;

public class ShortestPalindrome {

    /**
     * 给定一个字符串 s，你可以通过在字符串前面添加字符将其转换为回文串。找到并返回可以用这种方式转换的最短回文串。
     *
     * 示例1:
     *
     * 输入: "aacecaaa"
     * 输出: "aaacecaaa"
     * 示例 2:
     *
     * 输入: "abcd"
     * 输出: "dcbabcd"
     *
     */

    /**
     * 怎么考虑：
     * 其实就是找最大对称位，遍历一遍，找到最大对称位，然后补
     */

    public static void main(String[] args) {
        System.out.println(shortestPalindrome("aacecaaa"));
        System.out.println(shortestPalindrome("abb"));
        System.out.println(shortestPalindrome("abcd"));
    }

    public static String shortestPalindrome(String s) {

        return null;
    }

   /* public static String shortestPalindrome(String s) {

        char[] chars = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        int symmetry = getSymmetry(chars);
        if (symmetry == 0) {
            symmetry = getSymmetryByEven(chars);
            for (int i = chars.length - 1; i > symmetry; i--) {
                sb.append(chars[i]);
            }
            sb.append(s);
        } else {
            for (int i = chars.length - 1; i > symmetry * 2; i--) {
                sb.append(chars[i]);
            }
            sb.append(s);
        }


        return sb.toString();
    }

    private static int getSymmetryByEven(char[] chars) {
        int result = 0;
        int floor = 0;
        while (floor < chars.length / 2) {
            int left = floor;
            int right = left + 1;
            boolean flag = true;
            if (left >= 0 && right < chars.length) {
                while (left >= 0 && right < chars.length) {
                    if (chars[left] != chars[right]) {
                        flag = false;
                        left = -1;
                    }
                    left --;
                    right ++;
                }
                if (flag) {
                    result = right - 1;
                }
            }
            floor ++;
        }
        return result;
    }

    private static int getSymmetry(char[] chars) {
        int result = 0;
        int floor = 1;
        while (floor < chars.length / 2 + 1) {
            int left = floor - 1;
            int right = floor + 1;
            boolean flag = true;
            if (left >= 0 && right < chars.length) {
                while (left >= 0 && right < chars.length) {
                    if (chars[left] != chars[right]) {
                        flag = false;
                        left = -1;
                    }
                    left --;
                    right ++;
                }
                if (flag) {
                    result = floor;
                }
            }
            floor ++;
        }
        return result;
    }*/


}
