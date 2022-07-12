package com.noah.demo.tree;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Title: MagicDictionary.java <br>
 * Description:             <br>
 * Copyright: Copyright (c) 2015<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author yinzo 2022/7/11
 */
public class MagicDictionary {

    Trie trie;


    public MagicDictionary() {

        trie = new Trie();

    }

    public void buildDict(String[] dictionary) {


        for (String dict : dictionary) {

            Trie curr = trie;
            for (int i = 0; i < dict.length(); i++) {

                char c = dict.charAt(i);
                curr.childMap.putIfAbsent(c, new Trie());

                curr = curr.childMap.get(c);
            }
            curr.childMap.put('#', new Trie());

        }

    }

    public boolean search(String searchWord) {

        int magic = 0;

        Trie curr = trie;


        int i = 0;
        for (; i < searchWord.length(); i++) {

            char c = searchWord.charAt(i);
            Trie trie1 = curr.childMap.get(c);

            // 需要替换的字符
            if (trie1 == null) {

                if (curr.childMap.keySet().size() == 0) {
                    return false;
                }

                magic++;
                break;
            }
            curr = curr.childMap.get(c);
        }

        if (magic == 0 && curr.childMap.containsKey('#')) {





            return false;
        }

        for (Map.Entry<Character, Trie> entry : curr.childMap.entrySet()) {

            Trie innerTrie = entry.getValue();

            int j;
            for (j = i + 1; j < searchWord.length(); j++) {

                char c = searchWord.charAt(j);
                if (!innerTrie.childMap.containsKey(c)) {
                    break;
                }

                innerTrie = innerTrie.childMap.get(c);
            }

            if (j == searchWord.length() && innerTrie.childMap.containsKey('#')) {
                return true;

            }
        }

        return false;

    }

    /**
     * 构建一个trie树
     */
    static class Trie {

        Map<Character, Trie> childMap = new HashMap<>();
    }


}
