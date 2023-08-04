package com.noah.nowcoder.string;

import org.junit.Test;

/**
 * Solve.java
 *
 * @author yinzongchang
 * 创建时间 2023/5/24
 * @since 1.0
 */
public class Solve {

    /**
     * BM86 大数加法
     *
     * <a href="https://www.nowcoder.com/practice/11ae12e8c6fe48f883cad618c2e81475?tpId=295&tqId=1061819&ru=/exam/company&qru=/ta/format-top101/question-ranking&sourceUrl=%2Fexam%2Fcompany"></a>
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * 计算两个数之和
     *
     * @param s string字符串 表示第一个整数
     * @param t string字符串 表示第二个整数
     * @return string字符串
     */
    public String solve(String s, String t) {

        if (s == null || s.length() == 0) {
            return t;
        }

        if (t == null || t.length() == 0) {
            return s;
        }

        StringBuilder res = new StringBuilder();

        int x = 0;

        int i = 0;
        for (; i < s.length() || i < t.length(); i++) {

            int a = 0;
            if (i <= s.length() - 1) {
                a = s.charAt(s.length() - i - 1) - '0';
            }

            int b = 0;
            if (i <= t.length() - 1) {
                b = t.charAt(t.length() - i - 1) - '0';
            }

            res.insert(0, (a + b + x) % 10);
            x = (a + b + x) / 10;
        }

        if (x == 1) {
            res.insert(0, 1);
        }

        return res.toString();
    }

    @Test
    public void test() {

        System.out.println(new Solve().solve("99", "1"));
    }
}
