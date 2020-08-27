package com.wz.before.time1.a10;

import java.util.ArrayDeque;
import java.util.Deque;

public class MaximumSlidingWindow {

    /**
     * 给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。
     *
     * 示例:
     *
     * 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
     * 输出: [3,3,5,5,6,7]
     * 解释:
     *
     *   滑动窗口的位置                最大值
     * ---------------               -----
     * [1  3  -1] -3  5  3  6  7       3
     *  1 [3  -1  -3] 5  3  6  7       3
     *  1  3 [-1  -3  5] 3  6  7       5
     *  1  3  -1 [-3  5  3] 6  7       5
     *  1  3  -1  -3 [5  3  6] 7       6
     *  1  3  -1  -3  5 [3  6  7]      7
     *
     * 提示：
     *
     * 你可以假设 k 总是有效的，在输入数组不为空的情况下，1 ≤ k ≤输入数组的大小。
     */

    /**
     * 1. 数组的长度可以知道，就是数组长度 - k + 1，双for循环，内层循环 k - 1次，外层循环nums.length - k + 1次
     * ---- 2. 一次计算前k个的最大值，那下一个k的最大值其实就是前一个最大值和新入的那个元素的对比(思路错误)
     * 2. 看了题解之后发现上面错误的思路还是有可取之处的，主要多声明一个最大值所在的下标，然后判断下标是否在下一个滑动窗口内就好，这个写法不错
     * 3. 外国友人思路： 双端队列对首存储滑动窗口内最大元素的数组索引，当双端队列内的数组元素索引超出滑动窗口的起始索引，就弹出索引，或者是移动的时候
     * 下一个元素大于队列中索引对应的元素，弹出，如果不大，则入队。这个双端队列用的号
     */

    public static void main(String[] args) {
        int[] arr = new int[]{7,2,4};
        printArr(maxSlidingWindow(arr, 2));
    }

    private static void printArr(int[] arr) {
        for (int i : arr) {
            System.out.println(i);
        }
    }

    /**
     * 双端队列
     */
    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (k == 1 || nums.length == 0) {
            return nums;
        }
        int[] result = new int[nums.length - k + 1];
        int ri = 0;
        Deque<Integer> arrayDeque = new ArrayDeque<>();
        for (int i = 0; i < nums.length; i++) {
            while (!arrayDeque.isEmpty() && arrayDeque.peek() < i - k + 1) {
                arrayDeque.poll();
            }
            while (!arrayDeque.isEmpty() && nums[arrayDeque.peek()] < nums[i]) {
                arrayDeque.pollLast();
            }
            arrayDeque.offer(i);
            if (i >= k - 1) {
                result[ri ++] = nums[arrayDeque.peek()];
            }
        }
        return result;
    }

   /* public static int[] maxSlidingWindow(int[] nums, int k) {
        if (k == 1 || nums.length == 0) {
            return nums;
        }
        int[] result = new int[nums.length - k + 1];
        int loop = nums.length - k + 1;
        int max = Integer.MIN_VALUE;
        int maxIndex = -1;
        for (int i = 0; i < loop; i++) {
            if (maxIndex >= i) {
                if (max < nums[i + k - 1]) {
                    max = nums[i + k - 1];
                    maxIndex = i + k - 1;
                }
                result[i] = max;
            } else {
                max = nums[i];
                for (int i1 = i + 1; i1 < k + i; i1++) {
                    if (max < nums[i1]) {
                        max = nums[i1];
                        maxIndex = i1;
                    }
                }
                result[i] = max;
            }
        }
        return result;
    }*/

    /*public static int[] maxSlidingWindow(int[] nums, int k) {
        if (k == 1 || nums.length == 0) {
            return nums;
        }
        int[] result = new int[nums.length - k + 1];
        int loop = nums.length - k + 1;
        for (int i = 0; i < loop; i++) {
            int max = nums[i];
            for (int i1 = i + 1; i1 < k + i; i1++) {
                max = Math.max(max, nums[i1]);
            }
            result[i] = max;
        }
        return result;
    }*/

}
