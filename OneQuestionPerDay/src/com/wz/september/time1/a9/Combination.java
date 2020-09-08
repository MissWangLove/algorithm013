package com.wz.september.time1.a9;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Combination {
    /**
     * 组合
     * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
     *
     * 示例:
     *
     * 输入:n = 4, k = 2
     * 输出:
     * [
     *   [2,4],
     *   [3,4],
     *   [2,3],
     *   [1,2],
     *   [1,3],
     *   [1,4],
     * ]
     */
    private static List<List<Integer>> result = new ArrayList<>();

    public static void main(String[] args) {
//        List<List<Integer>> combine = combine(4, 2);
        List<List<Integer>> combine = combine(1, 1);
        for (List<Integer> list : combine) {
            for (int i = 0; i < list.size(); i++) {
                System.out.print(list.get(i) + ", ");
            }
            System.out.println();
        }
    }

    public static List<List<Integer>> combine(int n, int k) {
        getResult(1, n, k, new LinkedList<>());
        return result;
    }

    private static void getResult(int level, int n, int k, LinkedList<Integer> linkedList) {
        // 终止条件
        if (linkedList.size() == k) {
            result.add(new ArrayList<>(linkedList));
            return ;
        }
        for (int i = level; i <= n; i++) {
            linkedList.add(i);
            getResult(i + 1, n, k, linkedList);
            linkedList.pollLast();
        }
    }
}
