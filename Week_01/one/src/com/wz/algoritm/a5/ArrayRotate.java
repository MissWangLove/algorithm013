package com.wz.algoritm.a5;

/**
 * @author wangzhi
 */
public class ArrayRotate {

    /**
     * 给定一个数组，将数组中的元素向右移动k个位置，其中k是非负数。
     *
     * 示例 1:
     *
     * 输入: [1,2,3,4,5,6,7] 和 k = 3
     * 输出: [5,6,7,1,2,3,4]
     * 解释:
     * 向右旋转 1 步: [7,1,2,3,4,5,6]
     * 向右旋转 2 步: [6,7,1,2,3,4,5]
     * 向右旋转 3 步: [5,6,7,1,2,3,4]
     * 示例2:
     *
     * 输入: [-1,-100,3,99] 和 k = 2
     * 输出: [3,99,-1,-100]
     * 解释:
     * 向右旋转 1 步: [99,-1,-100,3]
     * 向右旋转 2 步: [3,99,-1,-100]
     *
     */

    /**
     * 明天看解析：
     * 1. 暴力求解，三层for循环，可以做出来，要考虑的就是 k > nums.length的特殊情况就好
     *
     */

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3};
        rotate(nums1, 2);
        print(nums1);
    }

    private static void print(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }

    public static void rotate(int[] nums, int k) {

    }
}
