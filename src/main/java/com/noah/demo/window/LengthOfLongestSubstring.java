package com.noah.demo.window;

import java.util.HashSet;
import java.util.Set;

/**
 * Title: LengthOfLongestSubstring.java <br>
 * Description:             <br>
 * Copyright: Copyright (c) 2015<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author yinzo 2022/7/17
 */
public class LengthOfLongestSubstring {


    public int lengthOfLongestSubstring(String s) {

        int len = s.length();

        int ans = 0;

        Set<Character> set = new HashSet<>();

        int start = 0;
        for (int i = 0; i < len; i++) {

            char c = s.charAt(i);

            while (set.contains(c)) {
                set.remove(s.charAt(start));
                start++;
            }

            set.add(c);
            ans = Math.max(ans, set.size());
        }

        return ans;
    }

}
