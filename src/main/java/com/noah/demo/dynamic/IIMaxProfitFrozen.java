package com.noah.demo.dynamic;

/**
 * Title: IIMaxProfitFrozen.java <br>
 * Description:             <br>
 * Copyright: Copyright (c) 2015<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author yinzo 2022/7/9
 */
public class IIMaxProfitFrozen {


    /**
     * 309. 最佳买卖股票时机含冷冻期
     * <p>
     * 给定一个整数数组prices，其中第prices[i]表示第i天的股票价格
     * 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:
     * 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
     * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
     *
     * <p>
     * 输入: prices = [1,2,3,0,2]
     * 输出: 3
     * 解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出]
     * <p>
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-with-cooldown
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {

        if (prices == null || prices.length == 0) {
            return 0;
        }

        int len = prices.length;

        int[][] dp = new int[len][3];


        // 0. 持有股票的收益（只能发生在冷冻期之后）
        dp[0][0] = -prices[0];

        // 1. 不持有股票，并且处于冷冻期
        dp[0][1] = 0;

        // 2. 不持有股票，并且不处于冷冻期
        dp[0][2] = 0;

        for (int i = 1; i < len; i++) {

            // 前一天就持有股票，或者不持有股票，并且不处于冷冻期
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][2] + (-prices[i]));

            // 前一天是持有股票状态
            dp[i][1] = dp[i - 1][0] + prices[i];

            // 前一天是非持有股票状态，可以是冷冻期，也可能不是冷冻期
            dp[i][2] = Math.max(dp[i - 1][1], dp[i - 1][2]);
        }

        return Math.max(dp[len - 1][1], dp[len - 1][2]);
    }


    public int maxProfit2(int[] prices) {


        if (prices == null || prices.length == 0) {
            return 0;
        }

        int len = prices.length;


        // 0. 持有股票的收益（只能发生在冷冻期之后）
        int f0 = -prices[0];

        // 1. 不持有股票，并且处于冷冻期
        int f1 = 0;

        // 2. 不持有股票，并且不处于冷冻期
        int f2 = 0;

        for (int i = 1; i < len; i++) {

            // 前一天就持有股票，或者不持有股票，并且不处于冷冻期
            int f0New = Math.max(f0, f2 + (-prices[i]));

            // 前一天是持有股票状态
            int f1New = f0 + prices[i];

            // 前一天是非持有股票状态，可以是冷冻期，也可能不是冷冻期
            int f2New = Math.max(f1, f2);


            f0 = f0New;
            f1 = f1New;
            f2 = f2New;
        }

        return Math.max(f1, f2);

    }


    public int maxProfit3(int[] prices) {

        if (prices == null || prices.length == 0) {
            return 0;
        }

        int len = prices.length;

        int[][] dp = new int[len][2];

        dp[0][0] = 0;
        dp[0][1] = -prices[0];

        for (int i = 1; i < len; i++) {

            /**
             * 1. i天不持有股票
             *  1.1 i - 1 天不持有股票
             *  1.2 i - 1 天持有股票，i 天卖出
             */
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);


            /**
             * 2. i 天持有股票
             *  2.1 i - 1天持有股票
             *  2.2 i - 2天不持有股票，i 天买入
             */
            if (i < 2) {
                dp[i][1] = Math.max(dp[i - 1][1], dp[0][0] + (-prices[i]));
            } else {
                dp[i][1] = Math.max(dp[i - 1][1], dp[i - 2][0] + (-prices[i]));
            }

        }

        return dp[len - 1][0];
    }

}
