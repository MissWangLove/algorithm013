package com.wz.time3.a23;

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
     *
     */
    public List<List<Integer>> permute(int[] nums) {

        return result;
    }

    private void getResult(int length, LinkedList<Integer> nums, LinkedList<Integer> curr) {

    }


}
