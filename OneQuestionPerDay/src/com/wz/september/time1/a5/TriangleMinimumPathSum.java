package com.wz.september.time1.a5;

import com.wz.before.time1.a1.ClimbStairs;

import java.util.List;

public class TriangleMinimumPathSum {
    /**
     * 三角形最小路径和
     * 给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
     *
     * 相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。
     *
     * 例如，给定三角形：
     *
     * [
     *      [2],
     *     [3,4],
     *    [6,5,7],
     *   [4,1,8,3]
     * ]
     * 自顶向下的最小路径和为11（即，2+3+5+1= 11）。
     *
     *
     *
     * 说明：
     *
     * 如果你可以只使用 O(n)的额外空间（n 为三角形的总行数）来解决这个问题，那么你的算法会很加分。
     */

    /**
     * 思路：
     * 我的思路就是比较相邻的数字大小就可以
     * result = max + Math.min（list.get(i), list.get(i - 1)）； 错误思路
     * 暴力求解？枚举所有可能的情况？这个倒是可以，想想dp，想想二维数组，看看如何解决？
     *
     * DP解决：
     *  1. 重复性问题（分治） ： problem（i, j） = min(subProblem(i + 1, j), subProblem(i + 1, j + 1)) + 自己本身
     *  2. 定义状态数组 ： f[i][j]
     *  3. dp方程: f[i][j] = Math.min(f[i + 1][j], f[i + 1][j + 1]) + f[i][j]
     *
     *  i 表示行数
     *  j 表示列数
     *  开始写代码
     */

    /**
     * 继续优化空间，原因是每次的话都是固定的行数
     * 时间复杂度为 O（n*n）
     * 这样话的 空间复杂度就是O（n）
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        int length = triangle.size();
        int[] dp = new int[length + 1];
        for (int i = length - 1; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                dp[j] = Math.min(dp[j], dp[j + 1]) + triangle.get(i).get(j);
            }
        }
        return dp[0];
    }

    /**
     * 使用二维数组来表示
     * 时间复杂度是 n * n
     * 空间复杂度就是 n * n
     */
    /*public int minimumTotal(List<List<Integer>> triangle) {
        int length = triangle.size();
        int[][] dp = new int[length + 1][length + 1];
        for (int i = length - 1; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                dp[i][j] = Math.min(dp[i + 1][j], dp[i + 1][j + 1]) + triangle.get(i).get(j);
            }
        }
        return dp[0][0];
    }*/

    ///  错误思路，以示警戒。
    /*public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) {
            return 0;
        }
        int result = 0;
        int index = 0;
        for (List<Integer> list : triangle) {
            if (list.size() == 1) {
                result += list.get(0);
            } else {
                if (list.get(index) > list.get(index + 1)) {
                    index = index + 1;
                }
                result += list.get(index);
            }

        }

        return result;
    }*/
}
