package com.wz.september.time1.a22;

import java.nio.file.FileStore;
import java.util.ArrayList;
import java.util.List;

public class FirstUniqueCharacter {
    /**
     * 字符串中的第一个唯一字符
     *
     * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
     *
     *
     * 示例：
     *
     * s = "leetcode"
     * 返回 0
     *
     * s = "loveleetcode"
     * 返回 2
     */

    /**
     * 直接暴力求解，利用List
     */

    boolean[] visited = new boolean[26];

    /**
     * 时间复杂度为 O（n）
     * 空间复杂度为 O（n）
     */
    public int firstUniqChar(String s) {
        if (s == null || s == "") {
            return -1;
        }
        List<String> list = new ArrayList<>();
        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            String temp = String.valueOf(aChar);
            if (visited[aChar - 'a']) {
                list.remove(temp);
            } else {
                visited[aChar - 'a'] = true;
                list.add(temp);
            }
        }
        return list.size() == 0 ? -1 : s.indexOf(list.get(0));
    }

    public static void main(String[] args) {
        FirstUniqueCharacter firstUniqueCharacter = new FirstUniqueCharacter();
        System.out.println(firstUniqueCharacter.firstUniqChar("leetcode"));
        System.out.println(firstUniqueCharacter.firstUniqChar("loveleetcode"));
        System.out.println(firstUniqueCharacter.firstUniqChar("aadadaad"));
    }

}
