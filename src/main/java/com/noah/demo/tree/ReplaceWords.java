package com.noah.demo.tree;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Title: ReplaceWords.java <br>
 * Description:             <br>
 * Copyright: Copyright (c) 2015<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author yinzo 2022/7/7
 */
public class ReplaceWords {

    public String replaceWords(List<String> dictionary, String sentence) {

        // Trie 树
        Trie trie = new Trie();

        // 构建 Trie 树
        for (String dict : dictionary) {

            Trie curr = trie;

            for (int i = 0; i < dict.length(); i++) {

                // 当前字符
                char c = dict.charAt(i);

                curr.childMap.putIfAbsent(c, new Trie());

                // trie 的下一层
                curr = curr.childMap.get(c);
            }

            // 设置结尾字符
            curr.childMap.put('#', new Trie());
        }

        // 获取句子中的数组
        String[] wordArray = sentence.split(" ");


        // 结果单词数组
        String[] ansArray = new String[wordArray.length];

        for (int i = 0; i < wordArray.length; i++) {

            ansArray[i] = findRoot(trie, wordArray[i]);
        }

        return String.join(" ", ansArray);

    }

    /**
     * @param trie
     * @param word
     * @return
     */
    public String findRoot(Trie trie, String word) {

        Trie curr = trie;

        StringBuilder stringBuilder = new StringBuilder();
        for (char c : word.toCharArray()) {

            if (curr.childMap.containsKey('#')) {

                return stringBuilder.toString();
            }

            if (!curr.childMap.containsKey(c)) {
                return word;
            }



            stringBuilder.append(c);
            curr = curr.childMap.get(c);
        }

        return word;
    }


    static class Trie {

        Map<Character, Trie> childMap = new HashMap<>();

    }
}
