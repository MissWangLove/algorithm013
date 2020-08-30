package com.wz.august.time1.a30;

import java.util.LinkedList;

public class ReverseWordsInString {
    /**
     * 反转字符串中的单词 III
     * 给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
     *
     *
     * 示例：
     *
     * 输入："Let's take LeetCode contest"
     * 输出："s'teL ekat edoCteeL tsetnoc"
     *
     * 提示：
     *
     * 在字符串中，每个单词由单个空格分隔，并且字符串中不会有任何额外的空格。
     */

    /**
     * 这个题怎么说，看着挺简单，先使用字符串拼接的方式和双端队列分别实现，看看哪种更优
     */

    public static void main(String[] args) {
        System.out.println(reverseWords("Let's take LeetCode contest"));
    }

    // 时间复杂度为O（n）， 空间复杂度为O（n）
    public static String reverseWords(String s) {
        StringBuilder result = new StringBuilder();
        LinkedList<Character> linkedList = new LinkedList<>();
        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            if (aChar != ' ') {
                linkedList.add(aChar);
            } else {
                while (!linkedList.isEmpty()) {
                    result.append(linkedList.pollLast());
                }
                result.append(" ");
            }
        }
        while (!linkedList.isEmpty()) {
            result.append(linkedList.pollLast());
        }
        return result.toString();
    }

    // 时间复杂度为O（n）， 空间复杂度为O（n）
    /*public static String reverseWords(String s) {
        StringBuilder result = new StringBuilder();
        char[] chars = s.toCharArray();
        String temp = "";
        for (char aChar : chars) {
            if (aChar != ' ') {
                temp = aChar + temp;
            } else {
                result.append(temp).append(" ");
                temp = "";
            }
        }
        result.append(temp);
        return result.toString();
    }*/
}
