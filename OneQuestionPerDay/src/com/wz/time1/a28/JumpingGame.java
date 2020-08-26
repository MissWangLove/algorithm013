package com.wz.time1.a28;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class JumpingGame {

    /**
     * 跳跃游戏
     * 给定一个非负整数数组，你最初位于数组的第一个位置。
     *
     * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
     *
     * 判断你是否能够到达最后一个位置。
     *
     * 示例1:
     *
     * 输入: [2,3,1,1,4]
     * 输出: true
     * 解释: 我们可以先跳 1 步，从位置 0 到达 位置 1, 然后再从位置 1 跳 3 步到达最后一个位置。
     * 示例2:
     *
     * 输入: [3,2,1,0,4]
     * 输出: false
     * 解释: 无论怎样，你总会到达索引为 3 的位置。但该位置的最大跳跃长度是 0 ， 所以你永远不可能到达最后一个位置。
     */

    public static void main(String[] args) {
        // System.out.println(canJump(new int[]{2,3,1,1,4}));
//        System.out.println(canJump(new int[]{3,2,1,0,4}));
        System.out.println(urlEncode("http://1.shiyuesoft.com/home-mobile","utf-8"));
    }
    public static String urlEncode(String value, String encoding) {
        if (value == null) {
            return "";
        }
        try {
            String encoded = URLEncoder.encode(value, encoding);
            return encoded.replace("+", "%20").replace("*", "%2A")
                    .replace("~", "%7E").replace("/", "%2F");
        } catch (UnsupportedEncodingException e) {
            throw new IllegalArgumentException("FailedToEncodeUri", e);
        }
    }

    /**
     * 先说说自己的想法，这个题我的思路是每个元素可以跳一位或多位，只有出现0的时候不可以跳，那就是在出现0的时候判断是否可以跳过0到达下一位
     * 就好，就这么做，做的时候考虑好边界条件就好
     * 这个的时间复杂度就是 0的个数和0所在的索引位置决定的
     * 空间复杂度就是 O（1）
     */
    public static boolean canJump(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int count = 1;
            int j = i;
            if (nums[i] == 0 && i != nums.length - 1) {
                for (int i1 = 0; i1 < i; i1++) {
                    j --;
                    if (nums[j] > count) {
                        break;
                    }
                    count ++;
                }
                if (count > i) {
                    return false;
                }
            }
        }
        return true;
    }
}
