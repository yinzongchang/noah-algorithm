package com.noah.demo.string;

/**
 * Title: AddStrings.java <br>
 * Description:             <br>
 * Copyright: Copyright (c) 2015<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author yinzo 2022/5/18
 */
public class AddStrings {

    public String addStrings(String num1, String num2) {

        StringBuilder stringBuilder = new StringBuilder();

        int l1 = num1.length() - 1;
        int l2 = num2.length() - 1;

        int carry = 0;

        while (l1 >= 0 || l2 >= 0) {

            int a = l1 >= 0 ? num1.charAt(l1) - '0' : 0;
            int b = l2 >= 0 ? num2.charAt(l2) - '0' : 0;

            int temp = a + b + carry;
            carry = temp / 10;
            stringBuilder.append(temp % 10);

            l1--;
            l2--;
        }

        if (carry > 0) {
            stringBuilder.append(carry);
        }

        return stringBuilder.reverse().toString();
    }


}
