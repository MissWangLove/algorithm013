package time3.a1;

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
     * 使用dp来写，并且看了下第二次做的，三次分别使用了不同的写法
     * 第一天使用了递归
     * 第二遍逆写dp
     * 第三遍使用dp公式来写，但是从代码的简介程度来看 第二遍的代码量似乎更好
     * 第三遍的代码看起来更加清晰明了
     * 时间复杂度和空间复杂度都是 O(m * n)
     */
    public static int uniquePaths(int m, int n) {
        if (m == 0 || n == 0) {
            return 1;
        }
        int[][] dp = new int[m][n];
        // 初始值
        for (int i = 0; i < m; i++) {
            dp[i][n - 1] = 1;
        }
        for (int i = 0; i < n; i++) {
            dp[m - 1][i] = 1;
        }
        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                dp[i][j] = dp[i + 1][j] + dp[i][j + 1];
            }
        }
        return dp[0][0];
    }
}
