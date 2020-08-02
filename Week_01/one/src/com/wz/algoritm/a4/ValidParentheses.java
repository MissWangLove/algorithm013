package com.wz.algoritm.a4;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * @author wangzhi
 */
public class ValidParentheses {

    /**
     * 给定一个只包括 '('，')'，'{'，'}'，'['，']'的字符串，判断字符串是否有效。
     *
     * 有效字符串需满足：
     *
     * 左括号必须用相同类型的右括号闭合。
     * 左括号必须以正确的顺序闭合。
     * 注意空字符串可被认为是有效字符串。
     *
     * 示例 1:
     *
     * 输入: "()"
     * 输出: true
     * 示例2:
     *
     * 输入: "()[]{}"
     * 输出: true
     * 示例3:
     *
     * 输入: "(]"
     * 输出: false
     * 示例4:
     *
     * 输入: "([)]"
     * 输出: false
     * 示例5:
     *
     * 输入: "{[]}"
     * 输出: true
     */

    /**
     * 最近线性相关使用栈结构
     * 思路：使用栈结构，先进后出的顺序，碰到左括号就入栈，碰到右括号就出栈进行对比
     *
     * 记住，如果中间要使用到查找，就想到哈希结构，查询的时间复杂度是O（1），绝对快。
     *
     */

    public static void main(String[] args) {
        System.out.println(isValid("()"));
        System.out.println(isValid("()[]{}"));
        System.out.println(isValid("(]"));
        System.out.println(isValid("([)]"));
    }





    public static boolean isValid(String s) {
        if (s == null || s.length() % 2 == 1) {
            return false;
        }
        Map<String, String> map = new HashMap<>(3);
        map.put("{", "}");
        map.put("(", ")");
        map.put("[", "]");
        // 使用栈结构
        Deque<String> deque = new ArrayDeque<>(s.length() / 2);
        for (int i = 0; i < s.length(); i++) {
            String str = String.valueOf(s.charAt(i));
            if (map.containsKey(str)) {
                deque.add(str);
            } else {
                if (!str.equals(map.get(deque.pollLast()))) {
                    return false;
                }
            }
        }
        return deque.size() == 0;
    }
}
