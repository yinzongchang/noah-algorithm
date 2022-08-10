package com.noah.demo.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Title: GroupAnagrams.java <br>
 * Description:             <br>
 * Copyright: Copyright (c) 2015<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author yinzo 2022/8/2
 */
public class GroupAnagrams {

    /**
     * 49. 字母异位词分组
     * <p>
     * 给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
     * <p>
     * 字母异位词 是由重新排列源单词的字母得到的一个新单词，所有源单词中的字母通常恰好只用一次。
     * <p>
     * 示例 1:
     * <p>
     * 输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
     * 输出: [["bat"],["nat","tan"],["ate","eat","tea"]]
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/group-anagrams
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams(String[] strs) {


        /**
         * 解决不了重复字母的问题
         */
        Map<Integer, List<String>> ansMap = new HashMap<>();

        for (String word : strs) {

            int i = 0;
            for (char c : word.toCharArray()) {

                i |= 1 << c - 'a';
            }

            ansMap.computeIfAbsent(i, k -> new ArrayList<>());

            ansMap.get(i).add(word);
        }


        return new ArrayList<>(ansMap.values());
    }

    public List<List<String>> groupAnagrams2(String[] strs) {


        Map<String, List<String>> ansMap = new HashMap<>();

        for (String word : strs) {

            int[] counter = new int[26];


            for (char c : word.toCharArray()) {

                counter[c - 'a']++;
            }

            StringBuilder stringBuilder= new StringBuilder();

            for (int i = 0; i < 26; i++) {

                if (counter[i] > 0) {
                    stringBuilder.append((char) i + 'a')
                            .append(counter[i]);
                }
            }

            String key = stringBuilder.toString();

            ansMap.computeIfAbsent(key, k -> new ArrayList<>());

            ansMap.get(key).add(word);
        }


        return new ArrayList<>(ansMap.values());
    }


}
