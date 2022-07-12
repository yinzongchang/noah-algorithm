package com.noah.demo.greed;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Title: RemoveKdigits.java <br>
 * Description:             <br>
 * Copyright: Copyright (c) 2015<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author yinzo 2022/6/30
 */
public class RemoveKdigits {

    public String removeKdigits(String num, int k) {


        Deque<Character> deque = new LinkedList<>();

        int length = num.length();

        for (int i = 0; i < length; i++) {

            char digit = num.charAt(i);

            while (!deque.isEmpty() && k > 0 && deque.peekLast() > digit) {

                deque.pollLast();
                k--;
            }

            deque.offerLast(digit);
        }

        for (int i = 0; i < k; i++) {
            deque.pollLast();
        }

        StringBuilder stringBuilder = new StringBuilder();

        boolean leadingZero = true;

        while (!deque.isEmpty()) {

            char digit = deque.pollFirst();
            if (leadingZero && digit == '0') {
                continue;
            }

            leadingZero = false;
            stringBuilder.append(digit);
        }

        return stringBuilder.length() == 0 ? "0" : stringBuilder.toString();
    }

}
