package com.wz.time2.a24;

import java.util.*;

public class MinimalGeneticChange {

    /**
     * 一条基因序列由一个带有8个字符的字符串表示，其中每个字符都属于 "A", "C", "G", "T"中的任意一个。
     *
     * 假设我们要调查一个基因序列的变化。一次基因变化意味着这个基因序列中的一个字符发生了变化。
     *
     * 例如，基因序列由"AACCGGTT"变化至"AACCGGTA"即发生了一次基因变化。
     *
     * 与此同时，每一次基因变化的结果，都需要是一个合法的基因串，即该结果属于一个基因库。
     *
     * 现在给定3个参数 — start, end, bank，分别代表起始基因序列，目标基因序列及基因库，请找出能够使起始基因序列变化为目标基因序列所需的最少变化次数。如果无法实现目标变化，请返回 -1。
     *
     * 注意:
     *
     * 起始基因序列默认是合法的，但是它并不一定会出现在基因库中。
     * 所有的目标基因序列必须是合法的。
     * 假定起始基因序列与目标基因序列是不一样的。
     * 示例 1:
     *
     * start: "AACCGGTT"
     * end:   "AACCGGTA"
     * bank: ["AACCGGTA"]
     *
     * 返回值: 1
     * 示例 2:
     *
     * start: "AACCGGTT"
     * end:   "AAACGGTA"
     * bank: ["AACCGGTA", "AACCGCTA", "AAACGGTA"]
     *
     * 返回值: 2
     * 示例 3:
     *
     * start: "AAAAACCC"
     * end:   "AACCCCCC"
     * bank: ["AAAACCCC", "AAACCCCC", "AACCCCCC"]
     *
     * 返回值: 3
     */

    /**
     * 1. 第二遍做，使用bfs实现
     * 2. 可以采用dfs实现
     */

    public static void main(String[] args) {
        System.out.println(minMutation("AACCGGTT", "AACCGGTA" , new String[]{"AACCGGTA"}));
    }

    /**
     * bfs 双端队列
     * 时间复杂度和空间复杂度都是O(n)  只要和树相关的，保证每个节点访问且仅访问依次，时间复杂度都是O(n)
     */
    public static int minMutation(String start, String end, String[] bank) {
        int result = 0;
        // 双端队列，保存访问的元素
        Deque<String> deque = new LinkedList<>();
        deque.add(start);
        // 用来替换，枚举每一种结果
        char[] c = new char[]{'A', 'C', 'G', 'T'};
        // 访问过的链表
        LinkedList<String> visited = new LinkedList<>();
        // 基因库中存在的基因
        List<String> bankList = Arrays.asList(bank);
        while (!deque.isEmpty()) {
            int length = deque.size();
            for (int i = 0; i < length; i++) {
                String poll = deque.poll();
                if (poll.equals(end)) {
                    return result;
                }
                char[] chars = poll.toCharArray();
                // 每一种可能的结果
                for (int i1 = 0; i1 < chars.length; i1++) {
                    char old = chars[i1];
                    for (char c1 : c) {
                        chars[i1] = c1;
                        String temp = new String(chars);
                        if ((!visited.contains(temp)) && bankList.contains(temp)) {
                            visited.add(temp);
                            deque.add(temp);
                        }
                    }
                    chars[i1] = old;
                }
            }
            result ++;
        }
        return -1;
    }
}
