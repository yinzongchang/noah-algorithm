package com.noah.demo.suanfa;

import java.util.HashMap;
import java.util.Map;

/**
 * Title: LengthOfLongestSubstring.java <br>
 * Description:             <br>
 * Copyright: Copyright (c) 2015<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author yinzo 2022/2/20
 */
public class LengthOfLongestSubstring {


    public static void main(String[] args) {


        Map<String, Integer> map = new HashMap<>();

        int a = map.get(null) + 1;


        System.out.println(a);

    }




    public static int getLengthOfLongestSubstring(String s) {

        if (s == null || s.length() == 0) {
            return 0;
        }

        // 定义map（字符 - 对应位置）
        Map<Character, Integer> map = new HashMap<>();

        int max = 0;

        int left = 0;

        for (int i = 0; i < s.length(); i++) {

            if (map.containsKey(s.charAt(i))) {
                left = Math.max(left, map.get(s.charAt(i)) + 1);
            }

            map.put(s.charAt(i), i);
            max = Math.max(max, i - left + 1);
        }

        return max;
    }

}
