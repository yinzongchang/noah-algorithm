package com.noah.demo.dynamic;

/**
 * Title: maxSubArray.java <br>
 * Description:             <br>
 * Copyright: Copyright (c) 2015<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author yinzo 2022/7/8
 */
public class MaxSubArray {

    public int maxSubArray(int[] nums) {

        int len = nums.length;

        int[][] dp = new int[len][2];

        dp[0][0] = Integer.MIN_VALUE;
        dp[0][1] = nums[0];

        for (int i = 1; i < len; i++) {

            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
            dp[i][1] = Math.max(dp[i - 1][1] + nums[i], nums[i]);
        }

        return Math.max(dp[len - 1][0], dp[len - 1][1]);
    }


    public int maxSubArray2(int[] nums) {

        int len = nums.length;

        int[] dp = new int[len];

        dp[0] = nums[0];

        int ans = nums[0];

        for (int i = 1; i < len; i++) {

            if (dp[i - 1] > 0) {
                dp[i] = dp[i - 1] + nums[i];
            } else {
                dp[i] = nums[i];
            }

            ans = Math.max(ans, dp[i]);
        }

        return ans;
    }

}
