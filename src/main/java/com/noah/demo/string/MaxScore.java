package com.noah.demo.string;

/**
 * Title: MaxScore.java <br>
 * Description:             <br>
 * Copyright: Copyright (c) 2015<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author yinzo 2022/8/14
 */
public class MaxScore {


    /**
     * 1422. 分割字符串的最大得分
     *
     * 给你一个由若干 0 和 1 组成的字符串 s ，请你计算并返回将该字符串分割成两个 非空 子字符串（即 左 子字符串和 右 子字符串）所能获得的最大得分。
     *
     * 「分割字符串的得分」为 左 子字符串中 0 的数量加上 右 子字符串中 1 的数量。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/maximum-score-after-splitting-a-string
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     *
     * 示例 1：
     *
     * 输入：s = "011101"
     * 输出：5
     * 解释：
     * 将字符串 s 划分为两个非空子字符串的可行方案有：
     * 左子字符串 = "0" 且 右子字符串 = "11101"，得分 = 1 + 4 = 5
     * 左子字符串 = "01" 且 右子字符串 = "1101"，得分 = 1 + 3 = 4
     * 左子字符串 = "011" 且 右子字符串 = "101"，得分 = 1 + 2 = 3
     * 左子字符串 = "0111" 且 右子字符串 = "01"，得分 = 1 + 1 = 2
     * 左子字符串 = "01110" 且 右子字符串 = "1"，得分 = 2 + 1 = 3
     *
     * @param s
     * @return
     */
    public int maxScore(String s) {

        // 初始化分数
        int score = 0;

        int len = s.length();

        if (s.charAt(0) == '0') {
            score++;
        }

        for (int i = 1; i < len; i++) {

            if (s.charAt(i) == '1') {
                score++;
            }
        }

        // 此时，分数 = 从第一位分割计算的分数
        int maxScore = score;


        // 循环知道最后一位为右子串
        for (int i = 1; i < len - 1; i++) {

            if (s.charAt(i) == '1') {
                score--;
            } else {
                score++;
            }

            maxScore = Math.max(maxScore, score);
        }

        return maxScore;
    }

}
