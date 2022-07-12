package com.noah.demo.greed;

/**
 * Title: Jump2.java <br>
 * Description:             <br>
 * Copyright: Copyright (c) 2015<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author yinzo 2022/6/27
 */
public class Jump2 {

    public int jump(int[] nums) {

        int len = nums.length;

        int endIndex = 0;

        int stepNum = 0;

        int maxIndex = 0;

        for (int i = 0; i < len - 1; i++) {

            maxIndex = Math.max(maxIndex, i + nums[i]);

            if (i == endIndex) {

                endIndex = maxIndex;
                stepNum++;
            }
        }

        return stepNum;
    }
}
