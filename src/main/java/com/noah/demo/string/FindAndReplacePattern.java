package com.noah.demo.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Title: FindAndReplacePattern.java <br>
 * Description:             <br>
 * Copyright: Copyright (c) 2015<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author yinzo 2022/6/13
 */
public class FindAndReplacePattern {

    public List<String> findAndReplacePattern(String[] words, String pattern) {

        List<String> result = new ArrayList<>();

        for (String word : words) {

            if (match(word, pattern) && match(pattern, word)) {
                result.add(word);
            }
        }

        return result;
    }

    public boolean match(String word, String pattern) {

        Map<Character, Character> map = new HashMap<>();

        for (int i = 0; i < word.length(); i++) {

            char x = word.charAt(i);
            char y = pattern.charAt(i);

            Character value = map.get(x);

            if (value == null) {

                map.put(x, y);
            } else {

                if (value != y) {
                    return false;
                }
            }
        }

        return true;
    }

}
