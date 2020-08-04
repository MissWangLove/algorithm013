package a1;

import java.util.Arrays;

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
     * 1. 遍历一个，map存放次数，遍历另一个，map减去次数，次数为0，删除，最后判断map的size是否为0
     * 2. 排序，使用长度为26的数组解决，或者一次for循环解决
     */


    public static void main(String[] args) {
        System.out.println(isAnagram("anagram", "nagaram"));
        System.out.println(isAnagram("rat", "car"));
    }

    /**
     * 数组排序实现，时间复杂度是 O(nlogn)
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
     * 26长度数组实现
     * @param s
     * @param t
     * @return
     */
    public static boolean isAnagram(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) {
            return false;
        }
        int[] arr = new int[26];
        // 这种写法不好
        /*for (int i = 0; i < s.length(); i++) {
            arr[s.charAt(i) - 'a'] ++;
            arr[t.charAt(i) - 'a'] --;
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                return false;
            }
        }*/
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
     * 使用一个map来存储一个字符串中字母和字母出现的次数，然后遍历另一个字母串的时候先减少map的次数，
     * 当次数是0的时候移除，最后map为空说明是字母异位词
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
