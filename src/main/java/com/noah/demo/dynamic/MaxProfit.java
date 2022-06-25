package com.noah.demo.dynamic;

/**
 * Title: MaxProfit.java <br>
 * Description:             <br>
 * Copyright: Copyright (c) 2015<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author yinzo 2022/6/19
 */
public class MaxProfit {

    /**
     * 买卖股票，记录当前最小值，后续计算差指
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {

        if (prices == null) {
            return 0;
        }

        // 最低价格
        int minPrice = Integer.MAX_VALUE;

        int maxProfit = 0;

        for (int i = 0; i < prices.length; i++) {

            int price = prices[i];

            // 更新最小价格
            if (price < minPrice) {
                minPrice = price;
                continue;
            }

            int profit = price - minPrice;
            if (profit > maxProfit) {
                maxProfit = profit;
            }
        }


        return maxProfit;
    }

}
