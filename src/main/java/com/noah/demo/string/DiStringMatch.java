package com.noah.demo.string;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Title: DiStringMatch.java <br>
 * Description:             <br>
 * Copyright: Copyright (c) 2015<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author yinzo 2022/5/9
 */
public class DiStringMatch {


    public int[] diStringMatch(String s) {

        if (s == null || s.isEmpty()) {
            return new int[]{};
        }

        int[] result = new int[s.length() + 1];

        int min = 0;
        int max = s.length();

        for (int i = 0; i < s.length(); i++) {

            if (Objects.equals(String.valueOf(s.charAt(i)), "I")) {
                result[i] = min;
                min++;
            } else {

                result[i] = max;
                max--;
            }
        }

        result[s.length()] = max;
        return result;

    }


    public static void main(String[] args) {

        char i = 1;

    }

}
