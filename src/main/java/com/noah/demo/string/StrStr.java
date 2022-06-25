package com.noah.demo.string;

/**
 * Title: StrStr.java <br>
 * Description:             <br>
 * Copyright: Copyright (c) 2015<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author yinzo 2022/5/11
 */
public class StrStr {

    public int strStr(String haystack, String needle) {

        if (needle == null || needle.length() == 0) {
            return 0;
        }

        int result = -1;

        for (int i = 0; i < haystack.length(); i++) {

            boolean flag = true;

            for (int j = 0; j < needle.length(); j++) {

                if (i + j >= haystack.length()) {
                    return result;
                }

                char a = haystack.charAt(i + j);
                char b = needle.charAt(j);

                if (a != b) {
                   flag = false;
                }
            }

            if (flag) {
                return i;
            }
        }

        return result;
    }

}
