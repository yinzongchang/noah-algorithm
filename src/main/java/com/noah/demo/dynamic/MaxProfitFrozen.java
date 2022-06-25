package com.noah.demo.dynamic;

/**
 * Title: MaxProfitFrozen.java <br>
 * Description:             <br>
 * Copyright: Copyright (c) 2015<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author yinzo 2022/6/22
 */
public class MaxProfitFrozen {


    public int maxProfit(int[] prices) {

        if (prices == null || prices.length == 0) {
            return 0;
        }

        // 数组长度
        int n = prices.length;

        int[][] f = new int[n][3];

        // 1. 持有一直股票的收益
        f[0][0] = -prices[0];

        // 不持有股票，并且冷冻（前一天买入并且卖出了） -- 不会有这个情况
        f[0][1] = 0;

        // // 3. 相当于没买入，收益自然为0
        f[0][2] = 0;

        for (int i = 1; i < n; i++) {

            f[i][0] = Math.max(f[i - 1][0], f[i - 1][2] - prices[i]);
            f[i][1] = f[i - 1][0] + prices[i];
            f[i][2] = Math.max(f[i - 1][1], f[i - 1][2]);

        }

        return Math.max(f[n - 1][1], f[n - 1][2]);
    }


    public int maxProfit2(int[] prices) {

        if (prices == null || prices.length == 0) {
            return 0;
        }

        // 数组长度
        int n = prices.length;

        // 1. 持有一直股票的收益
        int f0 = -prices[0];

        // 2. 不持有股票，并且冷冻（前一天买入并且卖出了） -- 不会有这个情况
        int f1 = 0;

        // 3. 相当于没买入，收益自然为0
        int f2 = 0;

        for (int i = 1; i < n; i++) {

            int newF0 = Math.max(f1, f2 - prices[i]);
            int newF1 = f0 + prices[i];
            int newF2 = Math.max(f1, f2);

            f0 = newF0;
            f1 = newF1;
            f2 = newF2;
        }

        return Math.max(f1, f2);
    }


}
