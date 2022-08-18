package com.noah.demo.doublepointer;

/**
 * Title: ReverseString.java <br>
 * Description:             <br>
 * Copyright: Copyright (c) 2015<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author yinzo 2022/8/15
 */
public class ReverseString {

    public void reverseString(char[] s) {

        if (s == null || s.length <= 1) {
            return;
        }

        int left = 0;
        int right = s.length - 1;

        while (left < right) {

            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;

            left++;
            right--;
        }

    }

}
