package a1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LetterVariants {

    /**
     * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
     *
     * 示例1:
     *
     * 输入: s = "anagram", t = "nagaram"
     * 输出: true
     * 示例 2:
     *
     * 输入: s = "rat", t = "car"
     * 输出: false
     * 说明:
     * 你可以假设字符串只包含小写字母。
     *
     */

    /**
     * 思路：
     * 1. 使用一个map来存储一个字符串中字母和字母出现的次数，然后遍历另一个字母串的时候先减少map的次数，当次数是0的时候移除，最后map为空说明
     * 是字母异位词
     * 暂时想不到其他思路，看题解：
     * 2. 排序，对比数组，其实我也想到排序，但是我想是排序之后不是对比数组，而是双层for循环对比，这个也是O(n)的时间复杂度
     * 3. 第一个思路中可以考虑使用数组，因为只包含小写字母，所以长度为26，利用char - a就可以表示每次一个索引
     */

    public static void main(String[] args) {
        // System.out.println(isAnagram("anagram", "nagaram"));
        System.out.println(isAnagram("rat", "car"));
    }

    /**
     * 数组实现
     * 时间复杂度为 O(n)
     * 空间复杂度为 O(1), 因为是固定的26
     * @param s
     * @param t
     * @return
     */
    public static boolean isAnagram(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) {
            return false;
        }
        int[] arr = new int[26];
        for (int i = 0; i < s.length(); i++) {
             arr[s.charAt(i) - 'a'] ++;

        }
        for (int i = 0; i < t.length(); i++) {
            arr[t.charAt(i) - 'a'] --;
            if (arr[t.charAt(i) - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * 排序,对比数组，这里的时间复杂度就是排序的时间复杂度 + 比较的时间复杂度
     * 时间复杂度是：O(n * log n)
     * 空间复杂度是： O(n),因为利用了额外的数组
     * @param s
     * @param t
     * @return
     */
    /*public static boolean isAnagram(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) {
            return false;
        }
        char[] chars = s.toCharArray();
        char[] chars1 = t.toCharArray();
        Arrays.sort(chars);
        Arrays.sort(chars1);
        return Arrays.equals(chars, chars1);
    }*/


    /**
     * 使用一个map来存储一个字符串中字母和字母出现的次数，然后遍历另一个字母串的时候先减少map的次数，
     * 当次数是0的时候移除，最后map为空说明是字母异位词
     * 时间复杂度为： O(n)
     * 空间复杂度为： O(n)
     * @param s
     * @param t
     * @return
     */
    /*public static boolean isAnagram(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) {
            return false;
        }
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                Integer integer = map.get(c);
                integer ++;
                map.put(c, integer);
            } else {
                map.put(c, 1);
            }
        }
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            if (map.containsKey(c)) {
                Integer integer = map.get(c);
                integer --;
                if (integer == 0) {
                    map.remove(c);
                } else {
                    map.put(c, integer);
                }
            } else {
                break;
            }
        }

        return map.size() == 0;
    }*/
}
