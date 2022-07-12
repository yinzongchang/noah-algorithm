package com.noah.demo.dynamic;

/**
 * Title: MinDistance.java <br>
 * Description:             <br>
 * Copyright: Copyright (c) 2015<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author yinzo 2022/7/4
 */
public class MinDistance {


    public int minDistance(String word1, String word2) {

        // 行数
        int row = word1.length();

        // 列数
        int col = word2.length();

        if (row * col == 0) {
            return row + col;
        }

        int[][] dp = new int[row + 1][col + 1];

        // 初始化
        for (int i = 0; i <= row; i++) {

            dp[i][0] = i;
        }

        for (int j = 0; j <= col; j++) {

            dp[0][j] = j;
        }

        for (int i = 1; i <= row; i++) {

            for (int j = 1; j <= col; j++) {

                int top = dp[i - 1][j] + 1;
                int left = dp[i][j - 1] + 1;

                int leftTop = dp[i - 1][j - 1];

                if (word1.charAt(i - 1) != word2.charAt(j - 1)) {
                    leftTop = leftTop + 1;
                }

                dp[i][j] = Math.min(Math.min(top, left), leftTop);

            }
        }

        return dp[row][col];

    }

}
