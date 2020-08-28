package com.wz.before.time3.a31;

public class SearchRotatedSortedArray {
    /**
     * 搜索旋转排序数组
     * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
     *
     * ( 例如，数组[0,1,2,4,5,6,7]可能变为[4,5,6,7,0,1,2])。
     *
     * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回-1。
     *
     * 你可以假设数组中不存在重复的元素。
     *
     * 你的算法时间复杂度必须是O(logn) 级别。
     *
     * 示例 1:
     *
     * 输入: nums = [4,5,6,7,0,1,2], target = 0
     * 输出: 4
     * 示例2:
     *
     * 输入: nums = [4,5,6,7,0,1,2], target = 3
     * 输出: -1
     */

    public static void main(String[] args) {
        System.out.println(search(new int[]{5, 1, 3}, 3));
    }

    /**
     * 思路，其实就是判断那边有序，然后判断处应该在那边寻找
     * 下面的时间复杂度就是O(log n)
     * 空间复杂度是O(1)
     */
    public static int search(int[] nums, int target) {
       int left = 0;
       int right = nums.length - 1;
       int middle = 0;
       while (left <= right) {
           middle = (left + right) / 2;
           if (nums[middle] == target) {
               return middle;
           } else if (nums[left] <= nums[middle]) {
               // 左侧有序
               if (target > nums[middle] || target < nums[left]) {
                   left = middle + 1;
               } else {
                   right = middle - 1;
               }
           } else {
               // 右侧有序
                if (target < nums[middle] || target > nums[right]) {
                    right = middle - 1;
                } else {
                    left = middle + 1;
                }

           }
       }
        return -1;
    }
}
