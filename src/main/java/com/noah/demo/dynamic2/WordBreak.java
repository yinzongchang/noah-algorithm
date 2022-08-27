package com.noah.demo.dynamic2;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Title: WordBreak.java <br>
 * Description:             <br>
 * Copyright: Copyright (c) 2015<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author yinzo 2022/8/19
 */
public class WordBreak {


    public boolean wordBreak(String s, List<String> wordDict) {


        // 单词集合
        Set<String> wordDictSet = new HashSet<>(wordDict);

        // 表示 [0, s.length() - 1] 是否都包含在单词中
        boolean[] dp = new boolean[s.length() + 1];

        // 空串表示满足条件
        dp[0] = true;

        // s.substring左开右闭
        for (int i = 1; i <= s.length(); i++) {

            for (int j = 0; j < i; j++) {

                if (dp[j] && wordDictSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }


        return dp[s.length()];
    }

    public boolean wordBreak2(String s, List<String> wordDict) {


        // 单词集合
        Set<String> wordDictSet = new HashSet<>(wordDict.size());

        int maxLen = Integer.MIN_VALUE;
        int minLen = Integer.MAX_VALUE;

        for (String word : wordDict) {

            wordDictSet.add(word);
            maxLen = Math.max(maxLen, word.length());
            minLen = Math.min(minLen, word.length());
        }


        // 表示 [0, s.length() - 1] 是否都包含在单词中
        boolean[] dp = new boolean[s.length() + 1];

        // 空串表示满足条件
        dp[0] = true;

        // s.substring左开右闭
        for (int i = 1; i <= s.length(); i++) {

            for (int j = 0; j < i; j++) {

                if (i - j > maxLen || i - j < minLen) {
                    continue;
                }

                if (dp[j] && wordDictSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }


        return dp[s.length()];
    }

}
