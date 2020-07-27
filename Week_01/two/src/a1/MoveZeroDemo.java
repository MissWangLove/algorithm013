package a1;

/**
 * @author 王智
 */
public class MoveZeroDemo {

    /**
     * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
     *
     * 示例:
     *
     * 输入: [0,1,0,3,12]
     * 输出: [1,3,12,0,0]
     * 说明:
     *
     * 必须在原数组上操作，不能拷贝额外的数组。
     * 尽量减少操作次数。
     */

    /**
     * 两种解题思路
     * 1. 在一个数组，用来拷贝。时间复杂度为O(n) - 但是不符合题意
     * 2. 借鉴第1种思路： 只不过不用数组，在原数组上操作，只要保证前面的元素不为0，记住不为0的元素个数就好
     */
    public static void main(String[] args) {
        int[] nums = {0,1,0,3,12};

    }

    private static void printArr(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }

}
