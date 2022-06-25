package com.noah.demo.string;

/**
 * Title: LengthOfLastWord.java <br>
 * Description:             <br>
 * Copyright: Copyright (c) 2015<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author yinzo 2022/5/11
 */
public class LengthOfLastWord {


    public int lengthOfLastWord(String s) {

        if (s == null || s.length() == 0) {
            return 0;
        }

        int index = s.length() - 1;

        while (index > 0 && s.charAt(index) == ' ') {
            index--;
        }

        int length = 0;

        while (index > 0 && s.charAt(index) != ' ') {
            index--;
            length++;
        }


        return length;
    }


}
