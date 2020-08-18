package com.wz.time2.a22;

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
     * 第二遍做
     * 开始有点思路了，也可能是背的 代码吧
     */

    private List<List<Integer>> result = new LinkedList<>();

    public static void main(String[] args) {
        Combination combination = new Combination();
        List<List<Integer>> combine = combination.combine(4, 2);
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
        LinkedList<Integer> curr = new LinkedList<>();
        getResult(1, n, k, curr);
        return result;
    }

    private void getResult(int first, int n, int k, LinkedList<Integer> curr) {
        // 终止条件
        if (curr.size() == k) {
            result.add(new LinkedList<>(curr));
        }
        // 当前层逻辑
        for (int i = first; i <= n; i++) {
            curr.add(i);
            // 进入下一层，i + 1很重要
            getResult(i + 1, n, k, curr);
            curr.removeLast();
        }

    }


}
