package com.noah.demo.doublepointer;

/**
 * Title: ReverseWords.java <br>
 * Description:             <br>
 * Copyright: Copyright (c) 2015<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author yinzo 2022/8/14
 */
public class ReverseWords {


    /**
     * 151. 颠倒字符串中的单词
     * 给你一个字符串 s ，颠倒字符串中 单词 的顺序。
     * <p>
     * 单词 是由非空格字符组成的字符串。s 中使用至少一个空格将字符串中的 单词 分隔开。
     * <p>
     * 返回 单词 顺序颠倒且 单词 之间用单个空格连接的结果字符串。
     * <p>
     * 注意：输入字符串 s中可能会存在前导空格、尾随空格或者单词间的多个空格。返回的结果字符串中，单词间应当仅用单个空格分隔，且不包含任何额外的空格。
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：s = "the sky is blue"
     * 输出："blue is sky the"
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/reverse-words-in-a-string
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public String reverseWords(String s) {


        StringBuilder words = trimSpaces(s);

        int len = words.length();

        // 1. 整个字符串翻转
        reverse(words, 0, len - 1);

        // 2. 逐个单词翻转

        int start = 0;
        for (int i = 0; i < len; i++) {

            if (words.charAt(i) == ' ') {

                reverse(words, start, i - 1);
                start = i + 1;
            }

            if (i == len - 1) {

                reverse(words, start, i);
            }
        }


        return words.toString();
    }


    public StringBuilder trimSpaces(String s) {

        StringBuilder stringBuilder = new StringBuilder();

        int left = 0;
        int right = s.length() - 1;

        // 去除字符串首部空格
        while (left <= right && s.charAt(left) == ' ') {
            left++;
        }

        while (left <= right && s.charAt(right) == ' ') {
            right--;
        }

        while (left <= right) {

            if (s.charAt(left) != ' ') {
                stringBuilder.append(s.charAt(left));
            } else if (s.charAt(left - 1) != ' ') {

                stringBuilder.append(s.charAt(left));
            }

            left++;
        }

        return stringBuilder;
    }

    public void reverse(StringBuilder sb, int left, int right) {

        if (left == right) {
            return;
        }

        while (left <= right) {
            char temp = sb.charAt(left);

            sb.setCharAt(left, sb.charAt(right));
            sb.setCharAt(right, temp);

            left++;
            right--;
        }
    }


}
