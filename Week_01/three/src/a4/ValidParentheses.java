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
     * 1. 栈结构，FILO，遇到（入栈，遇到），出栈，不过遇到）的时候入栈），这个的话就可以直接对比, 时间复杂度为O(n)
     * 2. 笨一点的方法就是加一个map来存储括号的对应关系，遇到（入栈（，遇到）出栈，然后从map中得到对应关系，其余类似
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
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(')');
            } else if (c == '[') {
                stack.push(']');
            } else if (c == '{') {
                stack.push('}');
            } else {
                if (!stack.isEmpty() && stack.pop() != c) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
