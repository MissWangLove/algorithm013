package com.wz.algoritm.a2;

/**
 * @author wz157
 */
public class ContainerWater {

    /**
     * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
     *
     * 说明：你不能倾斜容器，且 n 的值至少为 2。
     */

    /**
     * 这个题呢其实第一眼看上去没思路，但是看了视频才有了思路：
     * 1. 没有思路的时候暴力求解，这道题是可以直接暴力求解的，双层for循环遍历，枚举每一种情况，计算就好。 O(n^2)
     * 2. 左右夹逼法： 这个思路的核心就在于要弄懂原理，左右两个指针向中间移动，什么时候移动哪一个指针很重要。 O(n)
     *
     * 左右夹逼法写法简单，但是原理需要脑海中清晰，为什么左右两个指针移动就可以，遇到长的计算，短的直接略过，隐藏了一个已知条件，
     * 那就是每次指针移动只移动一个，也就是横坐标减一，只有纵坐标增加的情况下，面积才有可能变大
     */

    public static void main(String[] args) {
        int[] arr = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(arr));
    }


    /**
     * 左右夹逼法求解  O(n)的时间复杂度
     * @param height
     * @return
     */
    public static int maxArea(int[] height) {
        int result = 0;
        for (int i = 0, j = height.length - 1; i < j; ) {
            // 思路没问题，写法优化下
            /*int area = Math.min(height[i], height[j]) * (j - i);
            result =Math.max(area, result);
            if (height[i] > height[j]) {
                j--;
            } else {
                i++;
            }*/
            int minHeight = height[i] > height[j] ? height[j --] : height[i ++];
            int area = (j - i + 1) * minHeight;
            result = Math.max(area, result);
        }
        return result;
    }

    /**
     * 双层for循环暴力求解  O(n^2)的时间复杂度
     * @param height
     * @return
     */
    /*public static int maxArea(int[] height) {
        int result = 0;
        for (int i = 0; i < height.length - 1; i++) {
            for (int i1 = i + 1; i1 < height.length; i1++) {
                int area = Math.min(height[i], height[i1]) * (i1 - i);
                result =Math.max(area, result);
            }
        }
        return result;
    }*/
}
