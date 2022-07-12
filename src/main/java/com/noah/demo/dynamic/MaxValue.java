package com.noah.demo.dynamic;

/**
 * Title: MaxValue.java <br>
 * Description:             <br>
 * Copyright: Copyright (c) 2015<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author yinzo 2022/7/8
 */
public class MaxValue {

    /**
     * 输入:
     * [
     * [1,3,1],
     * [1,5,1],
     * [4,2,1]
     * ]
     * 输出: 12
     * 解释: 路径 1→3→5→2→1 可以拿到最多价值的礼物
     *
     * @param grid
     * @return
     */
    public int maxValue(int[][] grid) {

        int rows = grid.length;

        int cols = grid[0].length;

        // 结果二维数组
        int[][] dp = new int[rows][cols];

        dp[0][0] = grid[0][0];

        for (int i = 1; i < rows; i++) {

            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }

        for (int j = 1; j < cols; j++) {

            dp[0][j] = dp[0][j - 1] + grid[0][j];
        }

        for (int i = 1; i < rows; i++) {

            for (int j = 1; j < cols; j++) {

                int temp = Math.max(dp[i - 1][j] + grid[i][j], dp[i][j - 1] + grid[i][j]);
                dp[i][j] = Math.max(dp[i][j], temp);
            }
        }

        return dp[rows - 1][cols - 1];
    }

}
