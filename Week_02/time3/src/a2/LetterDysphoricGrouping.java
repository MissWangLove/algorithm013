package a2;

import java.util.*;

/**
 * @author 王智
 */
public class LetterDysphoricGrouping {

    /**
     * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
     *
     * 示例:
     *
     * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
     * 输出:
     * [
     *   ["ate","eat","tea"],
     *   ["nat","tan"],
     *   ["bat"]
     * ]
     * 说明：
     *
     * 所有输入均为小写字母。
     * 不考虑答案输出的顺序。
     */

    /**
     * 1. 利用Map，排序，利用map存放，map声明利用List
     * 2. 计数法怎么做？
     */




    public static void main(String[] args) {
        List<List<String>> lists = groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
        for (List<String> list : lists) {
            for (String s : list) {
                System.out.println(s);
            }
            System.out.println("----------");
        }
    }

    /**
     * 计数法
     * 利用数组来计数每个字母出现的次数，最后把所有字母出现的次数拼接组成map的key
     * 感觉这个方法更耗时
     * 时间复杂度为 O(n^2)
     * 空间复杂度为 O(n)
     */
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            int[] arr = new int[26];
            for (int i = 0; i < str.length(); i++) {
                // 这里晕了一下，在考虑索引怎么处理，其实没有必要，减去‘a’不就好了
                arr[str.charAt(i) - 'a'] ++;
            }
            StringBuilder sb = new StringBuilder("");
            for (int i : arr) {
                sb.append(i);
            }
            String s = sb.toString();
            if (!map.containsKey(s)) {
                map.put(s, new ArrayList<>());
            }
            map.get(s).add(str);
        }

        return new ArrayList<>(map.values());
    }

    /**
     * map解决，关键在于map的声明
     * 时间复杂度为 O(n ^ 2 * log n)
     * 空间复杂度为 O(n)  todo 这里是O(n)吗？ List不算在内吗？
     */
    /*public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String s = new String(chars);
            if (! map.containsKey(s)) {
                map.put(s, new ArrayList<>());
            }
            map.get(s).add(str);
        }
        return new ArrayList<>(map.values());
    }*/
}
