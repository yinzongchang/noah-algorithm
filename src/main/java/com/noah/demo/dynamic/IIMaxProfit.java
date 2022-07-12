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

}
