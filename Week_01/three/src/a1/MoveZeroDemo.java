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
     * 第三遍：
     * 1. 记录0的个数，遇到非0的，和0位置的元素进行交换
     * 2. 记录非0的个数，作为数组的当前不为0的索引，遇到非0的，就向当前索引出放，最后用数组的长度 - 索引的长度以后全部赋值为0
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
