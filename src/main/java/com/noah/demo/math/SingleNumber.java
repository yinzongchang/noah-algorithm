package com.noah.demo.math;

/**
 * Title: SingleNumber.java <br>
 * Description:             <br>
 * Copyright: Copyright (c) 2015<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author yinzo 2022/8/27
 */
public class SingleNumber {

    public int singleNumber(int[] nums) {

        int singleNumber = nums[0];

        for (int i = 1; i < nums.length; i++) {

            singleNumber = singleNumber ^ nums[i];
        }

        return singleNumber;
    }


    public static void main(String[] args) {
        System.out.println(0 ^ 1);
    }

}
