package a1;

import java.util.ArrayList;
import java.util.List;

public class BracketGeneration {

    /**
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
     * 昨天晚上做的，现在才12点，头脑还算清晰，直接写了：
     * 思路就是递归的模板写法； 终止条件；本层业务逻辑；进入下一层；清理当前层状态
     */

    public static void main(String[] args) {
        List<String> strings = generateParenthesis(3);
        strings.forEach(System.out::println);
    }

    /**
     * 时间复杂度为 O(2^n)
     * 空间复杂度为 O(n), 对空间复杂度为分析有点懵皮，也不知道对不对
     */
    public static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        getBracket(0, 0, n, "", result);
        return result;
    }

    private static void getBracket(int left, int right, int n, String str, List<String> result) {
        // 递归终止条件
        if (left == n && right == n) {
            result.add(str);
            return;
        }
        // 本层的业务逻辑和进入下一层
        if (left < n) {
            getBracket(left + 1, right, n, str + "(", result);
        }
        if (right < left) {
            getBracket(left, right + 1, n, str + ")", result);
        }
    }
}
