package com.wz.september.time3.a9;

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
        return null;
    }


}
