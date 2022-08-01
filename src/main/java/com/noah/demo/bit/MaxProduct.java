package com.noah.demo.bit;

/**
 * Title: MaxProduct.java <br>
 * Description:             <br>
 * Copyright: Copyright (c) 2015<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author yinzo 2022/8/1
 */
public class MaxProduct {

    /**
     * 318. 最大单词长度乘积
     * 给你一个字符串数组 words ，找出并返回 length(words[i]) * length(words[j]) 的最大值，并且这两个单词不含有公共字母。
     * 如果不存在这样的两个单词，返回 0 。
     * <p>
     * 示例 1：
     * <p>
     * 输入：words = ["abcw","baz","foo","bar","xtfn","abcdef"]
     * 输出：16
     * 解释：这两个单词为 "abcw", "xtfn"。
     * <p>
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/maximum-product-of-word-lengths
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param words
     * @return
     */
    public int maxProduct(String[] words) {

        int len = words.length;

        // 都是小写字母
        // 使用位运算来标记单词中出现的字母
        int[] marks = new int[len];


        for (int i = 0; i < len; i++) {

            String word = words[i];

            for (int j = 0; j < word.length(); j++) {

                marks[i] |= 1 << (word.charAt(j) - 'a');
            }
        }

        int maxProduct = 0;

        for (int i = 0; i < len; i++) {

            for (int j = i + 1; j < len; j++) {

                if ((marks[i] & marks[j]) == 0) {

                    maxProduct = Math.max(maxProduct, words[i].length() * words[j].length());
                }

            }
        }

        return maxProduct;
    }

}
