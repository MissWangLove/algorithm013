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
     * 思路：
     * 1. 参考字母异位词的判断，将所有的字符串变为数组进行排序, 然后放入map，key相同的追加内容，最后以空格分割(失败了，继续把，看题解)，遇到的
     * 问题是哈希表的key如何判断是否相同，重写数组equals方法？
     * =========笨死我了
     * 1. 思路没有问题，map的声明可以用String和List来做，我做的时候遇到的问题是数组转String不会，还有就是遇到""的时候出现了问题
     * 2. 计数器，其实计数器我想到了，但是我难在了如何判断计数器的数组上面，尴尬的一批，结果看题解是用map解决的，想不到想不到。
     * 那关键就在于map的声明和key的转换这了。
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
     * @param strs
     * @return
     */
    /*public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            String s = String.valueOf(chars);
            // 继续优化
            *//*if (map.containsKey(s)) {
                map.get(s).add(strs[i]);
            } else {
                List<String> temp = new ArrayList<>();
                temp.add(strs[i]);
                map.put(s, temp);
            }*//*
            if (!map.containsKey(s)) {
                map.put(s, new ArrayList<>());
            }
            map.get(s).add(strs[i]);
        }
        return new ArrayList<>(map.values());
    }*/
}
