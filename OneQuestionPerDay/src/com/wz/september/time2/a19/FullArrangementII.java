package com.wz.september.time2.a19;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class FullArrangementII {
    /**
     * 全排列 II
     * 给定一个可包含重复数字的序列，返回所有不重复的全排列。
     *
     * 示例:
     *
     * 输入: [1,1,2]
     * 输出:
     * [
     *   [1,1,2],
     *   [1,2,1],
     *   [2,1,1]
     * ]
     */

    /**
     * 递归，关键点在于先排序，这点很关键。
     */
    List<List<Integer>> result = new ArrayList<>();

    boolean[] visited;

    /**
     * 时间复杂度为 O（n * n ！）
     * 空间复杂度为 O（n）
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
        if (nums.length == 0 ) {
            return result;
        }
        Arrays.sort(nums);
        visited = new boolean[nums.length];
        getResult(nums, new LinkedList<>());
        return result;
    }

    private void getResult(int[] nums, LinkedList<Integer> list) {
        if (list.size() == nums.length) {
            result.add(new ArrayList<>(list));
            return ;
        }
        for (int i = 0; i < nums.length; i++) {
            // 这里要判断两个数相同的情况，这也是为什么要先把数组排序的原因。
            if (visited[i] || ( i > 0 && nums[i] == nums[i - 1] && visited[i - 1])) {
                continue;
            }
            list.add(nums[i]);
            visited[i] = true;
            getResult(nums, list);
            visited[i] = false;
            list.pollLast();
        }
    }

    public static void main(String[] args) {
        FullArrangementII fullArrangementII = new FullArrangementII();
        List<List<Integer>> lists = fullArrangementII.permuteUnique(new int[]{1, 1, 2});
       //  List<List<Integer>> lists = fullArrangementII.permuteUnique(new int[]{3,3,0,3});
        for (List<Integer> list : lists) {
            for (Integer integer : list) {
                System.out.print(integer + ", ");
            }
            System.out.println();
        }

    }
}
