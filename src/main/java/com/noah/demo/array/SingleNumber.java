package com.noah.demo.array;

/**
 * Title: SingleNumber.java <br>
 * Description:             <br>
 * Copyright: Copyright (c) 2015<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author yinzo 2022/5/18
 */
public class SingleNumber {

    public int singleNumber(int[] nums) {

        int singleNumber = 0;

        for (int num : nums) {

            singleNumber = singleNumber ^ num;
        }

        return singleNumber;
    }
}
