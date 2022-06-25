package com.noah.demo.dfs;

/**
 * Title: NumIslands.java <br>
 * Description:             <br>
 * Copyright: Copyright (c) 2015<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author yinzo 2022/6/23
 */
public class NumIslands {


    public int numIslands(char[][] grid) {

        // 行数
        int m = grid.length;

        // 列数
        int n = grid[0].length;

        int num = 0;

        for (int i = 0; i < m; i++) {

            for (int j = 0; j < n; j++) {

                if (grid[i][j] == '1') {
                    num++;
                    dfs(grid, i, j);
                }

            }
        }
        return num;
    }


    public void dfs(char[][] grid, int i, int j) {

        // 行数
        int m = grid.length;

        // 列数
        int n = grid[0].length;

        if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == '0') {

            return;
        }

        grid[i][j] = '0';
        dfs(grid, i - 1, j);
        dfs(grid, i + 1, j);
        dfs(grid, i, j - 1);
        dfs(grid, i, j + 1);
    }


}
