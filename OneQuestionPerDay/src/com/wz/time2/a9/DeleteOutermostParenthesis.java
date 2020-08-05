package com.wz.time2.a9;

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
     * 1. 依稀记得自己蠢蠢的方法，哎，忘记自己拿蠢蠢的写法吧
     * 2. 最简单的写法，计数器写法，遇到（加1，遇到）减1，止痒对称的时候计数器就是0，在计数器大于等于1的时候拼接字符串，就可以了。
     *
     */



    public static void main(String[] args) {
        System.out.println(removeOuterParentheses("(())"));
    }

    /**
     * 计数器解法
     */
    public static String removeOuterParentheses(String S) {
        StringBuilder sb = new StringBuilder("");
        int count = 0;
        for (char c : S.toCharArray()) {
            if (c == ')') {
                count --;
            }
            if (count >= 1) {
                sb.append(c);
            }
            if (c == '(') {
                count ++;
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
