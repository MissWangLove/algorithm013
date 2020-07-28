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
     * 1. 加一个数组，判断复制，记录非0或者0的个数，都可以，最后填补0  时间复杂度为O（n）
     * 2. 利用上一个思路，主需要记录0的个数，无需额外的数组开支
     */
    public static void main(String[] args) {
        int[] nums = {0,1,0,3,12};
        int zeroNum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zeroNum ++;
            } else if (zeroNum > 0) {
                nums[i - zeroNum] = nums[i];
                nums[i] = 0;
            }
        }

        printArr(nums);

    }

    private static void printArr(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }

}
