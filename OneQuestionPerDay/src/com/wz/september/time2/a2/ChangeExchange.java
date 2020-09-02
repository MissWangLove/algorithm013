package com.wz.september.time2.a2;

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
        System.out.println(coinChange(new int[]{1,2,5}, 11));
//        System.out.println(coinChange(new int[]{2}, 3));
        System.out.println(coinChange(new int[]{186,419,83,408}, 6249));
    }

    /**
     * 看了题解，也不是很明白，感觉自底向上的解法比较容易理解，所以这里就用这个方法试试，没看太懂，先抄把。
     * 时间复杂度O（Sn）
     * 空间复杂度O（S）
     */
    public static int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length == 0) {
            return -1;
        }
        int[] coinArr = new int[amount + 1];
        Arrays.fill(coinArr, amount + 1);
        // 表示需要coins里面的每个硬币至少几枚，最少的硬币数
        // 比如说 1就是需要1枚1，2需要一枚2，3至少需要两个，
        coinArr[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int i1 = 0; i1 < coins.length; i1++) {
                // 防止越界
                if (coins[i1] <= i) {
                    coinArr[i] = Math.min(coinArr[i], coinArr[i - coins[i1]] + 1);
                }
            }
        }
        return coinArr[amount] > amount ? -1 : coinArr[amount];
    }


}
