package com.noah.demo.dynamic;

/**
 * Title: IIMaxProfit.java <br>
 * Description:             <br>
 * Copyright: Copyright (c) 2015<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author yinzo 2022/7/8
 */
public class IIMaxProfit {

    /**
     * 剑指 Offer 63. 股票的最大利润
     * 假设把某股票的价格按照时间先后顺序存储在数组中，请问买卖该股票一次可能获得的最大利润是多少？
     *
     * 输入: [7,1,5,3,6,4]
     * 输出: 5
     * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
     * 注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。
     * <p>
     * 链接：https://leetcode.cn/leetbook/read/illustration-of-algorithm/58nn7r/
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {

        int maxProfit = 0;

        if (prices == null || prices.length == 0) {
            return 0;
        }

        // i天之前的最小成本
        int minCost = prices[0];

        for (int i = 1; i < prices.length; i++) {

            maxProfit = Math.max(maxProfit, prices[i] - minCost);
            minCost = Math.min(minCost, prices[i]);
        }

        return maxProfit;
    }

    public int maxProfit2(int[] prices) {

        int len = prices.length;

        // 特殊判断
        if (len < 2) {
            return 0;
        }
        int[][] dp = new int[len][2];

        // dp[i][0] 下标为 i 这天结束的时候，不持股，手上拥有的收益
        // dp[i][1] 下标为 i 这天结束的时候，持股，手上拥有的最大收益

        // 初始化
        dp[0][0] = 0; // 第一天结束后不持股，手上的股票收益
        dp[0][1] = -prices[0]; // 第一天结束后持有股票

        for (int i  = 1; i < len; i++) {

            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
        }

        return dp[len - 1][0];
    }

}
