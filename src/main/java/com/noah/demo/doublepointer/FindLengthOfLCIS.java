package com.noah.demo.doublepointer;

/**
 * Title: FindLengthOfLCIS.java <br>
 * Description:             <br>
 * Copyright: Copyright (c) 2015<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author yinzo 2022/8/27
 */
public class FindLengthOfLCIS {


    public int findLengthOfLCIS(int[] nums) {

        if (nums == null || nums.length == 0) {

            return 0;
        }

        if (nums.length == 1) {
            return 1;
        }

        int maxLen = 1;

        int len = nums.length;

        int left = 0;
        int right = 1;

        while (right < len) {

            if (nums[right] <= nums[right - 1]) {

                left = right;
            }

            maxLen = Math.max(maxLen, right - left);
            right++;
        }

        return maxLen;
    }

}
