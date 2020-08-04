package a2;


/**
 * @author wz157
 */
public class ContainerWater {

    /**
     * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点(i,ai) 。在坐标内画 n 条垂直线，垂直线 i的两个端点分别为(i,ai) 和 (i, 0)。
     * 找出其中的两条线，使得它们与x轴共同构成的容器可以容纳最多的水。
     *
     * 说明：你不能倾斜容器，且n的值至少为 2。
     */

    /**
     * 1. 暴力求解，枚举所有的面积，双层for循环暴力求解
     * 2. 左右夹逼法：两个指针分别从左右两端向中间移动，哪个指针长度小移动哪个，如果下一个指针长度比上一个还小，增继续移动，其实就是横坐标逐渐变短，
     * 则纵坐标需要边长面积才有可能大。
     *
     */

    public static void main(String[] args) {
        int[] arr = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(arr));
    }

    /**
     * 左右夹逼法，for循环简化while循环
     */
    public static int maxArea(int[] height) {
        int result = 0;
        for (int i = 0, j = height.length - 1; i < j;) {
            int minHeight = height[i] > height[j] ? height[j --] : height[i ++];
            // +1 是因为上面的一步操作将两个之间的距离拉近了一格
            result = Math.max(result, minHeight * (j - i + 1));
        }
        return result;
    }

    /**
     * 左右夹逼法求解  O(n)的时间复杂度
     * @param height
     * @return
     */
    /*public static int maxArea(int[] height) {
        int result = 0;
        int first = 0;
        int end = height.length - 1;
        while (first < end) {
            int max = Math.min(height[first], height[end]) * (end - first);
            result = Math.max(max, result);
            if (height[first] < height[end]) {
                while (first < end && height[first] >= height[++ first]) {}
            } else {
                while (first < end && height[end] >= height[-- end]) {}
            }
        }
       return result;
    }*/

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
