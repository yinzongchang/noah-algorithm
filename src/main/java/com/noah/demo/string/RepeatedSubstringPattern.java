package com.noah.demo.string;

/**
 * Title: RepeatedSubstringPattern.java <br>
 * Description:             <br>
 * Copyright: Copyright (c) 2015<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author yinzo 2022/8/27
 */
public class RepeatedSubstringPattern {


    /**
     * 459. 重复的子字符串
     * <p>
     * 给定一个非空的字符串 s ，检查是否可以通过由它的一个子串重复多次构成。
     * 示例 1:
     * <p>
     * 输入: s = "abab"
     * 输出: true
     * 解释: 可由子串 "ab" 重复两次构成。
     * <p>
     * 示例 3:
     * <p>
     * 输入: s = "abcabcabcabc"
     * 输出: true
     * 解释: 可由子串 "abc" 重复四次构成。 (或子串 "abcabc" 重复两次构成。)
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/repeated-substring-pattern
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param s
     * @return
     */
    public boolean repeatedSubstringPattern(String s) {

        int len = s.length();

        for (int i = 1; i * 2 <= len; i++) {

            // 能够整除
            if (len % i == 0) {

                boolean match = true;

                for (int j = i; j < len; j++) {

                    if (s.charAt(j) != s.charAt(j - i)) {

                        match = false;
                        break;
                    }
                }

                if (match) {
                    return true;
                }
            }
        }

        return false;
    }

}
