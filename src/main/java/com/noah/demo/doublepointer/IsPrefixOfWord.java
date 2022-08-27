package com.noah.demo.doublepointer;

/**
 * Title: IsPrefixOfWord.java <br>
 * Description:             <br>
 * Copyright: Copyright (c) 2015<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author yinzo 2022/8/21
 */
public class IsPrefixOfWord {

    /**
     * 1455. 检查单词是否为句中其他单词的前缀
     *
     * 给你一个字符串 sentence 作为句子并指定检索词为 searchWord ，其中句子由若干用 单个空格 分隔的单词组成。
     * 请你检查检索词 searchWord 是否为句子 sentence 中任意单词的前缀。
     *
     * 如果 searchWord 是某一个单词的前缀，则返回句子 sentence 中该单词所对应的下标（下标从 1 开始）。
     * 如果 searchWord 是多个单词的前缀，则返回匹配的第一个单词的下标（最小下标）。如果 searchWord 不是任何单词的前缀，则返回 -1 。
     *
     * 字符串 s 的 前缀 是 s 的任何前导连续子字符串。
     *
     * 示例 1：
     *
     * 输入：sentence = "i love eating burger", searchWord = "burg"
     * 输出：4
     * 解释："burg" 是 "burger" 的前缀，而 "burger" 是句子中第 4 个单词。
     *
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/check-if-a-word-occurs-as-a-prefix-of-any-word-in-a-sentence
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public int isPrefixOfWord(String sentence, String searchWord) {

        int len = sentence.length();

        int index = 1;

        int start = 0;
        int end = 0;

        while (start < len) {

            while (end < len && sentence.charAt(end) != ' ') {
                end++;
            }

            if (isPrefix(sentence, start, end, searchWord)) {
                return index;
            }

            index++;
            end++;
            start = end;
        }

        return -1;
    }

    public boolean isPrefix(String sentence, int start, int end, String searchWord) {

        for (int i = 0; i < searchWord.length(); i++) {

            if (start + i >= end || sentence.charAt(start + i) != searchWord.charAt(i)) {
                return false;
            }

        }

        return true;
    }


}
