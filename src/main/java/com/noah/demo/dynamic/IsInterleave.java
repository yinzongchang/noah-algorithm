package com.noah.demo.dynamic;

import org.junit.Test;

/**
 * Title: IsInterleave.java <br>
 * Description:             <br>
 * Copyright: Copyright (c) 2015<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author yinzo 2022/7/20
 */
public class IsInterleave {

    public boolean isInterleave(String s1, String s2, String s3) {

        if (s1.length() + s2.length() + s3.length() == 0) {
            return true;
        }

        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }

        int rows = s1.length();
        int cols = s2.length();

        boolean[][] dp = new boolean[rows + 1][cols + 1];
        dp[0][0] = true;

        for (int i = 1; i <= rows; i++) {

            dp[i][0] = (s1.charAt(i - 1) == s3.charAt(i - 1)) && dp[i - 1][0] ;
        }

        for (int j = 1; j <= cols; j++) {

            dp[0][j] = (s2.charAt(j - 1) == s3.charAt(j - 1)) && dp[0][j - 1];
        }

        for (int i = 1; i <= rows; i++) {

            for (int j = 1; j <= cols; j++) {

                dp[i][j] = (dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1)) // 向下走
                        || (dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1));// 向右走
            }

        }

        return dp[rows][cols];

    }


    @Test
    public void test() {


        String s1 = "db";
        String s2 = "b";
        String s3 = "cbb";

        System.out.println(new IsInterleave().isInterleave(s1, s2, s3));

    }
}
