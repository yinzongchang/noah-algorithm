package com.noah.demo.dynamic;

/**
 * Title: CoinChange2.java <br>
 * Description:             <br>
 * Copyright: Copyright (c) 2015<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author yinzo 2022/7/18
 */
public class CoinChange2 {


    /**
     * 518. 零钱兑换 II
     * <p>
     * 给你一个整数数组 coins 表示不同面额的硬币，另给一个整数 amount 表示总金额。
     * <p>
     * 请你计算并返回可以凑成总金额的硬币组合数。如果任何硬币组合都无法凑出总金额，返回 0 。
     * <p>
     * 假设每一种面额的硬币有无限个。
     * <p>
     * 题目数据保证结果符合 32 位带符号整数。
     * <p>
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
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/coin-change-2
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public int change(int amount, int[] coins) {


        // dp[i] = x 表示 凑成金额 i 的组合数为 x
        int[] dp = new int[amount + 1];

        // 不选取任何硬币时，金额之和才为 0，因此只有 1 种硬币组合。
        dp[0] = 1;

        for (int i = 0; i < coins.length; i++) {


            for (int j = coins[i]; j <= amount; j++) {

                // 使用不同硬币得到的组合数量要相加
                dp[j] = dp[j] + dp[j - coins[i]];

            }
        }

        return dp[amount];
    }

}
