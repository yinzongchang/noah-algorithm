package com.noah.demo.suanfa;

import org.junit.Test;

/**
 * Title: Anagram.java <br>
 * Description:             <br>
 * Copyright: Copyright (c) 2015<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author yinzo 2021/11/7
 */
public class Anagram {


    /**
     * 标签：哈希映射
     * 首先判断两个字符串长度是否相等，不相等则直接返回 false
     * 若相等，则初始化 26 个字母哈希表，遍历字符串 s 和 t
     * s 负责在对应位置增加，t 负责在对应位置减少
     * 如果哈希表的值都为 0，则二者是字母异位词
     *
     * 作者：guanpengchn
     * 链接：https://leetcode-cn.com/problems/valid-anagram/solution/hua-jie-suan-fa-242-you-xiao-de-zi-mu-yi-wei-ci-by/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    @Test
    public void test() {


        System.out.println('b' - 'a');
    }

    public boolean isAnagram(String s, String t) {

        if (s == null || t == null) {
            return false;
        }

        if (s.length() != t.length()) {
            return false;
        }


        // 初始化26个字母数组
        int[] alpha = new int[26];

        int length = s.length();
        for (int i = 0; i < length; i++) {

            int sIndex = s.charAt(i) - 'a';
            alpha[sIndex] = alpha[sIndex] + 1;

            int tIndex = t.charAt(i) - 'a';
            alpha[tIndex] = alpha[tIndex] - 1;

        }

        for (int i : alpha) {

            if (i != 0) {
                return false;
            }
        }

        return true;
    }

}
