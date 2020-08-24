package com.wz.time1.a29;

import java.util.*;

public class WordSolitaire {

    /**
     * 单词接龙
     *
     * 给定两个单词（beginWord和 endWord）和一个字典，找到从beginWord 到endWord 的最短转换序列的长度。转换需遵循如下规则：
     *
     * 每次转换只能改变一个字母。
     * 转换过程中的中间单词必须是字典中的单词。
     * 说明:
     *
     * 如果不存在这样的转换序列，返回 0。
     * 所有单词具有相同的长度。
     * 所有单词只由小写字母组成。
     * 字典中不存在重复的单词。
     * 你可以假设 beginWord 和 endWord 是非空的，且二者不相同。
     * 示例1:
     *
     * 输入:
     * beginWord = "hit",
     * endWord = "cog",
     * wordList = ["hot","dot","dog","lot","log","cog"]
     *
     * 输出: 5
     *
     * 解释: 一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog",
     *      返回它的长度 5。
     * 示例 2:
     *
     * 输入:
     * beginWord = "hit"
     * endWord = "cog"
     * wordList = ["hot","dot","dog","lot","log"]
     *
     * 输出:0
     *
     * 解释:endWord "cog" 不在字典中，所以无法进行转换。
     */

    /**
     * 思路：
     * 利用广度遍历，脑海中第一个是广度遍历，那就先用广度遍历尝试下吧
     * 做下来了，但是时间复杂度就不说了，尤其在判断的时候只有一个字符不同的时候，利用了循环来做。
     * 不过该考虑的点都考虑到了，还是比较顺的，时间长了点，看看题解吧
     */

    public static void main(String[] args) {
        System.out.println(ladderLength("hit", "cog", Arrays.asList("hot","dot","dog","lot","log","cog")));
        //System.out.println(ladderLength("hit", "cog", Arrays.asList("hot","dot","dog","lot","log")));
    }

    /**
     * 时间复杂度是O（MN）
     * 空间复杂度是O（M）
     */
    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int result = 1;
        List<String> visited = new ArrayList<>();
        Deque<String> deque = new LinkedList<>();
        deque.add(beginWord);
        while (!deque.isEmpty()) {
            result ++;
            int loop = deque.size();
            for (int i = 0; i < loop; i++) {
                String pop = deque.pop();
                char[] popChars = pop.toCharArray();
                for (String s : wordList) {
                    // 判断只有一个字符不同
                    int num = 0;
                    char[] chars = s.toCharArray();
                    for (int i1 = 0; i1 < chars.length; i1++) {
                        if (popChars[i1] != chars[i1]) {
                            num ++;
                        }
                    }
                    if (num == 1 && !visited.contains(s)) {
                        deque.add(s);
                        visited.add(s);
                    }
                }
            }
            if (deque.contains(endWord)) {
                return result;
            }
        }

        return 0;
    }
}
