package com.noah.demo.dynamic;

import java.util.HashMap;
import java.util.Map;

/**
 * Title: LenLongestFibSubseq.java <br>
 * Description:             <br>
 * Copyright: Copyright (c) 2015<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author yinzo 2022/7/9
 */
public class LenLongestFibSubseq {

    /**
     * dp[i][j] = dp[k][i] + 1, if arr[k] + arr[i] = arr[j]
     * https://leetcode.cn/problems/length-of-longest-fibonacci-subsequence/solution/by-meteordream-iojy/
     *
     * @param arr
     * @return
     */
    public int lenLongestFibSubseq(int[] arr) {

        int n = arr.length;
        int ans = 0;

        if (n < 3) {
            return 0;
        }

        // dp[i][j] 表示以 最后两个值是 arr[i], arr[j] 的最长严格递增斐波那契子序列
        int[][] dp = new int[n][n];

        // dp[i][j] = dp[k][i] + 1, if arr[k] + arr[i] = arr[j]
        for (int i = 0; i < n; ++i) {

            for (int j = i; j < n; ++j) {

                for (int k = 0; k < i && arr[i] + arr[k] <= arr[j]; ++k) {

                    if (arr[k] + arr[i] == arr[j]) {

                        dp[i][j] = Math.max(3, Math.max(dp[k][i] + 1, dp[i][j]));
                    }
                }

                ans = Math.max(ans, dp[i][j]);
            }
        }
        return ans;
    }

    public int lenLongestFibSubseq2(int[] arr) {

        int n = arr.length;
        int ans = 0;

        Map<Integer, Integer> st = new HashMap<>();

        for (int i = 0; i < n; ++i) {

            st.put(arr[i], i);
        }

        if (n < 3) {

            return 0;
        }

        // dp[i][j] 表示以 最后两个值是 arr[i], arr[j] 的最长严格递增斐波那契子序列
        int[][] dp = new int[n][n];

        // dp[i][j] = dp[k][i] + 1, if arr[k] + arr[i] = arr[j]
        for (int i = 0; i < n; ++i) {

            for (int j = i; j < n; ++j) {

                int target = arr[j] - arr[i];

                // 排除 arr[i] + arr[i] = arr[j] 的情况
                if (target >= arr[i]) {
                    continue;
                }

                if (st.containsKey(target)) {
                    int k = st.get(target);
                    dp[i][j] = Math.max(3, dp[k][i] + 1);
                    ans = Math.max(ans, dp[i][j]);
                }
            }
        }
        return ans;
    }

}
