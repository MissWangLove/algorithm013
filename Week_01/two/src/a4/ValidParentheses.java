package a4;

import java.util.*;

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
     * 第三遍来做
     * 这个无非就是考虑栈结构，先进后出
     * 1. 自己的方法（使用map提前存好括号的对应关系，然后来判断）
     * 2. 外国友人的方法（逆向思维，这个思维算是取巧，不通用）
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
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(') {
                stack.push(')');
            } else if (s.charAt(i) == '[') {
                stack.push(']');
            } else if (s.charAt(i) == '{') {
                stack.push('}');
            } else {
                if (stack.isEmpty() || !stack.pop().equals(s.charAt(i))) {
                    return false;
                }
            }
        }
        if (!stack.isEmpty()) {
            return false;
        }
        return true;
    }
}
