package com.noah.demo.array;

/**
 * Title: PlusOne.java <br>
 * Description:             <br>
 * Copyright: Copyright (c) 2015<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author yinzo 2022/5/11
 */
public class PlusOne {

    public int[] plusOne(int[] digits) {


        for (int i = digits.length - 1; i >= 0; i--) {

            digits[i] = (digits[i] + 1) % 10;

            if (digits[i] != 0) {
                return digits;
            }
        }

        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }
}
