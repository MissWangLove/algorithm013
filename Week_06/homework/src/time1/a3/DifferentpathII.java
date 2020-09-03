package time1.a3;

public class DifferentpathII {
    /**
     * 不同路径 II
     * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
     *
     * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
     *
     * 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
     * 网格中的障碍物和空位置分别用 1 和 0 来表示。
     *
     * 说明：m和 n 的值均不超过 100。
     *
     * 示例1:
     *
     * 输入:
     * [
     *  [0,0,0],
     *  [0,1,0],
     *  [0,0,0]
     * ]
     * 输出: 2
     * 解释:
     * 3x3 网格的正中间有一个障碍物。
     * 从左上角到右下角一共有 2 条不同的路径：
     * 1. 向右 -> 向右 -> 向下 -> 向下
     * 2. 向下 -> 向下 -> 向右 -> 向右
     *
     */

    /**
     * 继续动态规划，只不过在判断的过程中要小心1，阻挡物，那就是 dp[0][0] = dp[0][1] + dp[1][0]
     * 那初始值就是dp[0][y]和dp[x][0]都是1
     */

    public static void main(String[] args) {
        /*System.out.println(uniquePathsWithObstacles(new int[][]{
                {0, 0, 0},{0, 1, 0},{0, 0, 0}
        }));*/
        System.out.println(uniquePathsWithObstacles(new int[][]{
                {0, 1}
        }));
        System.out.println(uniquePathsWithObstacles(new int[][]{
                {1, 0}
        }));
    }

    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0) {
            return 0;
        }
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        // 初始值(这里写的太巧妙了，后面加上&&作为判断条件，如果当前已经为障碍物，后面就不用判断了)
        for (int i = 0; i < m && obstacleGrid[i][0] == 0; i++) {
                dp[i][0] = 1;
        }
        for (int j = 0; j < n && obstacleGrid[0][j] == 0; j++) {
                dp[0][j] = 1;
        }
        /// 错误的代码
        /*for (int i = 0; i < m; i++) {
            if (obstacleGrid[i][0] == 0) {
                dp[i][0] = 1;
            }
        }
        for (int j = 0; j < n; j++) {
            if (obstacleGrid[0][j] == 0) {
                dp[0][j] = 1;
            }
        }*/
        // DP递推
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 0) {
                    dp[i][j] = dp[i - 1][j] + dp[i][ j - 1];
                }
            }
        }
        return dp[m - 1][n - 1];
    }
}
