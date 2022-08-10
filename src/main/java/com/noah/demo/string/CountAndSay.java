package com.noah.demo.string;

import org.junit.Test;

/**
 * Title: CountAndSay.java <br>
 * Description:             <br>
 * Copyright: Copyright (c) 2015<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author yinzo 2022/8/3
 */
public class CountAndSay {



    public String countAndSay(int n) {


        String word = "1";

        if (n == 1) {
            return word;
        }

        for (int i = 1; i < n; i++) {


            int len = word.length();

            char c = word.charAt(0);
            int count = 0;

            StringBuilder sb = new StringBuilder();

            for (int j = 0; j < len; j++) {

                if (word.charAt(j) == c) {
                    count++;

                    if (j == len - 1) {
                        sb.append(count).append(c);
                    }
                    continue;
                }

                sb.append(count).append(c);
                c = word.charAt(j);
                count = 0;
                j--;


            }


            word = sb.toString();
        }

        return word;

    }


    @Test
    public void test() {


        System.out.println(new CountAndSay().countAndSay(4));
    }

}
