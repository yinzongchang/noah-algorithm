package com.noah.demo.dynamic2;

import java.util.Arrays;

/**
 * Title: CoinChange.java <br>
 * Description:             <br>
 * Copyright: Copyright (c) 2015<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author yinzo 2022/8/23
 */
public class CoinChange {


    /**
     * 剑指 Offer II 103. 最少的硬币数目
     * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。
     * 如果没有任何一种硬币组合能组成总金额，返回 -1。
     * <p>
     * 你可以认为每种硬币的数量是无限的。
     * <p>
     * 示例 1：
     * <p>
     * 输入：coins = [1, 2, 5], amount = 11
     * 输出：3
     * 解释：11 = 5 + 5 + 1
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/gaM7Ch
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public int coinChange(int[] coins, int amount) {


        // 凑成金额 x 所需的硬币数量
        int[] dp = new int[amount + 1];

        Arrays.fill(dp, amount + 1);

        // 凑成金额为0的需要的硬币数量为0
        dp[0] = 0;


        /**
         * dp[i] = x 凑成金额 i 所需要的硬币数量
         * 如果 当前金额 大于 硬币面值 dp[i] = min(dp[i], dp[i - coin] + 1)
         */
        for (int i = 1; i <= amount; i++) {

            for (int j = 0; j < coins.length; j++) {

                if (i >= coins[j]) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }

        return dp[amount] > amount ? -1 : dp[amount];
    }


}
