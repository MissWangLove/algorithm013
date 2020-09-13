package com.wz.september.time1.a11;


import java.util.*;

/**
 * @author 王智
 */
public class WordSolitaire {

    /**
     * 单词接龙
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

    public static void main(String[] args) {
        System.out.println(ladderLength("hit", "cog", Arrays.asList("hot","dot","dog","lot","log")));
    }

    // bfs的优化 看不懂，优化了下代码，结果超时了
    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int result = 1;
        LinkedList<String> queue = new LinkedList<>();
        LinkedList<String> visited = new LinkedList<>();
        queue.add(beginWord);
        while (!queue.isEmpty()) {
            int loop = queue.size();
            for (int i = 0; i < loop; i++) {
                String str = queue.pollFirst();
                for (int j = 0; j < wordList.size(); j++) {
                    String wordStr = wordList.get(j);
                    int num = getDifferent(str.toCharArray(), wordStr.toCharArray());
                    if (num == 1 && !visited.contains(wordStr)) {
                        queue.add(wordStr);
                        visited.add(wordStr);
                    }
                }
            }
            result ++;
            if (queue.contains(endWord)) {
                queue.clear();
                return result;
            }
        }
        return 0;
    }

    private static int getDifferent(char[] begin, char[] word) {
        int num = 0;
        for (int i = 0; i < begin.length; i++) {
            if (begin[i] != word[i]) {
                num ++;
            }
        }
        return num;
    }

    /**
     * 广度遍历
     */
    /*public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int result = 1;
        LinkedList<String> queue = new LinkedList<>();
        LinkedList<String> visited = new LinkedList<>();
        queue.add(beginWord);
        while (!queue.isEmpty()) {
            int loop = queue.size();
            for (int i = 0; i < loop; i++) {
                String str = queue.pollFirst();
                char[] strChars = str.toCharArray();
                for (int j = 0; j < wordList.size(); j++) {
                    String wordStr = wordList.get(j);
                    char[] chars = wordStr.toCharArray();
                    int num = 0;
                    for (int k = 0; k < chars.length; k++) {
                        if (strChars[k] != chars[k]) {
                            num ++;
                        }
                        if (num > 1) {
                            break;
                        }
                    }
                    if (num == 1 && !visited.contains(wordStr)) {
                        queue.add(wordStr);
                        visited.add(wordStr);
                    }
                }
            }
            result ++;
            if (queue.contains(endWord)) {
                queue.clear();
                return result;
            }
        }
        return 0;
    }*/

}
