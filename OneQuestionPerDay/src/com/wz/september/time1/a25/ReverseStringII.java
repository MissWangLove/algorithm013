package com.wz.september.time1.a25;

public class ReverseStringII {
    /**
     * 反转字符串 II
     *
     * 给定一个字符串 s 和一个整数 k，你需要对从字符串开头算起的每隔2k 个字符的前 k 个字符进行反转。
     *
     * 如果剩余字符少于 k 个，则将剩余字符全部反转。
     * 如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。
     *
     *
     * 示例:
     *
     * 输入: s = "abcdefg", k = 2
     * 输出: "bacdfeg"
     *
     *
     * 提示：
     *
     * 该字符串只包含小写英文字母。
     * 给定字符串的长度和 k 在 [1, 10000] 范围内。
     */

    /**
     * 使用StringBuilder拼接一下试试
     */

    public static void main(String[] args) {
        String abcdefg = reverseStr("abcdefg", 2);
        System.out.println(abcdefg);
    }


    /**
     * 时间复杂度和空间福都是O（n）
     */
    public static String reverseStr(String s, int k) {
        StringBuilder sb = new StringBuilder();
        int num = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (i == num * k) {
                num ++;
                int loop = Math.min(k * num, chars.length);
                for (int j = loop - 1; j >= i; j--) {
                    sb.append(chars[j]);
                }
                i += k - 1;
                num ++;
            } else {
                sb.append(chars[i]);
            }

        }
        return sb.toString();
    }
}
