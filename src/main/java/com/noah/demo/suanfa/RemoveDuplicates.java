package com.noah.demo.suanfa;

/**
 * Title: RemoveDuplicates.java <br>
 * Description:             <br>
 * Copyright: Copyright (c) 2015<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author yinzo 2021/11/13
 */
public class RemoveDuplicates {


    public int removeDuplicates(int[] nums) {

        if (nums == null || nums.length == 0) {
            return 0;
        }

        if (nums.length < 2) {
            return 1;
        }

        int tmp = nums[0];
        int x = 1;

        for (int i = 1; i < nums.length; i++) {

            if (tmp != nums[i]) {
                nums[x] = nums[i];
                tmp = nums[i];
                x = x + 1;
            }
        }


        return x + 1;
    }

}
