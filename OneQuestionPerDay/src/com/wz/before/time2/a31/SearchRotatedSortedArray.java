package com.wz.before.time2.a31;

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
     * 看讲解，然后做，主要的判断是左边还是右边有序，找好边界，标准的微分查找
     * 下面写个写法的思路就是根据前半部分有序和后半部分有序来分别判断，还有一个更简单的写法，
     * 只需要判断前半部分有序，但是我觉得那种写法没有这种写法更容易理解
     * 下面的时间复杂度就是O(log n)
     * 空间复杂度是O(1)
     */
    public static int search(int[] nums, int target) {

        return -1;
    }
}
