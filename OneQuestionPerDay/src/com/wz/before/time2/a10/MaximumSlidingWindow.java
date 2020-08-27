package com.wz.before.time2.a10;

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
     * 1. 直接上最简单的写法，双端队列，思路难点在于什么时候出队，什么时候入队，出队的情况有哪几种
     * 2. 声明一个最大值和最大值对应的索引，然后while中判断，分两种情况，一种是最大值对应的索引在滑动窗口的索引内，一种是不在，分开处理
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
        int resultIndex = 0;
        Deque<Integer> deque = new ArrayDeque<>(k + 1);
        for (int i = 0; i < nums.length; i++) {
            while (!deque.isEmpty() && deque.peek() < i - k + 1) {
                deque.poll();
            }
            while (!deque.isEmpty() && nums[deque.peek()] < nums[i]) {
                deque.pollLast();
            }
            deque.offer(i);
            if (i >= k - 1) {
                result[resultIndex ++] = nums[deque.peek()];
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


}
