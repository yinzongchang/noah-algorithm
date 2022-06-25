package com.noah.demo.suanfa;

/**
 * Title: DetectCapitalUse.java <br>
 * Description:             <br>
 * Copyright: Copyright (c) 2015<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author yinzo 2021/11/13
 */
public class DetectCapitalUse {



    public boolean detectCapitalUse(String word) {


        if (word.length() >= 2 && Character.isLowerCase(word.charAt(0)) && Character.isUpperCase(word.charAt(1))) {
            return false;
        }

        for (int i = 2; i < word.length(); i++) {
            if (Character.isLowerCase(word.charAt(i)) ^ Character.isLowerCase(word.charAt(1))) {
                return false;
            }
        }

        return true;
    }



}
