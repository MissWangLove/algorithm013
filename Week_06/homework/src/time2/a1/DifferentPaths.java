package time2.a1;

public class DifferentPaths {
    /**
     * 不同路径
     * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
     *
     * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
     *
     * 问总共有多少条不同的路径？
     * 输入: m = 3, n = 2
     * 输出: 3
     * 解释:
     * 从左上角开始，总共有 3 条路径可以到达右下角。
     * 1. 向右 -> 向右 -> 向下
     * 2. 向右 -> 向下 -> 向右
     * 3. 向下 -> 向右 -> 向右
     * 示例2:
     *
     * 输入: m = 7, n = 3
     * 输出: 28
     *
     */

    /**
     * 这道题思路比较简单，很容易找到公式，其实就是开始结点的右结点到达右下角和下结点到达右下角的结点之和。
     * 这个就是思路了。
     */

    public static void main(String[] args) {
        System.out.println(uniquePaths(3, 2));
        System.out.println(uniquePaths(7, 3));
    }

    /**
     * 自顶向下考虑
     */
    public static int uniquePaths(int m, int n) {
        if (m == 0 || n == 0) {
            return 1;
        }

        return 1;
    }
}
