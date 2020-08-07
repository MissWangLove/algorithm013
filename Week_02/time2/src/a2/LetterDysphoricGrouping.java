package a2;

import java.util.*;

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
     * 1. 利用哈希表结构，键是String，值是List来做
     * 2. 计数法的解法想不起来了，看下前天的笔记回忆下，现在看计数法其实觉得计数法不一定就比上个方法好
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
     * 时间复杂度为 O(n^2) 双层for循环， strs.length一次， 转换成数组一次
     * 空间复杂度为 O(n) map的声明，数组的声明时固定的长度O(1)
     */
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            int[] count = new int[26];
            for (char c : strs[i].toCharArray()) {
                count[c - 'a'] ++;
            }
            StringBuilder sb = new StringBuilder("");
            for (int i1 : count) {
                // todo 不知道官方题解为什么在这加了个'#'
                sb.append(i1);
            }
            String s = sb.toString();
            if (!map.containsKey(s)) {
                map.put(s, new ArrayList<>());
            }
            map.get(s).add(strs[i]);
        }
        return new ArrayList<>(map.values());
    }

    /**
     * map解决，关键在于map的声明
     * 时间复杂度： O(n^2 * log n)  排序是 n * log n, 加上外层的for循环 n
     * 空间复杂度： O(n)
     * @param strs
     * @return
     */
    /*public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String s = String.valueOf(chars);
            // 优化下
            *//*if (map.containsKey(s)) {
                map.get(s).add(str);
            } else {
                List<String> strings = new ArrayList<>();
                strings.add(str);
                map.put(s, strings);
            }*//*
            if (!map.containsKey(s)) {
                map.put(s, new ArrayList<>());
            }
            map.get(s).add(str);
        }
        return new ArrayList<>(map.values());
    }*/
}
