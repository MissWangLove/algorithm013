package com.wz.before.time3.a10;

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
     * 1. 利用双端队列，双端队列存储索引值
     * 2. 保存最大数和最大数的索引，根据索引判断是否在滑动窗口内，在就判断，不在就重新选取最大值
     */



    public static void main(String[] args) {
        int[] arr = new int[]{1,3,-1,-3,5,3,6,7};
        printArr(maxSlidingWindow(arr, 3));
    }

    private static void printArr(int[] arr) {
        for (int i : arr) {
            System.out.println(i);
        }
    }

    /**
     * 双端队列
     * 时间复杂度O(n)
     * 空间复杂度O(n)
     */
    /*public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0 || k == 0) {
            return nums;
        }
        int[] result = new int[nums.length - k + 1];
        LinkedList<Integer> linkedList = new LinkedList<>();
        int num = 0;
        for (int i = 0; i < nums.length; i++) {
            while (!linkedList.isEmpty() && linkedList.peek() < i - k + 1) {
                linkedList.poll();
            }
            while (!linkedList.isEmpty() && nums[linkedList.peekLast()] < nums[i]) {
                linkedList.pollLast();
            }
            linkedList.offer(i);
            if (i >= k - 1) {
                   result[num ++] = nums[linkedList.peek()];
            }
        }
        return result;
    }*/

    /**
     * 使用最大值和索引来进行判断
     * 时间复杂度为O(nums.length - k + 1)
     * 空间复杂度为O(k)
     */
    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0 || k == 0) {
            return nums;
        }
        int[] result = new int[nums.length - k + 1];
        int max = Integer.MIN_VALUE;
        int maxIndex = -1;
        int loop = nums.length - k + 1;
        for (int i = 0; i < loop; i++) {
            if (maxIndex > i) {
                // 上一个滑动窗口的最大值还在当前滑动窗口内，比较最后一个进入滑动窗口的值
                if (max < nums[i + k - 1]) {
                    max = nums[i + k - 1];
                    maxIndex = i + k - 1;
                }
                result[i] = max;

            } else {
                // 计算滑动窗口内的最大值，当前的滑动窗口的最后一位索引时 i + k - 1
                max = nums[i];
                for (int i1 = i + 1; i1 < k + i; i1++) {
                    if (nums[i1] > max) {
                        max = nums[i1];
                        maxIndex = i1;
                    }
                }
                result[i] = max;
            }
        }

        return result;
    }


}
