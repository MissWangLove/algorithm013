package a1;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 王智
 */
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
     * 没有丝毫的思路，完全看不到递归的念头，蒙圈中。
     */


    public static void main(String[] args) {
        List<String> list = generateParenthesis(3);
        list.forEach(System.out::println);
    }


    /**
     * 想了一下没想出来，之间看的来时的讲解，老师的思路就是这个组成就是由n个（和n个）组成的，先考虑终止条件
     * 终止条件： 左括号等于有括号并且等于n，结束拼接
     * 当前层的业务逻辑： 左括号小于n拼接左括号，右括号的数量小于左括号的数量，拼接右括号
     * 进入下一层：根据业务逻辑进入不同层，分别是左括号数量加一和右括号数量加一
     * 清除当前层的状态：全都是局部变量，所以不需要清楚当前层状态
     * 时间复杂度为 O(2^n)
     * 空间复杂度为 O(n)
     */
    public static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        getBracket(0, 0, n, "", result);
        return result;
    }

    /**
     * 递归拼接字符串
     * 本来想用StringBuilder的append方法来替代String的+拼接，结果我错了，大错特错，这是因为append方法地址是不会变的，
     * 变的永远是值，所以不能使用StringBuilder，这个就是**值传递与引用传递吧**，其实严格来说Java是没有值传递的，是共享传递，
     * 共享传递是引用传递的一种
     * @param left   左括号数目
     * @param right  右括号数目
     * @param n      多少对括号
     * @param str
     * @param result 存放拼接结果合集
     */
    private static void getBracket(int left, int right, int n, String str, List<String> result) {
        // 终止条件
        if (left == n && right == n) {
            result.add(str);
            return ;
        }
        // 当前层业务逻辑 + 进入下一层
        if (left < n) {
            getBracket(left + 1, right, n, str + "(", result);
        }
        if (right < left) {
            getBracket(left, right + 1, n,  str + ")", result);
        }

    }
}
