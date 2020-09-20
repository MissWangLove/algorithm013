package com.wz.september.time1.a21;

import java.util.ArrayList;
import java.util.LinkedList;
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

    /**
     * 这道题如何思考呢？暂时没有思路，但是递归是肯定需要的，那就先递归。
     */

    List<List<Integer>> result = new ArrayList<>();

    /**
     * 时间复杂度为 O（n * 2 ^ n）
     * 空间复杂度为 O（n）
     */
    public List<List<Integer>> subsets(int[] nums) {
        getResult(0, nums, new LinkedList<Integer>());
        return result;
    }

    private void getResult(int index, int[] nums, LinkedList<Integer> linkedList) {
        if (linkedList.size() > nums.length) {
            return ;
        }
        result.add(new ArrayList<>(linkedList));
        for (int i = index; i < nums.length; i++) {
            if (linkedList.contains(nums[i])) {
                continue;
            }
            linkedList.add(nums[i]);
            getResult(i + 1, nums, linkedList);
            linkedList.pollLast();
        }
    }

    public static void main(String[] args) {
        Subset subset = new Subset();
        List<List<Integer>> subsets = subset.subsets(new int[]{1, 2, 3});
        for (List<Integer> list : subsets) {
            for (Integer integer : list) {
                System.out.print(integer + ",");
            }
            System.out.println();
        }
    }
}
