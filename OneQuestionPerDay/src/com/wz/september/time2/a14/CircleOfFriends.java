package com.wz.september.time2.a14;

import java.util.LinkedList;
import java.util.Queue;

public class CircleOfFriends {
    /**
     * 朋友圈
     * 班上有N名学生。其中有些人是朋友，有些则不是。他们的友谊具有是传递性。如果已知 A 是 B的朋友，B 是 C的朋友，那么我们可以认为 A 也是 C的朋友。所谓的朋友圈，是指所有朋友的集合。
     *
     * 给定一个N * N的矩阵M，表示班级中学生之间的朋友关系。如果M[i][j] = 1，表示已知第 i 个和 j 个学生互为朋友关系，否则为不知道。你必须输出所有学生中的已知的朋友圈总数。
     *
     * 示例 1：
     *
     * 输入：
     * [[1,1,0],
     *  [1,1,0],
     *  [0,0,1]]
     * 输出：2
     * 解释：已知学生 0 和学生 1 互为朋友，他们在一个朋友圈。
     * 第2个学生自己在一个朋友圈。所以返回 2 。
     * 示例 2：
     *
     * 输入：
     * [[1,1,0],
     *  [1,1,1],
     *  [0,1,1]]
     * 输出：1
     * 解释：已知学生 0 和学生 1 互为朋友，学生 1 和学生 2 互为朋友，所以学生 0 和学生 2 也是朋友，所以他们三个在一个朋友圈，返回 1 。
     *
     * 提示：
     *
     * 1 <= N <= 200
     * M[i][i] == 1
     * M[i][j] == M[j][i]
     */

    /**
     * 其实就是利用数组组成无向图，然后看有多少个无向图。
     */

    public static int findCircleNum(int[][] M) {
        int[] visited = new int[M.length];
        int count = 0;
        Queue<Integer> queue = new LinkedList<>();
        // 先抓住一个完了再说
        for (int i = 0; i < M.length; i++) {
            queue.add(i);
            if (visited[i] == 0) {
                // while循环保证将所有相关的结点全部找到。
                while (!queue.isEmpty()) {
                    Integer remove = queue.remove();
                    for (int j = 0; j < M.length; j++) {
                        if (M[remove][j] == 1 && visited[j] == 0) {
                            visited[j] = 1;
                            queue.add(j);
                        }
                    }
                }
                count ++;
            }
        }

        return count;
    }

    /*public static int findCircleNum(int[][] M) {
        int[] visited = new int[M.length];
        int count = 0;
        for (int i = 0; i < M.length; i++) {
            if (visited[i] == 0) {
                dfs(i, M, visited);
                count ++;
            }
        }
        return count;
    }

    private static void dfs(int i, int[][] m, int[] visited) {
        for (int j = 0; j < m.length; j++) {
            if (m[i][j] == 1 && visited[j] == 0) {
                visited[j] = 1;
                dfs(j, m, visited);
            }
        }
    }*/

    public static void main(String[] args) {
        System.out.println(findCircleNum(new int[][]{
                {1,1,0},
                {1,1,0},
                {0,0,1}
        }));
        System.out.println(findCircleNum(new int[][]{
                {1,0,0,1},
                {0,1,1,0},
                {0,1,1,1},
                {1,0,1,1}
        }));
        System.out.println(findCircleNum(new int[][]{
                {1,1,0,0},
                {1,1,1,0},
                {0,1,1,1},
                {0,0,1,1}
        }));
        System.out.println(findCircleNum(new int[][]{
                {1,1,0,0},
                {1,1,0,0},
                {0,0,1,1},
                {0,0,1,1}
        }));
    }
}
