package com.noah.demo.array;

import java.util.HashMap;
import java.util.Map;

/**
 * Title: ClimbStairs.java <br>
 * Description:             <br>
 * Copyright: Copyright (c) 2015<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author yinzo 2022/5/15
 */
public class ClimbStairs {

    public int climbStairs(int n) {

        int a = 0;
        int b = 0;
        int c = 1;

        for (int i = 1; i < n; i++) {

            a = b;
            b = c;
            c = a + b;

        }

        return c;
    }


    Map<Integer, Integer> hasSolvedList = new HashMap<>();

    public int f(int n) {

        if (n == 1) {
            return 1;
        }

        if (n == 2) {
            return 2;
        }

        //
        // hasSolvedList 可以理解成一个 Map，key 是 n，value 是 f(n)
        if (hasSolvedList.containsKey(n)) {
            return hasSolvedList.get(n);
        }

        int ret = f(n - 1) + f(n - 2);
        hasSolvedList.put(n, ret);
        return ret;
    }


}
