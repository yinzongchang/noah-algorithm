package com.noah.demo.suanfa;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Title: DiffWaysToCompute.java <br>
 * Description:             <br>
 * Copyright: Copyright (c) 2015<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author yinzo 2021/11/7
 */
public class DiffWaysToCompute {


    @Test
    public void test() {

    }

    /**
     * 解题思路
     * 对于一个形如 x op y（op 为运算符，x 和 y 为数） 的算式而言，它的结果组合取决于 x 和 y 的结果组合数，而 x 和 y 又可以写成形如 x op y 的算式。
     *
     * 因此，该问题的子问题就是 x op y 中的 x 和 y：以运算符分隔的左右两侧算式解。
     *
     * 然后我们来进行 分治算法三步走：
     *
     * 分解：按运算符分成左右两部分，分别求解
     * 解决：实现一个递归函数，输入算式，返回算式解
     * 合并：根据运算符合并左右两部分的解，得出最终解
     *
     * 作者：jalan
     * 链接：https://leetcode-cn.com/problems/different-ways-to-add-parentheses/solution/pythongolang-fen-zhi-suan-fa-by-jalan/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     * @param expression
     * @return
     */
    public List<Integer> diffWaysToCompute(String expression) {

        List<Integer> list = new ArrayList<>();

        int len = expression.length();

        int start = 0;

        for (start = 0; start < len; start++) {

            if (Character.isDigit(expression.charAt(start))) {
                continue;
            } else {
                break;
            }
        }

        if (start == len) {
            list.add(Integer.parseInt(expression));
        }

        for (int i = start; i < len; i++) {

            if (Character.isDigit(expression.charAt(i))) {
                continue;
            }

            // 运算符号
            char op = expression.charAt(i);

            List<Integer> left = diffWaysToCompute(expression.substring(0, i));
            List<Integer> right = diffWaysToCompute(expression.substring(i + 1, len));

            for (int j : left) {

                for (int k : right) {
                    if (op == '+') {
                        list.add(j + k);
                    }
                    if (op == '-') {
                        list.add(j - k);
                    }
                    if (op == '*') {
                        list.add(j * k);
                    }
                }
            }
        }

        return list;
    }


}
