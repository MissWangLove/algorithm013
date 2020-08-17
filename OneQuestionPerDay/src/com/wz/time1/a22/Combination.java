package com.wz.time1.a22;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Combination {
    /**
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

    /**
     * 思路：
     * 没有思路，看题解
     * 1. 看了官方的题解，更懵逼了，认真思考，发现题解有个地方写的不明显，看了半天也不理解，要吐了
     */

    private List<List<Integer>> result = new LinkedList<>();

    public static void main(String[] args) {
        Combination combination = new Combination();
        List<List<Integer>> combine = combination.combine(1, 1);
        for (List<Integer> list : combine) {
            for (Integer integer : list) {
                System.out.print(integer + ", ");
            }
            System.out.println();
        }
    }

    /**
     * 时间复杂度就是 k * 全部的组合数
     * 空间复杂度是全部的组合数
     */
    public List<List<Integer>> combine(int n, int k) {
        getResult(1, n, k, new LinkedList<>());
        return result;
    }

    private void getResult(int first, int n, int k, LinkedList<Integer> curr) {
        if (curr.size() == k) {
            // 官方题解这没有返回，我看了半天，觉得加上return更容易理解
            result.add(new LinkedList<>(curr));
            return ;
        }
        for (int i = first; i <= n; i++) {
            curr.add(i);
            getResult(i + 1, n, k, curr);
            curr.removeLast();
        }
    }
}
