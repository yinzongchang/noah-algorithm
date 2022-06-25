package com.noah.demo.dfs;

/**
 * Title: CountSubIslands.java <br>
 * Description:             <br>
 * Copyright: Copyright (c) 2015<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author yinzo 2022/6/23
 */
public class CountSubIslands {

    boolean sub = true;

    public int countSubIslands(int[][] grid1, int[][] grid2) {

        // 行数
        int m = grid2.length;

        // 列数
        int n = grid2[0].length;

        int num = 0;

        for (int i = 0; i < m; i++) {

            for (int j = 0; j < n; j++) {

                if (grid2[i][j] == 1) {

                    dfs(grid1, grid2, i, j);

                    if (sub) {
                        num++;
                    } else {
                        sub = true;
                    }
                }

            }
        }
        return num;

    }


    public void dfs(int[][] grid1, int[][] grid2, int i, int j) {

        // 行数
        int m = grid2.length;

        // 列数
        int n = grid2[0].length;

        if (i < 0 || i >= m || j < 0 || j >= n || grid2[i][j] == 0) {

            return;
        }


        if (grid1[i][j] == 0) {
            sub = false;
        }

        grid2[i][j] = 0;

        dfs(grid1, grid2, i - 1, j);
        dfs(grid1, grid2, i + 1, j);
        dfs(grid1, grid2, i, j - 1);
        dfs(grid1, grid2, i, j + 1);

    }

}
