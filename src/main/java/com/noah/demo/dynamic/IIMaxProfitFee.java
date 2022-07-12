package com.noah.demo.dynamic;

/**
 * Title: IIMaxProfitFee.java <br>
 * Description:             <br>
 * Copyright: Copyright (c) 2015<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author yinzo 2022/7/9
 */
public class IIMaxProfitFee {


    // 714. 买卖股票的最佳时机含手续费

    /**
     * 给定一个整数数组 prices，其中 prices[i]表示第 i 天的股票价格 ；整数 fee 代表了交易股票的手续费用。
     * 你可以无限次地完成交易，但是你每笔交易都需要付手续费。如果你已经购买了一个股票，在卖出它之前你就不能再继续购买股票了。
     * 返回获得利润的最大值。
     * 注意：这里的一笔交易指买入持有并卖出股票的整个过程，每笔交易你只需要为支付一次手续费。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-with-transaction-fee
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param prices
     * @param fee
     * @return
     */
    public int maxProfit(int[] prices, int fee) {

        if (prices == null || prices.length == 0) {
            return 0;
        }

        int len = prices.length;

        // 收益
        int[][] dp = new int[len][2];

        // 不持有股票利润
        dp[0][0] = 0;

        // 持有股票
        dp[0][1] = -prices[0];

        for (int i = 1; i < len; i++) {

            /**
             * 1. i天不持有股票利润
             *  1.1 i - 1 不持有股票
             *  1.2 i - 1 持有股票，i天卖出
             */
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i] - fee);


            /**
             * 2. i天持有股票利润
             *  2.1 i - 1 持有股票
             *  2.2 i - 1 不持有股票，i天买入
             */
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);

        }

        return dp[len - 1][0];
    }

}
