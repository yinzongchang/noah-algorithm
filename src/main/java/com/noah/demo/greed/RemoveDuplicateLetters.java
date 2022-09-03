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


    /**
     * 316. 去除重复字母
     *
     * 给你一个字符串 s ，请你去除字符串中重复的字母，使得每个字母只出现一次。需保证 返回结果的字典序最小（要求不能打乱其他字符的相对位置）。
     *
     * 示例 1：
     *
     * 输入：s = "bcabc"
     * 输出："abc"
     * 示例 2：
     *
     * 输入：s = "cbacdcbc"
     * 输出："acdb"
     *
     * 关键点：
     * 1. 数据结构，辅助栈
     * 2. 记录每一个字符最后一次出现的下标
     * 3. 判断当前字母是否在栈中出现过
     *
     * https://leetcode.cn/problems/remove-duplicate-letters/
     *
     * @param s
     * @return
     */
    public String removeDuplicateLetters(String s) {

        int len = s.length();

        char[] charArray = s.toCharArray();

        // 记录每一个字符最后一次出现的下标
        int[] lastIndex = new int[26];

        for (int i = 0; i < len; i++) {

            lastIndex[charArray[i] - 'a'] = i;
        }

        Deque<Character> stack = new ArrayDeque<>();

        // 判断当前字母是否在栈中出现过
        // 栈中已经存在的字符
        boolean[] visited = new boolean[26];

        for (int i = 0; i < len; i++) {

            if (visited[charArray[i] - 'a']) {
                continue;
            }

            // 1. 栈不为空;
            // 2. 栈顶元素大于当前元素;
            // 3. 栈顶元素最后一次出现的下标在 i 之后
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
