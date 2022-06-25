package com.noah.demo.dynamic;

/**
 * Title: MinRefuelStops.java <br>
 * Description:             <br>
 * Copyright: Copyright (c) 2015<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author yinzo 2022/6/24
 */
public class MinRefuelStops {

    /**
     * dp[i][j]为经过了i个加油站、加了j次油能跑的最远距离(当然0<=j<=i)
     *
     * @param target
     * @param startFuel
     * @param stations
     * @return
     */
    public int minRefuelStops(int target, int startFuel, int[][] stations) {


        if (target <= startFuel) {
            return 0;
        }

        int n = stations.length;

        long[][] dp = new long[n + 1][n + 1];

        // 起始点当作第0个加油站
        for (int i = 0; i < n + 1; i++) {

            dp[i][0] = startFuel;
        }

        for (int i = 1; i <= n; i++) {

            // j <= i,加油的不会大于经过的
            for (int j = 1; j <= i; j++) {

                // i 站不加油
                if (dp[i - 1][j] >= stations[i - 1][0]) {

                    dp[i][j] = dp[i - 1][j];
                }

                // i 站要加油
                if (dp[i - 1][j - 1] >= stations[i - 1][0]) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 1] + stations[i - 1][0]);
                }
            }
        }

        for (int j = 0; j <= n; j++) {

            if (dp[n][j] >= target) {
                return j;
            }
        }

        return -1;
    }

}
