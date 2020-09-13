package com.wz.september.time1.a13;

import java.util.ArrayList;
import java.util.List;

public class BracketGeneration {

    /**
     * 括号生成
     *
     * 数字 n代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
     *
     * 示例：
     *
     * 输入：n = 3
     * 输出：[
     *        "((()))",
     *        "(()())",
     *        "(())()",
     *        "()(())",
     *        "()()()"
     *      ]
     */

    /**
     * 递归实现
     */

    private static List<String> result = new ArrayList<>();

    public static List<String> generateParenthesis(int n) {
        generateString(0, 0, n, "");
        return result;
    }

    private static void generateString(int left, int right, int n, String str) {
        // 终止条件
        if (left == right && left == n) {
            result.add(str);
            return;
        }
        if (left >= right && left < n) {
            generateString(left + 1, right, n, str + "(");
        }
        if (right < left && right < n) {
            generateString(left, right + 1, n, str + ")");
        }
    }

    public static void main(String[] args) {
        List<String> strings = generateParenthesis(3);
        strings.forEach(System.out::println);
    }
}
