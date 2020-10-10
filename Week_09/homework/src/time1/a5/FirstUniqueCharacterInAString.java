package time1.a5;

import java.util.ArrayList;
import java.util.List;

public class FirstUniqueCharacterInAString {
    /**
     * 字符串中的第一个唯一字符
     *
     * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。

     *
     * 示例：
     *
     * s = "leetcode"
     * 返回 0
     *
     * s = "loveleetcode"
     * 返回 2
     *
     * 提示：你可以假定该字符串只包含小写字母。
     */

    /**
     * 借用了内置的indexOf的函数，做完之后忽然发现19天前做过，看了下，感觉思路差不多相同
     * 时间复杂度O(n)
     * 空间复杂度O(n)
     */
    public static int firstUniqChar(String s) {
        char[] chars = s.toCharArray();
        int result = -1;
        List<Character> list = new ArrayList<>();
        for (int i = 0; i < chars.length; i++) {
            char c = s.charAt(i);
            int i1 = s.indexOf(c, i + 1);
            if (i1 == -1 && !list.contains(c)) {
                return i;
            }
            list.add(c);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(firstUniqChar("leetcode"));
        System.out.println(firstUniqChar("loveleetcode"));
    }
}
