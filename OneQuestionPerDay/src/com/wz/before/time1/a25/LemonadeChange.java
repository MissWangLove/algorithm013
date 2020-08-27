package com.wz.before.time1.a25;

public class LemonadeChange {
    /**
     * 柠檬水找零
     *
     * 在柠檬水摊上，每一杯柠檬水的售价为5美元。
     *
     * 顾客排队购买你的产品，（按账单 bills 支付的顺序）一次购买一杯。
     *
     * 每位顾客只买一杯柠檬水，然后向你付 5 美元、10 美元或 20 美元。你必须给每个顾客正确找零，也就是说净交易是每位顾客向你支付 5 美元。
     *
     * 注意，一开始你手头没有任何零钱。
     *
     * 如果你能给每位顾客正确找零，返回true，否则返回 false。
     *
     * 示例 1：
     *
     * 输入：[5,5,5,10,20]
     * 输出：true
     * 解释：
     * 前 3 位顾客那里，我们按顺序收取 3 张 5 美元的钞票。
     * 第 4 位顾客那里，我们收取一张 10 美元的钞票，并返还 5 美元。
     * 第 5 位顾客那里，我们找还一张 10 美元的钞票和一张 5 美元的钞票。
     * 由于所有客户都得到了正确的找零，所以我们输出 true。
     * 示例 2：
     *
     * 输入：[5,5,10]
     * 输出：true
     * 示例 3：
     *
     * 输入：[10,10]
     * 输出：false
     * 示例 4：
     *
     * 输入：[5,5,10,10,20]
     * 输出：false
     * 解释：
     * 前 2 位顾客那里，我们按顺序收取 2 张 5 美元的钞票。
     * 对于接下来的 2 位顾客，我们收取一张 10 美元的钞票，然后返还 5 美元。
     * 对于最后一位顾客，我们无法退回 15 美元，因为我们现在只有两张 10 美元的钞票。
     * 由于不是每位顾客都得到了正确的找零，所以答案是 false。
     *
     *
     * 提示：
     *
     * 0 <= bills.length <= 10000
     * bills[i]不是5就是10或是20
     *
     */

    /**
     * 思路
     * 找规律，10需要一个5,20需要一个10和一个5或者三个5，可以可以用每个数字出现的个数来判断呢？感觉可以。错误。
     *
     * 使用Map循环来实现
     */

    public static void main(String[] args) {
        System.out.println(lemonadeChange(new int[]{5,5,5,10,5,20,5,10,5,20}));
        System.out.println(lemonadeChange(new int[]{5,5,10}));
        System.out.println(lemonadeChange(new int[]{10,10}));
        System.out.println(lemonadeChange(new int[]{5,5,10,10,20}));
    }

    /**
     * 不使用map，直接计数,优化map
     * 时间复杂度O(n)
     * 空间复杂度O(1)
     */
    public static boolean lemonadeChange(int[] bills) {
        int fiveNum = 0;
        int tenNum = 0;
        for (int bill : bills) {
            if (bill == 5) {
                fiveNum ++;
            } else if (bill == 10) {
                tenNum ++;
                fiveNum --;
            } else {
                tenNum -= 1;
                if (tenNum < 0) {
                    fiveNum -= 3;
                    tenNum = 0;
                } else {
                    fiveNum --;
                }
            }
            if (fiveNum < 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * map实现
     * 时间复杂度O(n)
     * 空间复杂度O(1)
     */
    /*public static boolean lemonadeChange(int[] bills) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < bills.length; i++) {
            if (bills[i] == 5) {
                map.put(5, map.getOrDefault(5, 0) + 1);
            } else if (bills[i] == 10) {
                if (map.getOrDefault(5, 0) <= 0) {
                    return false;
                } else {
                    map.put(5, map.getOrDefault(5, 0) - 1);
                    map.put(10, map.getOrDefault(10, 0) + 1);
                }
            } else {
                if (map.getOrDefault(10, 0) >= 1 && map.getOrDefault(5, 0) >= 1) {
                    map.put(5, map.getOrDefault(5, 0) - 1);
                    map.put(10, map.getOrDefault(10, 0) - 1);
                    map.put(20, map.getOrDefault(20, 0) + 1);
                } else if (map.getOrDefault(5, 0) >= 3) {
                    map.put(5, map.getOrDefault(5, 0) - 3);
                    map.put(20, map.getOrDefault(20, 0) + 1);
                } else {
                    return false;
                }
            }
        }
        return true;
    }*/

    /**
     * 换种思路, 错误解法，有序，不能根据个数判断
     */
    /// 错误解法
    /*public static boolean lemonadeChange(int[] bills) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int bill : bills) {
            map.put(bill, map.getOrDefault(bill, 0) + 1);
        }
        Integer tenNum = map.getOrDefault(10, 0);
        Integer fiveNum = map.getOrDefault(5, 0);
        Integer twentyNum = map.getOrDefault(20, 0);
        if (tenNum > 0) {
            int num = fiveNum - tenNum;
            if (num < 0) {
                return false;
            } else {
                fiveNum = num;
            }
        }
        if (twentyNum > 0) {
            if (twentyNum > tenNum) {
                twentyNum = twentyNum - tenNum;
                if (twentyNum * 3 + twentyNum > fiveNum) {
                    return false;
                }
            } else if (fiveNum < twentyNum) {
               return false;
            }
        }
        return true;
    }*/


}
