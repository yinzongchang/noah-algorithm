package com.noah.demo.doublepointer;

import java.util.List;

/**
 * Title: FindLongestWord.java <br>
 * Description:             <br>
 * Copyright: Copyright (c) 2015<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author yinzo 2022/8/21
 */
public class FindLongestWord {


    /**
     * 524. 通过删除字母匹配到字典里最长单词
     * <p>
     * 给你一个字符串 s 和一个字符串数组 dictionary ，找出并返回 dictionary 中最长的字符串，该字符串可以通过删除 s 中的某些字符得到。
     * 如果答案不止一个，返回长度最长且字母序最小的字符串。如果答案不存在，则返回空字符串。
     * <p>
     * 示例 1：
     * <p>
     * 输入：s = "abpcplea", dictionary = ["ale","apple","monkey","plea"]
     * 输出："apple"
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/longest-word-in-dictionary-through-deleting
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param s
     * @param dictionary
     * @return
     */
    public String findLongestWord(String s, List<String> dictionary) {

        String ans = "";

        for (int i = 0; i < dictionary.size(); i++) {

            String word = dictionary.get(i);

            int p1 = 0;
            int p2 = 0;

            while (p1 < s.length() && p2 < word.length()) {

                if (s.charAt(p1) == word.charAt(p2)) {

                    p2++;
                }

                p1++;
            }

            // word 是字符串子串
            if (p2 == word.length()) {

                if (word.length() > ans.length() || (word.length() == ans.length() && word.compareTo(ans) < 0)) {

                    ans = word;
                }
            }
        }

        return ans;
    }

}
