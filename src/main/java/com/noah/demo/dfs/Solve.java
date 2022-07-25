package com.noah.demo.dfs;

/**
 * Title: Solve.java <br>
 * Description:             <br>
 * Copyright: Copyright (c) 2015<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author yinzo 2022/7/23
 */
public class Solve {

    public void solve(char[][] board) {

        int rows = board.length;

        int cols = board[0].length;

        for (int i = 0; i < rows; i++) {

            dfs(board, i, 0);
            dfs(board, i, cols - 1);
        }

        for (int j = 0; j < cols; j++) {

            dfs(board, 0, j);
            dfs(board, rows - 1, j);
        }

        for (int i = 0; i < rows; i++) {

            for (int j = 0; j < cols; j++) {

                if (board[i][j] == 'A') {
                    board[i][j] = 'O';
                } else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }

    public void dfs(char[][] board, int row, int col) {

        int rows = board.length;

        int cols = board[0].length;

        if (row < 0 || row >= rows || col < 0 || col >= cols
                || board[row][col] != 'O') {

            return;
        }

        board[row][col] = 'A';
        dfs(board, row - 1, col);
        dfs(board, row + 1, col);
        dfs(board, row, col - 1);
        dfs(board, row, col + 1);
    }

}
