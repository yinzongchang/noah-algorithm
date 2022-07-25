package com.noah.demo.dynamic;

/**
 * Title: MinPathSum.java <br>
 * Description:             <br>
 * Copyright: Copyright (c) 2015<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author yinzo 2022/7/13
 */
public class MinPathSum {

    public int minPathSum(int[][] grid) {

        int rows = grid.length;

        int cols = grid[0].length;

        // 结果集
        int[][] dp = new int[rows][cols];

        dp[0][0] = grid[0][0];

        for (int i = 1; i < rows; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }

        for (int j = 1; j < cols; j++) {
            dp[0][j] = dp[0][j] + grid[0][j];
        }


        for (int i = 1; i < rows; i++) {


            for (int j = 1; j < cols; j++) {

                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }

        return dp[rows - 1][cols - 1];
    }

}
