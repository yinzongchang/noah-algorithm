package com.noah.demo.array;

/**
 * Title: MinDeletionSize.java <br>
 * Description:             <br>
 * Copyright: Copyright (c) 2015<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author yinzo 2022/5/12
 */
public class MinDeletionSize {

    public int minDeletionSize(String[] strs) {

        String str = strs[0];

        int result = 0;

        for (int j = 0; j < str.length(); j++) {

            for (int i = 1; i < strs.length; i++) {

                if (strs[i - 1].charAt(j) > strs[i].charAt(j)) {
                    result++;
                    break;
                }
            }
        }

        return result;
    }


}
