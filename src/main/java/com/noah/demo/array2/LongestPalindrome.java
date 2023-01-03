package com.noah.demo.array2;

import com.noah.demo.search.HalfSearch;

import java.util.HashMap;
import java.util.Map;

/**
 * Title: LongestPalindrome.java <br>
 * Description:             <br>
 * Copyright: Copyright (c) 2015<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author yinzo 2022/9/19
 */
public class LongestPalindrome {

    /**
     * 给定一个包含大写字母和小写字母的字符串 s ，返回 通过这些字母构造成的 最长的回文串 。
     * <p>
     * 在构造过程中，请注意 区分大小写 。比如 "Aa" 不能当做一个回文字符串。
     * <p>
     * <p>
     * 示例 1:
     * <p>
     * 输入:s = "abccccdd"
     * 输出:7
     * 解释:
     * 我们可以构造的最长的回文串是"dccaccd", 它的长度是 7。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/longest-palindrome
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param s
     * @return
     */
    public int longestPalindrome(String s) {

        if (s == null || s.length() == 0) {
            return 0;
        }

        Map<Character, Integer> characterMap = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {

            char c = s.charAt(i);
            characterMap.put(c, characterMap.getOrDefault(c, 0) + 1);
        }

        int a = 0;
        int b = 0;

        for (Map.Entry<Character, Integer> entry : characterMap.entrySet()) {

            int num = entry.getValue();
            if (num % 2 == 0) {
                a += num;
            } else {

                // 如果是奇数，加奇数 -1 个
                // b 标志有奇数参与构建回文串
                int x = num - 1;
                a += x;
                b = 1;
            }
        }

        return a + b;
    }

}
