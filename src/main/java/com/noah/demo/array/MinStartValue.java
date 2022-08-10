package com.noah.demo.array;

/**
 * Title: MinStartValue.java <br>
 * Description:             <br>
 * Copyright: Copyright (c) 2015<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author yinzo 2022/8/9
 */
public class MinStartValue {


    public int minStartValue(int[] nums) {

        if (nums == null || nums.length == 0) {
            return 1;
        }


        int accSum = 0;
        int accSumMin = 0;

        for(int num : nums) {

            accSum += num;
            accSumMin = Math.min(accSum, accSumMin);
        }

        return 1 - accSumMin;

    }


}
