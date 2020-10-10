package time1.a2;

public class ToLowerCase {
    /**
     * 转换成小写字母
     *
     * 实现函数 ToLowerCase()，该函数接收一个字符串参数 str，并将该字符串中的大写字母转换成小写字母，之后返回新的字符串。
     *
     * 示例 1：
     *
     * 输入: "Hello"
     * 输出: "hello"
     * 示例 2：
     *
     * 输入: "here"
     * 输出: "here"
     * 示例 3：
     *
     * 输入: "LOVELY"
     * 输出: "lovely"
     */

    /**
     * 1. 最简单的，直接使用内置函数
     * 2. 维护一个Map，然后来判断，时间复杂度是O(n)
     * 3. 遍历一遍，利用大写字母和小写字母之间大字符差来计算
     */

    public String toLowerCase(String str) {
        return str.toLowerCase();
    }

    public static void main(String[] args) {
        System.out.println();
        System.out.println();
    }
}
