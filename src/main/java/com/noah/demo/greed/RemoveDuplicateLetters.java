package com.noah.demo.greed;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Title: RemoveDuplicateLetters.java <br>
 * Description:             <br>
 * Copyright: Copyright (c) 2015<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author yinzo 2022/6/30
 */
public class RemoveDuplicateLetters {


    public String removeDuplicateLetters(String s) {

        int len = s.length();

        char[] charArray = s.toCharArray();

        int[] lastIndex = new int[26];

        for (int i = 0; i < len; i++) {

            lastIndex[charArray[i] - 'a'] = i;
        }

        Deque<Character> stack = new ArrayDeque<>();

        // 栈中已经存在的字符
        boolean[] visited = new boolean[26];

        for (int i = 0; i < len; i++) {

            if (visited[charArray[i] - 'a']) {
                continue;
            }

            while (!stack.isEmpty()
                    && stack.peekLast() > charArray[i]
                    && lastIndex[stack.peekLast() - 'a'] > i) {

                char top = stack.removeLast();
                visited[top - 'a'] = false;
            }

            stack.addLast(charArray[i]);
            visited[charArray[i] - 'a'] = true;
        }

        StringBuilder stringBuilder = new StringBuilder();

        for (char c : stack) {
            stringBuilder.append(c);
        }

        return stringBuilder.toString();
    }

}
