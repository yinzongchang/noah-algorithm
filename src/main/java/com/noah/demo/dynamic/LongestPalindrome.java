package com.noah.demo.dynamic;

/**
 * Title: LongestPalindrome.java <br>
 * Description:             <br>
 * Copyright: Copyright (c) 2015<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author yinzo 2022/7/12
 */
public class LongestPalindrome {

    public String longestPalindrome(String s) {

        int len = s.length();

        // 单个字符一定是回文串
        if (len < 2) {
            return s;
        }

        int maxLen = 1;
        int begin = 0;

        // dp[i][j] 表示 s[i,j] 是否为回文子串
        boolean[][] dp = new boolean[len][len];

        // 对角线填充
        for (int i = 0; i < len; i++) {

            dp[i][i] = true;
        }

        char[] charArray = s.toCharArray();

        for (int j = 1; j < len; j++) {

            for (int i = 0; i < j; i++) {

                if (charArray[i] != charArray[j]) {

                    dp[i][j] = false;
                } else {

                    // 字符串长度 1，2，3
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {

                        dp[i][j] = dp[i + 1][j - 1];

                    }
                }

                // dp[i][j] == true 成立，表示 s[i,j]是回文串，此时记录回文串和其实位置
                if (dp[i][j] && j - i + 1 > maxLen) {

                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }

        return s.substring(begin, begin + maxLen);
    }

}
