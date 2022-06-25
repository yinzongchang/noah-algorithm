package com.noah.demo.suanfa;

/**
 * Title: SearchInsert.java <br>
 * Description:             <br>
 * Copyright: Copyright (c) 2015<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author yinzo 2021/11/13
 */
public class SearchInsert {

    public int searchInsert(int[] nums, int target) {

        int n = nums.length;
        int left = 0;
        int right = n - 1;
        int ans = n;


        while (left <= right) {

            int mid = (right - left) / 2 + left;

            if (target <= nums[mid]) {

                ans = mid;
                right = mid - 1;

            } else {
                left = left + 1;
            }
        }

        return ans;
    }


}
