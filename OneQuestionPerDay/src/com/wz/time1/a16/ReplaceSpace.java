package com.wz.time1.a16;

public class ReplaceSpace {

    /**
     * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
     *
     * 示例 1：
     *
     * 输入：s = "We are happy."
     * 输出："We%20are%20happy."
     */

    /**
     * 1. 可以利用Java String的内置函数
     * 2. 遍历，遇到空格替换
     */

    public static void main(String[] args) {
        System.out.println(replaceSpace("We are happy."));
    }

    /**
     * 时间复杂度O(n)
     * 空间复杂度O(n)
     */
    public static String replaceSpace(String s) {
        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                sb.append("%20");
            } else {
                sb.append(s.charAt(i));
            }

        }
        return sb.toString();
    }

    /**
     * String的内置函数
     * 时间复杂度为O(1),内部是正则替换
     * 空间复杂度为O(1)
     */
    /*public static String replaceSpace(String s) {
        if (s == null) {
            return s;
        }
        return s.replace(" ", "%20");
    }*/
}
