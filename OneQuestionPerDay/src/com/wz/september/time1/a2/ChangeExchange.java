package com.wz.september.time1.a2;

import java.util.Arrays;

public class ChangeExchange {

    /**
     * 零钱兑换
     * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。
     * 如果没有任何一种硬币组合能组成总金额，返回-1。
     *
     * 示例1:
     *
     * 输入: coins = [1, 2, 5], amount = 11
     * 输出: 3
     * 解释: 11 = 5 + 5 + 1
     * 示例 2:
     *
     * 输入: coins = [2], amount = 3
     * 输出: -1
     *
     *
     * 说明:
     * 你可以认为每种硬币的数量是无限的。
     */

    /**
     * 如何解决？
     * 脑海中第一个思路。无限取余，思路有点小错误，因为从大到小，只计算了一遍，如果组成不需要最大值，
     * 那就会出现计算错误的情况，再想想，有什么更好的办法吗？ 思路不完善，直接看题解
     *
     */

    public static void main(String[] args) {
//        System.out.println(coinChange(new int[]{1,2,5}, 11));
//        System.out.println(coinChange(new int[]{2}, 3));
        System.out.println(coinChange(new int[]{186,419,83,408}, 6249));
    }

    public static int coinChange(int[] coins, int amount) {

        return -1;
    }

    // 错误思路
    /*public static int coinChange(int[] coins, int amount) {
        int result = 0;
        Arrays.sort(coins);
        for (int i = coins.length - 1; i >= 0; i--) {
            result = getResult(i, coins, amount);
            if (result != -1) {
                break;
            }
        }

        return result;
    }

    private static int getResult(int level, int[] coins, int amount) {
        int result = 0;
        for (int i = level; i >= 0; i--) {
            int temp = amount / coins[i];
            result +=  temp;
            amount = amount - temp * coins[i];
            if (amount == 0) {
                break;
            }
        }
        return amount == 0 ? result : -1;
    }*/

}
