package com.noah.demo.string;

import java.util.Arrays;

/**
 * Title: CheckInclusion.java <br>
 * Description:             <br>
 * Copyright: Copyright (c) 2015<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author yinzo 2022/8/27
 */
public class CheckInclusion {

    /**
     * 字符串的排列
     *
     * 给你两个字符串 s1 和 s2 ，写一个函数来判断 s2 是否包含 s1 的排列。如果是，返回 true ；否则，返回 false 。
     * 换句话说，s1 的排列之一是 s2 的 子串 。
     *
     * 输入：s1 = "ab" s2 = "eidbaooo"
     * 输出：true
     * 解释：s2 包含 s1 的排列之一 ("ba").
     *
     * @param s1
     * @param s2
     * @return
     */
    public boolean checkInclusion(String s1, String s2) {

        if (s1 == null || s1.length() == 0) {
            return false;
        }

        if (s1.length() > s2.length()) {

            return false;
        }

        int s1Len = s1.length();

        for (int i = s1Len; i <= s2.length(); i++) {


            if (check(s2.substring(i - s1Len, i), s1)) {

                return true;
            }
        }
        
        return false;

    }

    public boolean check(String s1, String s2) {

        char[] charArray1 = s1.toCharArray();
        char[] charArray2 = s2.toCharArray();

        Arrays.sort(charArray1);
        Arrays.sort(charArray2);

        for (int i = 0; i < charArray1.length; i++) {

            if (charArray1[i] != charArray2[i]) {
                return false;
            }
        }

        return true;
    }

}
