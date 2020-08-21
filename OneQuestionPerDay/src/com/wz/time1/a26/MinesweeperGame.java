package com.wz.time1.a26;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class MinesweeperGame {
    /**
     * 扫雷游戏
     *
     * 让我们一起来玩扫雷游戏！
     *
     * 给定一个代表游戏板的二维字符矩阵。'M'代表一个未挖出的地雷，'E'代表一个未挖出的空方块，'B'代表没有相邻（上，下，左，右，和所有4个对角线）地雷的已挖出的空白方块，数字（'1' 到 '8'）表示有多少地雷与这块已挖出的方块相邻，'X'则表示一个已挖出的地雷。
     *
     * 现在给出在所有未挖出的方块中（'M'或者'E'）的下一个点击位置（行和列索引），根据以下规则，返回相应位置被点击后对应的面板：
     *
     * 如果一个地雷（'M'）被挖出，游戏就结束了- 把它改为'X'。
     * 如果一个没有相邻地雷的空方块（'E'）被挖出，修改它为（'B'），并且所有和其相邻的未挖出方块都应该被递归地揭露。
     * 如果一个至少与一个地雷相邻的空方块（'E'）被挖出，修改它为数字（'1'到'8'），表示相邻地雷的数量。
     * 如果在此次点击中，若无更多方块可被揭露，则返回面板。
     *
     *
     * 示例 1：
     *
     * 输入:
     *
     * [['E', 'E', 'E', 'E', 'E'],
     *  ['E', 'E', 'M', 'E', 'E'],
     *  ['E', 'E', 'E', 'E', 'E'],
     *  ['E', 'E', 'E', 'E', 'E']]
     *
     * Click : [3,0]
     *
     * 输出:
     *
     * [['B', '1', 'E', '1', 'B'],
     *  ['B', '1', 'M', '1', 'B'],
     *  ['B', '1', '1', '1', 'B'],
     *  ['B', 'B', 'B', 'B', 'B']]
     *
     * 解释:
     *
     * 示例 2：
     *
     * 输入:
     *
     * [['B', '1', 'E', '1', 'B'],
     *  ['B', '1', 'M', '1', 'B'],
     *  ['B', '1', '1', '1', 'B'],
     *  ['B', 'B', 'B', 'B', 'B']]
     *
     * Click : [1,2]
     *
     * 输出:
     *
     * [['B', '1', 'E', '1', 'B'],
     *  ['B', '1', 'X', '1', 'B'],
     *  ['B', '1', '1', '1', 'B'],
     *  ['B', 'B', 'B', 'B', 'B']]
     */

    public static void main(String[] args) {
        char[][] board = {{'E', 'E', 'E', 'E', 'E'},
                {'E', 'E', 'M', 'E', 'E'},
                {'E', 'E', 'E', 'E', 'E'},
                {'E', 'E', 'E', 'E', 'E'}};
        updateBoard(board, new int[]{3,0});
        for (int i = 0; i < board.length; i++) {
            for (int i1 = 0; i1 < board[i].length; i1++) {
                System.out.print(board[i][i1] + ", ");
            }
            System.out.println();
        }
    }

    static int[] dirX = {0, 1, 0, -1, 1, 1, -1, -1};
    static int[] dirY = {1, 0, -1, 0, 1, -1, 1, -1};

    /**
     * 使用dfs如何解决呢？
     */
    public static char[][] updateBoard(char[][] board, int[] click) {


        return board;
    }

    /**
     * 看题解，优化自己的代码和多种方案解题，发现自己犯了个致命的错误，
     * 就是没有记录节点有无被访问，这个必须得有，所以以后再使用bfs的时候就按照
     * 标准模板来写，就没错。
     * 时间复杂度和空间复杂度都是 O(nm)
     */
    /*public static char[][] updateBoard(char[][] board, int[] click) {
        if (board[click[0]][click[1]] == 'M') {
            board[click[0]][click[1]] = 'X';
            return board;
        }
        Deque<int[]> deque = new LinkedList<int[]>();
        boolean[][] visit = new boolean[board.length][board[0].length];
        deque.add(click);
        while (!deque.isEmpty()) {
            int length = deque.size();
            for (int i = 0; i < length; i++) {
                int tempNum = 0;
                int[] pop = deque.pop();
                int x = pop[0];
                int y = pop[1];
                for (int i1 = 0; i1 < 8; i1++) {
                    int tx = x + dirX[i1];
                    int ty = y + dirY[i1];
                    if (tx < 0 || ty < 0 || tx >= board.length || ty >= board[0].length) {
                        continue ;
                    }
                    if (board[tx][ty] == 'M') {
                        ++ tempNum;
                    }
                }
                if (tempNum == 0) {
                    board[x][y] = 'B';
                    for (int i1 = 0; i1 < 8; i1++) {
                        int tx = x + dirX[i1];
                        int ty = y + dirY[i1];
                        if (tx < 0 || ty < 0 || tx >= board.length || ty >= board[0].length || board[tx][ty] != 'E' || visit[tx][ty] == true) {
                            continue ;
                        }
                        deque.add(new int[]{tx, ty});
                        visit[tx][ty] = true;
                    }
                } else {
                    board[x][y] = (char) (tempNum + 48);
                }
            }
        }
        return board;
    }*/

    /**
     * 使用bfs来实现把，感觉相对简单,
     * 思路没问题，就是超时了，明天看题解，然后解决
     */
    /*public static char[][] updateBoard(char[][] board, int[] click) {
        if (board[click[0]][click[1]] == 'M') {
            board[click[0]][click[1]] = 'X';
            return board;
        }
        int xNum = board.length;
        int yNum = board[0].length;
        Deque<String> deque = new LinkedList<>();
        deque.add(click[0] + " " + click[1]);
        while (!deque.isEmpty()) {
            int length = deque.size();
            for (int i = 0; i < length; i++) {
                Deque<String> temp = new LinkedList<>();
                int tempNum = 0;
                String pop = deque.pop();
                String[] s = pop.split(" ");
                int x = Integer.parseInt(s[0]);
                int y = Integer.parseInt(s[1]);
                if (x - 1 >= 0) {
                    if (board[x - 1][y] == 'M') {
                        tempNum ++;
                    } else if (board[x - 1][y] == 'E') {
                        temp.add((x - 1) + " " + y);
                    }
                }
                if (x - 1 >= 0 && y - 1 >= 0) {
                    if (board[x - 1][y - 1] == 'M') {
                        tempNum ++;
                    } else if (board[x - 1][y - 1] == 'E') {
                        temp.add((x - 1) + " " + (y - 1));
                    }
                }
                if (x - 1 >= 0 && y + 1 < yNum) {
                    if (board[x - 1][y + 1] == 'M') {
                        tempNum++;
                    } else if (board[x - 1][y + 1] == 'E') {
                        temp.add((x - 1) + " " + (y + 1));
                    }
                }
                if (x + 1 < xNum) {
                    if (board[x + 1][y] == 'M') {
                        tempNum++;
                    } else if (board[x + 1][y] == 'E') {
                        temp.add((x + 1) + " " + y);
                    }
                }
                if (x + 1 < xNum && y - 1 >= 0) {
                    if (board[x + 1][y - 1] == 'M') {
                        tempNum++;
                    } else if (board[x + 1][y - 1] == 'E') {
                        temp.add((x + 1) + " " + (y - 1));
                    }
                }
                if (x + 1 < xNum && y + 1 < yNum) {
                    if (board[x + 1][y + 1] == 'M') {
                        tempNum++;
                    } else if (board[x + 1][y + 1] == 'E') {
                        temp.add((x + 1) + " " + (y + 1));
                    }
                }
                if (y + 1 < yNum) {
                    if (board[x][y + 1] == 'M') {
                        tempNum++;
                    } else if (board[x][y + 1] == 'E') {
                        temp.add(x + " " + (y + 1));
                    }
                }
                if (y - 1 >= 0) {
                    if (board[x][y - 1] == 'M') {
                        tempNum++;
                    } else if (board[x][y - 1] == 'E') {
                        temp.add(x + " " + (y - 1));
                    }
                }

                if (tempNum == 0) {
                    board[x][y] = 'B';
                    deque.addAll(temp);
                } else {
                    board[x][y] = (char) (tempNum + 48);
                }
            }
        }
        return board;
    }*/
    /**
     * 深度遍历和广度遍历，先使用深度遍历把
     */
    /*public char[][] updateBoard(char[][] board, int[] click) {
        if (board.length == 0) {
            return new char[0][0];
        }
        if (board[click[0]][click[1]] == 'M') {
            board[click[0]][click[1]] = 'X';
            return board;
        }
        char[][] result = new char[board.length][board[0].length];
        List<String> visited = new ArrayList<>();
        dfs(board, click, result);
        return result;
    }

    private boolean dfs(char[][] board, int[] click, char[][] result) {
        int x = click[0];
        int y = click[1];
        // 结束条件
        if (x < 0 || x > board.length || y < 0 || y > board[0].length) {
            return false;
        }
        if (board[click[0]][click[1]] == 'M') {
            return true;
        }
        // 当前层业务逻辑
        dfs(board, )
    }*/
}

