package com.noah.demo.string;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Title: Brackets.java <br>
 * Description:             <br>
 * Copyright: Copyright (c) 2015<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author yinzo 2022/5/10
 */
public class Brackets {

    public boolean isValid(String s) {

        if (s == null || s.length() == 0) {
            return false;
        }
        if (s.length() % 2 == 1) {
            return false;
        }

        Map<Character, Character> map = new HashMap<Character, Character>() {

            private static final long serialVersionUID = 7485098074667645856L;

            {
                put(')', '(');
                put(']', '[');
                put('}', '{');
            }
        };

        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {

            if (map.containsKey(c)) {

                if (stack.isEmpty() || stack.peek() != map.get(c)) {
                    return false;
                }

                stack.pop();
            } else {
                stack.push(c);
            }
        }


        return stack.isEmpty();
    }


}
