package com.noah.demo.array;

/**
 * Title: RemoveDuplicates.java <br>
 * Description:             <br>
 * Copyright: Copyright (c) 2015<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author yinzo 2022/5/3
 */
public class RemoveDuplicates {


    public int removeDuplicates(int[] nums) {

        if (nums == null || nums.length == 0) {
            return 0;
        }

        if (nums.length < 2) {
            return 1;
        }

        int slow = 1;

        for (int i = 1; i < nums.length; i++) {

            if (nums[i] != nums[i - 1]) {
                nums[slow] = nums[i];
                ++slow;
            }

        }

        return slow;
    }


    public int removeDuplicates2(int[] nums) {

        if (nums == null || nums.length == 0) {
            return 0;
        }

        if (nums.length < 2) {
            return 1;
        }

        int slow = 1;
        int fast = 1;

        while (fast < nums.length) {

            if (nums[fast - 1] != nums[fast]) {

                nums[slow] = nums[fast];
                slow++;
            }

            fast++;
        }

        return slow;
    }

}
