package com.wz.time1.a9;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class DeleteOutermostParenthesis {

    /**
     * 有效括号字符串为空("")、"(" + A + ")"或A + B，其中A 和B都是有效的括号字符串，+代表字符串的连接。例如，""，"()"，"(())()"和"(()(()))"都是有效的括号字符串。
     *
     * 如果有效字符串S非空，且不存在将其拆分为S = A+B的方法，我们称其为原语（primitive），其中A 和B都是非空有效括号字符串。
     *
     * 给出一个非空有效字符串S，考虑将其进行原语化分解，使得：S = P_1 + P_2 + ... + P_k，其中P_i是有效括号字符串原语。
     *
     * 对S进行原语化分解，删除分解中每个原语字符串的最外层括号，返回 S。

     * 示例 1：
     *
     * 输入："(()())(())"
     * 输出："()()()"
     * 解释：
     * 输入字符串为 "(()())(())"，原语化分解得到 "(()())" + "(())"，
     * 删除每个部分中的最外层括号后得到 "()()" + "()" = "()()()"。
     * 示例 2：
     *
     * 输入："(()())(())(()(()))"
     * 输出："()()()()(())"
     * 解释：
     * 输入字符串为 "(()())(())(()(()))"，原语化分解得到 "(()())" + "(())" + "(()(()))"，
     * 删除每个部分中的最外层括号后得到 "()()" + "()" + "()(())" = "()()()()(())"。
     * 示例 3：
     *
     * 输入："()()"
     * 输出：""
     * 解释：
     * 输入字符串为 "()()"，原语化分解得到 "()" + "()"，
     * 删除每个部分中的最外层括号后得到 "" + "" = ""。
     *
     * 提示：
     *
     * S.length <= 10000
     * S[i] 为"(" 或")"
     * S 是一个有效括号字符串
     */

    /**
     * 感觉不简单，一步一步来实现：
     * 1. 先分解成A+B的形式，然后在考虑去除最外层的括号，这里不能用栈结构，需要使用队列结构，双端队列，当出现）的时候，入队，判断队列长度是否为偶数，是的话就是A+B的形式
     * 栈结构判断对称，双端队列用来拼接结果
     * 2. 如何优化呢？ 看下题解吧：
     * 题解太简单了，感觉自己弱爆了，思路，遍历整个字符串，遇到第一个（不追加，遇到对称的）不追加，这个是由level>1来判断的，简直了，这个思路我服了，
     * 再看看自己的代码，感觉一坨。这个思路中的关键就在于计数器的计数和三个if的顺序，精髓了，遇到（加一，遇到）减一，计数器与1判断就可以去掉第一个（和与之对应的）。
     */

    public static void main(String[] args) {
        System.out.println(removeOuterParentheses("(())"));
    }

    /**
     * 计数器解法
     */
    public static String removeOuterParentheses(String S) {
        StringBuilder sb = new StringBuilder();
        int level = 0;
        for (char c : S.toCharArray()) {
            if (c == ')') {
                level --;
            }
            if (level >= 1) {
                sb.append(c);
            }
            if (c == '(') {
                level ++;
            }
        }

        return sb.toString();
    }

    /**
     * 栈结构判断对称，双端队列用来拼接结果
     * @param S
     * @return
     */
   /* public static String removeOuterParentheses(String S) {
        StringBuilder result = new StringBuilder();
        LinkedList<Character> list = new LinkedList<>();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            list.add(c);
            if (c == ')') {
                stack.pop();
                if (stack.isEmpty()) {
                    list.pollFirst();
                    list.pollLast();
                    for (Character character : list) {
                        result.append(character);
                    }
                    list.clear();
                }
            } else {
                stack.push(c);
            }
        }
        return result.toString();
    }*/
}
