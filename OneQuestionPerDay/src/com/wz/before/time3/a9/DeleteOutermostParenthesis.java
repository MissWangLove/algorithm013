package com.wz.before.time3.a9;

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
     * 第三遍
     * 1. 计数器解法，就是统计括号出现的次数，出现（加1，出现）的时候减1，计数器放在中间进行判断，否则永远也凑不成一对，因为减1之后就等于1，不满足条件
     * 2. 利用栈结构，但是效率差，不考虑，记住第一种方法就好。
     */



    public static void main(String[] args) {
        System.out.println(removeOuterParentheses("(())"));
        System.out.println(removeOuterParentheses("()()"));
        System.out.println(removeOuterParentheses("(()())(())"));
        System.out.println(removeOuterParentheses("(()())(())(()(()))"));
    }

    /**
     * 计数器解法
     * 时间复杂度 O(n)
     * 空间复杂度 O(1)
     */
    public static String removeOuterParentheses(String S) {
        StringBuilder sb = new StringBuilder("");
        int num = 0;
        for (char c : S.toCharArray()) {
            if (c == '(') {
                num ++;
            }
            if (num > 1) {
                sb.append(c);
            }
            if (c == ')') {
                num --;
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

    }*/
}
