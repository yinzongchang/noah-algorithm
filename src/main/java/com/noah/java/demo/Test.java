package com.noah.java.demo;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

/**
 * Title: Test.java <br>
 * Description:             <br>
 * Copyright: Copyright (c) 2015<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author yinzo 2022/8/20
 */
public class Test {

    /**
     * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
     *
     *
     *
     * 示例1:
     *
     * 输入: s = "abcabcbb"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
     */
    public int maxLength(String word) {

        if (word == null || word.length() == 0) {
            return 0;
        }

        int maxLen = 0;

        int len = word.length();

        // 子串所有子符
        Set<Character> characterSet = new HashSet<>();

        Queue<Character> queue = new ArrayDeque<>();


        for (int i = 0; i < len; i++) {


            if (characterSet.contains(word.charAt(i))) {


                while (!queue.isEmpty()) {

                    char c = queue.peek();

                    characterSet.remove(c);
                    queue.poll();

                    if (c == word.charAt(i)) {
                        break;
                    }
                }
            }



            characterSet.add(word.charAt(i));
            queue.offer(word.charAt(i));


            maxLen = Math.max(maxLen, queue.size());
        }

        return maxLen;
    }


    public static void main(String[] args) {

        System.out.println(new Test().maxLength("abcdabcbb"));

    }


}
