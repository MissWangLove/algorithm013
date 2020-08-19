package com.wz.time1.a24;

import com.sun.jmx.remote.internal.ClientCommunicatorAdmin;

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
     * 最小基因变化
     * 这道题的题意我看了半天才看懂，看懂了也没有思路，使用dfs和bfs如何做这类题，完全没有思路，更别说回溯的思想
     * 深入理解下回溯，回溯其实就是将所有的可能结果找出来，然后在其中寻找符合，以后遇到这种完全没有思路的，需要用到
     * 所有情况的题，就考虑dfs和bfs
     *
     * bfs如何实现，其实就是在每一层枚举变化一次可能的全部结果，然后看是否和结果相等，是否在给定的基因库中
     */

    public static void main(String[] args) {
        System.out.println(minMutation("AACCGGTT", "AACCGGTA" , new String[]{"AACCGGTA"}));
    }

    /**
     * bfs 双端队列
     * 边写边抄了一遍，大概理解了思路，就是从start开始，把start的每一位变化都算出来，然后看是否在基因库中，如果在加入到队列
     * 和已被访问的列表中，然后进入下一层再次列举出上一次每个变化的所有情况，依次。
     * 直到找到与end相同的就可以了
     * 时间复杂度和空间复杂度都是O(n)  只要和树相关的，保证每个节点访问且仅访问依次，时间复杂度都是O(n)
     */
    public static int minMutation(String start, String end, String[] bank) {
        int result = 0;
        List<String> strings = Arrays.asList(bank);
        Deque<String> depue = new LinkedList<>();
        char[] c = new char[]{'A', 'C', 'G', 'T'};
        Set<String> visited = new HashSet<>();
        depue.offer(start);
        while (!depue.isEmpty()) {
            int length = depue.size();
            while ((length --) > 0) {
                String poll = depue.poll();
                if (poll.equals(end)) {
                    return result;
                }
                char[] chars = poll.toCharArray();
                for (int i = 0; i < chars.length; i++) {
                    char old = chars[i];
                    for (char c1 : c) {
                        chars[i] = c1;
                        String str = new String(chars);
                        if (!visited.contains(str) && strings.contains(str)) {
                            visited.add(str);
                            depue.offer(str);
                        }
                    }
                    // 恢复操作
                    chars[i] = old;
                }
            }
            result ++;
        }
        return -1;
    }
}
