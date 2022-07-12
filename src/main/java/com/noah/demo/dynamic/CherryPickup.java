package com.noah.demo.dynamic;

import org.junit.Test;

/**
 * Title: CherryPickup.java <br>
 * Description:             <br>
 * Copyright: Copyright (c) 2015<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author yinzo 2022/7/10
 */
public class CherryPickup {

    public int cherryPickup(int[][] grid) {

        int rows = grid.length;
        int cols = grid[0].length;

        /**
         * 樱桃最大数
         */
        int[][] dp = new int[rows][cols];
        dp[0][0] = grid[0][0];


        boolean r = true;
        for (int i = 1; i < rows; i++) {

            if (grid[i][0] == -1) {
                r = false;
            }

            if (r) {
                dp[i][0] = dp[i - 1][0] + grid[i][0];
            } else {
                dp[i][0] = Integer.MIN_VALUE;
            }
        }

        boolean c = true;
        for (int j = 1; j < cols; j++) {

            if (grid[0][j] == -1) {
                c = false;
            }

            if (c) {
                dp[0][j] = dp[0][j] + grid[0][j];
            } else {
                dp[0][j] = Integer.MIN_VALUE;
            }
        }


        for (int i = 1; i < rows; i++) {

            for (int j = 1; j < cols; j++) {

                // 路径上不可达
                if (dp[i - 1][j] == Integer.MIN_VALUE && dp[i][j - 1] == Integer.MIN_VALUE) {

                    dp[i][j] = Integer.MIN_VALUE;
                    continue;
                }

                // 本身不可达
                if (grid[i][j] == -1) {
                    dp[i][j] = Integer.MIN_VALUE;
                    continue;
                }

                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }

        return dp[rows - 1][cols - 1] == Integer.MIN_VALUE ? 0 : dp[rows - 1][cols - 1];
    }

    public int cherryPickup2(int[][] grid) {

        int rows = grid.length;
        int cols = grid[0].length;

        /**
         * 樱桃最大数
         */
        int[][] dp = new int[rows][cols];
        dp[0][0] = grid[0][0];


        boolean r = true;
        for (int i = 1; i < rows; i++) {

            if (grid[i][0] == -1) {
                r = false;
            }

            if (r) {
                dp[i][0] = grid[i][0];
            } else {
                dp[i][0] = Integer.MIN_VALUE;
            }
        }

        boolean c = true;
        for (int j = 1; j < cols; j++) {

            if (grid[0][j] == -1) {
                c = false;
            }

            if (c) {
                dp[0][j] = grid[0][j];
            } else {
                dp[0][j] = Integer.MIN_VALUE;
            }
        }


        for (int i = 1; i < rows; i++) {

            for (int j = 1; j < cols; j++) {

                // 路径上不可达
                if (dp[i - 1][j] == Integer.MIN_VALUE && dp[i][j - 1] == Integer.MIN_VALUE) {

                    dp[i][j] = Integer.MIN_VALUE;
                    continue;
                }

                // 本身不可达
                if (grid[i][j] == -1) {
                    dp[i][j] = Integer.MIN_VALUE;
                    continue;
                }

                dp[i][j] = grid[i][j];
            }
        }

        if (dp[rows - 1][cols - 1] == Integer.MIN_VALUE) {

            return 0;
        }

        int ans = 0;

        for (int i = 0; i < rows; i++) {

            for (int j = 0; j < cols; j++) {

                if (dp[i][j] == 1) {
                    ans += 1;
                }
            }
        }

        return ans;
    }


    @Test
    public void test() {

        int[][] grid = {{0, 1, -1}, {1, 0, -1}, {1, 1, 1}};

        System.out.println(new CherryPickup().cherryPickup2(grid));


    }

}
