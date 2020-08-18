package com.wz.time2.a23;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class FullArray {

    /**
     * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
     *
     * 示例:
     *
     * 输入: [1,2,3]
     * 输出:
     * [
     *   [1,2,3],
     *   [1,3,2],
     *   [2,1,3],
     *   [2,3,1],
     *   [3,1,2],
     *   [3,2,1]
     * ]
     */

    /**
     * 这个题和组合非常类似，也是利用回溯的方法，那就是列举所有可能的结果，排除不符合结果的可能就好
     * 我擦，我竟然独立做出来，但是我写的还是有点迷，哎，不过是我自己做出来，题解我没看懂。。。。。。
     */

    private List<List<Integer>> result = new LinkedList<>();

    public static void main(String[] args) {
        FullArray fullArray = new FullArray();
        List<List<Integer>> permute = fullArray.permute(new int[]{1, 2, 3});
        for (List<Integer> list : permute) {
            for (Integer integer : list) {
                System.out.print(integer + ", ");
            }
            System.out.println();
        }
    }

    /**
     * 我的想法其实就是集合的拷贝，在添加一个的时候，改变传入的集合，但是前提是得知道最开始的时候的长度，要作为终止条件
     * 这个就是有点耗空间，每次都得拷贝数组。
     * 时间复杂度其实就是 O(n ^ n)，至少我是这么觉得。
     */
    public List<List<Integer>> permute(int[] nums) {
        LinkedList<Integer> curr = new LinkedList<>();
        LinkedList<Integer> list = new LinkedList<>();
        for (int num : nums) {
            list.add(num);
        }
        getResult(nums.length, list, curr);
        return result;
    }

    private void getResult(int length, LinkedList<Integer> nums, LinkedList<Integer> curr) {
        // 终止条件
        if (curr.size() == length) {
            result.add(new LinkedList<>(curr));
            return ;
        }
        // 当前层
        for (int i = 0; i < nums.size(); i++) {
            curr.add(nums.get(i));
            LinkedList<Integer> list = new LinkedList<>(nums);
            list.remove(nums.get(i));
            // 进入下一层
            getResult(length, list, curr);
            curr.removeLast();
        }
    }


}
