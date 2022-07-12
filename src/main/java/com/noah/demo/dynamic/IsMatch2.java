package com.noah.demo.dynamic;

/**
 * Title: IsMatch2.java <br>
 * Description:             <br>
 * Copyright: Copyright (c) 2015<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author yinzo 2022/7/8
 */
public class IsMatch2 {


    /**
     * 请实现一个函数用来匹配包含'. '和'*'的正则表达式。模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（含0次）。
     * 在本题中，匹配是指字符串的所有字符匹配整个模式。例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但与"aa.a"和"ab*a"均不匹配。
     * <p>
     * https://leetcode.cn/leetbook/read/illustration-of-algorithm/9aysri/
     *
     * @param s
     * @param p
     * @return
     */
    public boolean isMatch(String s, String p) {
        int m = s.length() + 1, n = p.length() + 1;
        boolean[][] dp = new boolean[m][n];
        dp[0][0] = true;
        // 初始化首行
        for (int j = 2; j < n; j += 2) {
            dp[0][j] = dp[0][j - 2] && p.charAt(j - 1) == '*';
        }

        // 状态转移
        for (int i = 1; i < m; i++) {

            for (int j = 1; j < n; j++) {

                if (p.charAt(j - 1) == '*') {

                    if (dp[i][j - 2]) {
                        dp[i][j] = true;                                            // 1.
                    } else if (dp[i - 1][j] && s.charAt(i - 1) == p.charAt(j - 2)) {
                        dp[i][j] = true; // 2.
                    } else if (dp[i - 1][j] && p.charAt(j - 2) == '.') {
                        dp[i][j] = true;             // 3.
                    }
                } else {
                    if (dp[i - 1][j - 1] && s.charAt(i - 1) == p.charAt(j - 1)) {
                        dp[i][j] = true;  // 1.
                    } else if (dp[i - 1][j - 1] && p.charAt(j - 1) == '.') {
                        dp[i][j] = true;         // 2.
                    }
                }
            }
        }
        return dp[m - 1][n - 1];
    }

}
