package com.noah.demo.math;

/**
 * Title: ToHex.java <br>
 * Description:             <br>
 * Copyright: Copyright (c) 2015<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author yinzo 2022/8/27
 */
public class ToHex {

    /**
     * 405. 数字转换为十六进制数
     * <p>
     * 给定一个整数，编写一个算法将这个数转换为十六进制数。对于负整数，我们通常使用 补码运算 方法。
     * <p>
     * 注意:
     * <p>
     * 1. 十六进制中所有字母(a-f)都必须是小写。
     * 2. 十六进制字符串中不能包含多余的前导零。如果要转化的数为0，那么以单个字符'0'来表示；对于其他情况，十六进制字符串中的第一个字符将不会是0字符。
     * 3. 给定的数确保在32位有符号整数范围内。
     * 4. 不能使用任何由库提供的将数字直接转换或格式化为十六进制的方法。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/convert-a-number-to-hexadecimal
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public String toHex(int num) {

        if (num == 0) {
            return "0";
        }

        // 存放结果
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 7; i >= 0; i--) {

            // 与 0xf(1111) 按位与
            int value = (num >> (4 * i)) & 0xf;

            if (stringBuilder.length() > 0 || value > 0) {

                char digit = (char) value < 10 ? (char) ('0' + value) : (char) ('a' + (value - 10));
                stringBuilder.append(digit);
            }
        }

        return stringBuilder.toString();
    }

    public static void main(String[] args) {

        System.out.println(new ToHex().toHex(-1));

    }

}
