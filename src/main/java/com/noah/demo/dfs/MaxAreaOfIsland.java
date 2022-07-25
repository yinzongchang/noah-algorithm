package com.noah.demo.dfs;

/**
 * Title: MaxAreaOfIsland.java <br>
 * Description:             <br>
 * Copyright: Copyright (c) 2015<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author yinzo 2022/7/20
 */
public class MaxAreaOfIsland {

    int area = 0;

    int ans = 0;

    public int maxAreaOfIsland(int[][] grid) {

        int rows = grid.length;
        int cols = grid[0].length;

        for (int i = 0; i < rows; i++) {

            for (int j = 0; j < cols; j++) {

                dfs(grid, i, j);

                ans = Math.max(ans, area);
                area = 0;

            }
        }

        return ans;
    }

    public void dfs(int[][] grid, int row, int col) {


        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length
                || grid[row][col] == 0) {

            return;
        }

        if (grid[row][col] == 1) {

            area++;

            grid[row][col] = 0;
        }

        dfs(grid, row - 1, col);
        dfs(grid, row + 1, col);
        dfs(grid, row, col - 1);
        dfs(grid, row, col + 1);
    }

}
