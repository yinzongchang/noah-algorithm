package com.noah.demo.math;

/**
 * Title: MyPow.java <br>
 * Description:             <br>
 * Copyright: Copyright (c) 2015<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author yinzo 2022/8/28
 */
public class MyPow {

    public double myPow(double x, int n) {

        if (x == 0d) {
            return x;
        }

        // 防止溢出用 long 承载
        long b = n;
        double res = 1;

        if (b < 0) {

            x = 1 / x;
            b = -b;
        }

        while (b > 0) {

            // 当 b 为奇数时
            if ((b & 1) == 1) {
                res *= x;
            }

            x *= x;

            // 除2
            b >>= 1;
        }

        return res;
    }

}
