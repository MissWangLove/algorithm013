package a2;

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
     * 思路：
     * 1. 暴力求解法： 双层for循环来枚举每一种情况，计算最大面积
     * 2. 左右夹逼法来计算，移动小的指针
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
        // 左右夹逼法的准则是指针的移动
        for (int i = 0, j = height.length - 1; i < j;) {
            int minHeight = height[i] > height[j] ? height[j --] : height[i ++];
            int area = minHeight * (j - i + 1);
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
            for (int j = i + 1; j < height.length; j++) {
                int area = (j - i) * Math.min(height[i], height[j]);
                result = result > area ? result : area;
            }
        }
        return result;
    }*/
}
