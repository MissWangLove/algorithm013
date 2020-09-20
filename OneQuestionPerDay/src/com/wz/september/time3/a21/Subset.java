package com.wz.september.time3.a21;

import java.util.ArrayList;
import java.util.List;

public class Subset {
    /**
     *  子集
     *
     *  给定一组不含重复元素的整数数组nums，返回该数组所有可能的子集（幂集）。
     *
     * 说明：解集不能包含重复的子集。
     *
     * 示例:
     *
     * 输入: nums = [1,2,3]
     * 输出:
     * [
     *   [3],
     *  [1],
     *  [2],
     *  [1,2,3],
     *  [1,3],
     *  [2,3],
     *  [1,2],
     *  []
     * ]
     *
     */

    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {

        return result;
    }

    public static void main(String[] args) {
        Subset subset = new Subset();
        subset.subsets(new int[]{1, 2, 3 });
    }
}
