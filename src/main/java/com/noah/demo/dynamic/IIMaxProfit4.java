package com.noah.demo.dynamic;

/**
 * Title: IIMaxProfit4.java <br>
 * Description:             <br>
 * Copyright: Copyright (c) 2015<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author yinzo 2022/7/9
 */
public class IIMaxProfit4 {


    /**
     * 给定一个整数数组prices ，它的第 i 个元素prices[i] 是一支给定的股票在第 i 天的价格。
     * <p>
     * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 k 笔交易。
     * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
     * <p>
     * 输入：k = 2, prices = [2,4,1]
     * 输出：2
     * 解释：在第 1 天 (股票价格 = 2) 的时候买入，在第 2 天 (股票价格 = 4) 的时候卖出，这笔交易所能获得利润 = 4-2 = 2 。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-iv
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param k
     * @param prices
     * @return
     */
    public int maxProfit(int k, int[] prices) {

        /**
         * dp[i][k][0] 第i天 交易了k次，手中没有股票
         * dp[i][k][1] 第i天 交易了k次，手中有股票
         *
         * 1. 不持有股票收益（dp[i][k][0]）
         *  1.1 dp[i - 1][k][0] 昨天不持有，今天不操作
         *  1.2 dp[i - 1][k][1] + prices[i] 昨天持有，今天卖出
         *
         *
         * 2. 持有股票收益（dp[i][k][1]）
         *  2.1 dp[i - 1][k][1] 昨天持有，今天不操作
         *  2.2 dp[i - 1][k - 1][0] - prices[i] 昨天不持有，今天买入
         *
         * dp[i][k][0] = max(dp[i - 1][k][0], dp[i - 1][k][1] + prices[i])
         * dp[i][k][1] = max(dp[i - 1][k][1], dp[i - 1][k - 1][0] - prices[i])
         *
         */

        int len = prices.length;

        int[][][] dp = new int[len][k + 1][2];

        // 第一天无论交易多少次
        for (int j = 0; j < k; j++) {

            dp[0][j][0] = 0;
            dp[0][j][1] = -prices[0];
        }

        for (int i = 1; i < len; i++) {

            // 第一次交易
            // 不持有股票，
            dp[i][0][0] = dp[i - 1][0][0];

            // 持有股票
            dp[i][0][1] = Math.max(dp[i - 1][0][1], dp[i - 1][0][0] + (-prices[i]));
        }


        for (int i = 1; i < len; i++) {

            for (int j = 0; j <= k; j++) {

                if (j == 0) {
                    // 前一天交易0次，不持有，今天不动
                    dp[i][j][0] = dp[i - 1][j][0];

                    // 前一天交易0次，不持有，今天买入  前一天交易0次，持有，今天不动
                    dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j][0] - prices[i]);
                } else {
                    // 前一天交易j次，不持有，今天不动   前一天交易j-1次，持有一笔，今天卖出
                    dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j - 1][1] + prices[i]);
                    // 前一天交易j次，持有一笔，今天不动  前一天交易j次，不持有，今天买入
                    dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j][0] - prices[i]);
                }

            }

        }

        int maxProfit = 0;
        for (int j = 0; j <= k; j++) {

            maxProfit = Math.max(maxProfit, dp[len - 1][j][0]);
        }

        return maxProfit;
    }

}
