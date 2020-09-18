package com.wz.september.time1.a19;

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



    /*public List<List<Integer>> permuteUnique(int[] nums) {

        return result;
    }*/
    /**
     * 这道题拿上之后有点懵，说实话，我想利用生成括号的写法来做这道题，试试，这道题我觉得就是递归的思路,没做出来，看题解
     * 看了题解感觉我的思路还是有可取之处的，就是在记录哪个访问过 哪个没访问过的时候有点问题，利用boolean数组不好吗？
     * 看了题解，修改自己的代码，修改完成，测试通过
     */
    boolean[] visited;
    List<List<Integer>> result = new ArrayList<>();

    public static void main(String[] args) {
        FullArrangementII fullArrangementII = new FullArrangementII();
//        List<List<Integer>> lists = fullArrangementII.permuteUnique(new int[]{1, 1, 2});
        List<List<Integer>> lists = fullArrangementII.permuteUnique(new int[]{3,3,0,3});
        for (List<Integer> list : lists) {
            for (Integer integer : list) {
                System.out.print(integer + ", ");
            }
            System.out.println();
        }

    }

    /**
     * 时间复杂度 O(n * n!)
     * 空间复杂度 O(n)
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
        visited = new boolean[nums.length];
        // 先排序，排序之后再全排列，否则会出现重复问题
        Arrays.sort(nums);
        getResult(nums, new LinkedList<Integer>());
        return result;
    }

    /**
     * index的作用是限制循环次数，否则可能会出现循环多次的可能
     */
    private void getResult(int[] nums, LinkedList<Integer> list) {
        if (list.size() == nums.length) {
            result.add(new ArrayList<>(list));
            return;
        }
        for (int j = 0; j < nums.length; j++) {
            // 判断当前索引是否访问或者当前和前一个相同，并且前一个没访问过
            if (visited[j] || (j > 0 && nums[j] == nums[j - 1] && !visited[j - 1])) {
                continue;
            }
            list.add(nums[j]);
            visited[j] = true;
            getResult( nums, list);
            visited[j] = false;
            list.pollLast();


        }
    }
}
