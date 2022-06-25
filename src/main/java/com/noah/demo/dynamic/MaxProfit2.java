package com.noah.demo.dynamic;

/**
 * Title: MaxProfit2.java <br>
 * Description:             <br>
 * Copyright: Copyright (c) 2015<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author yinzo 2022/6/19
 */
public class MaxProfit2 {

    /**
     * 给你一个整数数组 prices ，其中prices[i] 表示某支股票第 i 天的价格。
     *
     * 在每一天，你可以决定是否购买和/或出售股票。你在任何时候最多只能持有 一股 股票。你也可以先购买，然后在 同一天 出售。
     *
     * 返回 你能获得的 最大 利润。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-ii
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    public int maxProfit(int[] prices) {

        if (prices == null) {
            return 0;
        }

        int maxProfit = 0;

        for (int i = 1; i < prices.length; i++) {

            int profit = prices[i] - prices[i-1];
            if (profit > 0) {

                maxProfit += profit;
            }
        }

        return maxProfit;
    }

}
