package com.noah.demo.stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * Title: CheckValidString.java <br>
 * Description:             <br>
 * Copyright: Copyright (c) 2015<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author yinzo 2022/9/3
 */
public class CheckValidString {


    /**
     * 678. 有效的括号字符串
     * <p>
     * 给定一个只包含三种字符的字符串：（ ，） 和 *，写一个函数来检验这个字符串是否为有效字符串。有效字符串具有如下规则：
     * <p>
     * 1. 任何左括号 ( 必须有相应的右括号 )。
     * 2. 任何右括号 ) 必须有相应的左括号 ( 。
     * 3. 左括号 ( 必须在对应的右括号之前 )。
     * 4. * 可以被视为单个右括号 ) ，或单个左括号 ( ，或一个空字符串。
     * 5. 一个空字符串也被视为有效字符串。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/valid-parenthesis-string
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param s
     * @return
     */
    public boolean checkValidString(String s) {


        if (s == null || s.length() == 0) {
            return true;
        }

        // 主栈
        Deque<Character> stack = new ArrayDeque<>();

        // 临时存放*的栈
        Deque<Character> tempStack = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {

            char c = s.charAt(i);

            if (c == '*' || c == '(') {
                stack.push(c);
            }


            if (c == ')') {

                if (stack.isEmpty()) {
                    return false;
                }

                while (!stack.isEmpty() && stack.peek() == '*') {
                    tempStack.push(stack.pop());
                }

                if (stack.isEmpty()) {
                    tempStack.pop();
                } else {
                    stack.pop();
                }

                while (!tempStack.isEmpty()) {
                    stack.push(tempStack.pop());
                }
            }
        }

        if (stack.isEmpty()) {
            return true;
        }

        while (!stack.isEmpty()) {

            if (stack.peek() == '*') {
                tempStack.push(stack.pop());
            } else {

                if (tempStack.isEmpty()) {
                    return false;
                } else {
                    stack.pop();
                    tempStack.pop();
                }
            }
        }

        return stack.isEmpty();
    }


    public boolean checkValidString2(String s) {

        if (s == null || s.length() == 0) {
            return true;
        }

        // 左括号 栈 - 因为消除和顺序相关 - "*****((((("
        Deque<Integer> leftStack = new ArrayDeque<>();

        // 存放*的栈
        Deque<Integer> asteriskStack = new ArrayDeque<>();


        for (int i = 0; i < s.length(); i++) {

            char c = s.charAt(i);

            if (c == '(') {
                leftStack.push(i);
            } else if (c == '*') {
                asteriskStack.push(i);
            } else if (c == ')') {

                if (!leftStack.isEmpty()) {
                    leftStack.pop();
                } else if (!asteriskStack.isEmpty()) {
                    asteriskStack.pop();
                } else {
                    return false;
                }
            }
        }


        while (!leftStack.isEmpty() && !asteriskStack.isEmpty()) {

            int leftIndex = leftStack.pop();
            int asteriskIndex = asteriskStack.pop();

            if (leftIndex > asteriskIndex) {
                return false;
            }
        }

        return leftStack.isEmpty();
    }


    public static void main(String[] args) {

        new CheckValidString().checkValidString("((((()(()()()*()(((((*)()*(**(())))))(())()())(((())())())))))))(((((())*)))()))(()((*()*(*)))(*)()");

    }


}
