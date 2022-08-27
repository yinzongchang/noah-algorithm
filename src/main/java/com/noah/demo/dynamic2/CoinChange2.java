package com.noah.demo.dynamic2;

/**
 * Title: CoinChange2.java <br>
 * Description:             <br>
 * Copyright: Copyright (c) 2015<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author yinzo 2022/8/24
 */
public class CoinChange2 {

    /**
     * 518. 零钱兑换 II
     * <p>
     * 给你一个整数数组 coins 表示不同面额的硬币，另给一个整数 amount 表示总金额。
     * 请你计算并返回可以凑成总金额的硬币组合数。如果任何硬币组合都无法凑出总金额，返回 0 。
     * 假设每一种面额的硬币有无限个。
     * 题目数据保证结果符合 32 位带符号整数。
     * <p>
     * 示例 1：
     * <p>
     * 输入：amount = 5, coins = [1, 2, 5]
     * 输出：4
     * 解释：有四种方式可以凑成总金额：
     * 5=5
     * 5=2+2+1
     * 5=2+1+1+1
     * 5=1+1+1+1+1
     * <p>
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/coin-change-2
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param amount
     * @param coins
     * @return
     */
    public int change(int amount, int[] coins) {


        // dp[i] 表示 凑齐金额 i 的 组合数
        int[] dp = new int[amount + 1];

        // 凑齐金额为0 的组合数为 1，就是一个硬币都没有
        dp[0] = 1;

        for (int i = 0; i < coins.length; i++) {

            for (int j = coins[i]; j <= amount; j++) {

                dp[j] = dp[j] + dp[j - coins[i]];

            }
        }


        return dp[amount];
    }

}
