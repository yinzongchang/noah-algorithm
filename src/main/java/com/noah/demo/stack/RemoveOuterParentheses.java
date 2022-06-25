package com.noah.demo.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Title: RemoveOuterParentheses.java <br>
 * Description:             <br>
 * Copyright: Copyright (c) 2015<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author yinzo 2022/5/28
 */
public class RemoveOuterParentheses {

    public String removeOuterParentheses(String s) {

        StringBuilder result = new StringBuilder();

        Deque<Character> stack = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {

            char c = s.charAt(i);

            if (')' == c) {
                stack.pop();
            }

            if (!stack.isEmpty()) {
                result.append(c);
            }

            if ('(' == c) {
                stack.push(c);
            }
        }

        return result.toString();
    }

}
