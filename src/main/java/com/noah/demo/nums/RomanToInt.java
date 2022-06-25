package com.noah.demo.nums;

import java.util.HashMap;
import java.util.Map;

/**
 * Title: RomanToInt.java <br>
 * Description:             <br>
 * Copyright: Copyright (c) 2015<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author yinzo 2022/5/10
 */
public class RomanToInt {



    public int romanToInt(String s) {

        Map<Character, Integer> symbolValues = new HashMap<Character, Integer>() {
            private static final long serialVersionUID = -4253651671081287231L;

            {
                put('I', 1);
                put('V', 5);
                put('X', 10);
                put('L', 50);
                put('C', 100);
                put('D', 500);
                put('M', 1000);
            }
        };

        int result = 0;

        for (int i = 0; i < s.length(); i++) {

            int value = symbolValues.get(s.charAt(i));

            if (i < s.length() - 1 && value < symbolValues.get(s.charAt(i + 1))) {

                result -= value;
            } else {
                result += value;
            }
        }

        return result;
    }


}
