package time2.a3;

public class NumberOfIslands {
    /**
     * 岛屿的数量：
     * 给你一个由'1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
     *
     * 岛屿总是被水包围，并且每座岛屿只能由水平方向或竖直方向上相邻的陆地连接形成。
     *
     * 此外，你可以假设该网格的四条边均被水包围。
     *
     *
     *
     * 示例 1:
     *
     * 输入:
     * [
     * ['1','1','1','1','0'],
     * ['1','1','0','1','0'],
     * ['1','1','0','0','0'],
     * ['0','0','0','0','0']
     * ]
     * 输出:1
     * 示例2:
     *
     * 输入:
     * [
     * ['1','1','0','0','0'],
     * ['1','1','0','0','0'],
     * ['0','0','1','0','0'],
     * ['0','0','0','1','1']
     * ]
     * 输出: 3
     * 解释: 每座岛屿只能由水平和/或竖直方向上相邻的陆地连接而成。
     */

    /**
     * 拿到题目，没有思路，然后继续看视频，老师提到相邻清0法，有思路了，可以继续做了，视频等做完了再看。
     * 使用dfs还是bfs呢？使用bfs
     */

    public static void main(String[] args) {
//        char[][] grid = {{'1','1','1'},{'0','1','0'},{'1','1','1'}};
        char[][] grid = {
                {'1','1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '0', '0', '1', '1', '1', '1',
                        '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1',
                        '1', '0', '0', '0', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1',
                        '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1'}};

        System.out.println(numIslands(grid));
    }

    /**
     * 使用dfs,效率大大提高，所以也就说明了能用bfs解决的，就尝试使用dfs解决
     * 时间复杂度是 O(m * n)
     * 空间复杂度是 O(m * n)
     */
    public static int numIslands(char[][] grid) {
        int result = 0;
        int xLength = grid.length;
        if (xLength == 0) {
            return result;
        }
        int yLength = grid[0].length;
        for (int i = 0; i < grid.length; i++) {
            for (int i1 = 0; i1 < grid[i].length; i1++) {
                if (grid[i][i1] == '1') {
                    dfs(i, i1, xLength, yLength, grid);
                    result ++;
                }
            }
        }

        return result;
    }

    private static void dfs(int x, int y, int xLength, int yLength, char[][] grid) {
        if (x < 0 || y < 0 || x >= xLength || y>= yLength || grid[x][y] == '0') {
            return  ;
        }
        grid[x][y] = '0';
        dfs(x + 1, y, xLength, yLength, grid);
        dfs(x - 1, y, xLength, yLength, grid);
        dfs(x, y + 1, xLength, yLength, grid);
        dfs(x, y - 1, xLength, yLength, grid);
    }


    /**
     * 顺利写下来，但是效率并不是很好，一会看视频，这个现在这里是使用bfs
     * 时间复杂度是 O(m * n)
     * 空间复杂度是 O(m * n) 这里为什么会是 O(MIN(m, n)) ？  todo 不懂
     */
    /*public static int numIslands(char[][] grid) {
        int result = 0;
        Deque<List<Integer>> deque = new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int i1 = 0; i1 < grid[i].length; i1++) {
                if (Character.getNumericValue(grid[i][i1]) == 1) {
                    grid[i][i1] = '0';
                    deque.add(Arrays.asList(i, i1));
                    while (!deque.isEmpty()) {
                        int size = deque.size();
                        for (int i2 = 0; i2 < size; i2++) {
                            List<Integer> poll = deque.poll();
                            int x = poll.get(0);
                            int y = poll.get(1);
                            // 四角
                            if (x < grid.length - 1 && Character.getNumericValue(grid[x + 1][y]) == 1) {
                                grid[x + 1][y] = '0';
                                deque.add(Arrays.asList(x + 1, y));
                            }
                            if (y < grid[i].length - 1 && Character.getNumericValue(grid[x][y + 1]) == 1) {
                                grid[x][y + 1] = '0';
                                deque.add(Arrays.asList(x, y + 1));
                            }
                            if (x - 1 >= 0 && Character.getNumericValue(grid[x - 1][y]) == 1) {
                                grid[x - 1][y] = '0';
                                deque.add(Arrays.asList(x - 1, y));
                            }
                            if (y - 1 >= 0 && Character.getNumericValue(grid[x][y - 1]) == 1) {
                                grid[x][y - 1] = '0';
                                deque.add(Arrays.asList(x, y - 1));
                            }
                        }
                    }
                    result ++;
                }
            }
        }
        return result;
    }*/
}
