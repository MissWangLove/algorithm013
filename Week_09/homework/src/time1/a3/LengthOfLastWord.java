package time1.a3;

public class LengthOfLastWord {
    /**
     * 给定一个仅包含大小写字母和空格' '的字符串 s，返回其最后一个单词的长度。如果字符串从左向右滚动显示，那么最后一个单词就是最后出现的单词。
     *
     * 如果不存在最后一个单词，请返回 0。
     *
     * 说明：一个单词是指仅由字母组成、不包含任何空格字符的 最大子字符串。
     *
     *
     *
     * 示例:
     *
     * 输入: "Hello World"
     * 输出: 5
     */

    /**
     * 先去掉首尾空格，然后按照空格进行分割
     * 时间复杂度O(1)
     * 空间复杂度O(n)
     */
    public int lengthOfLastWord(String s) {
        String trim = s.trim();
        String[] s1 = trim.split(" ");
        if (s1.length == 0) {
            return 0;
        }
        String result = s1[s1.length - 1];
        return result.length();
    }
}
