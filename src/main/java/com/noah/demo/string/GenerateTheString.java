package com.noah.demo.string;

/**
 * Title: GenerateTheString.java <br>
 * Description:             <br>
 * Copyright: Copyright (c) 2015<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author yinzo 2022/8/1
 */
public class GenerateTheString {

    public String generateTheString(int n) {

        StringBuilder ans = new StringBuilder();

        if (n % 2 == 1) {

            for (int i = 0; i < n; i++) {
                ans.append("a");
            }

            return ans.toString();
        } else {

            for (int i = 0; i < n - 1; i++) {
                ans.append("a");
            }
            ans.append("b");
            return ans.toString();
        }
    }

}
