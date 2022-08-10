package com.noah.demo.array;

/**
 * Title: SortColors.java <br>
 * Description:             <br>
 * Copyright: Copyright (c) 2015<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author yinzo 2022/8/2
 */
public class SortColors {

    public void sortColors(int[] nums) {

        int len = nums.length;

        int point = 0;

        for (int i = 0; i < len; i++) {

            if (nums[i] == 0 && i > point) {

                swap(nums, i, point);
                point++;
            }
        }


        for (int i = point; i < len; i++) {

            if (nums[i] == 1 && i > point) {

                swap(nums, i, point);
                point++;
            }
        }
    }

    public void swap(int[] nums, int i, int j) {

        int temp = nums[i];

        nums[i] = nums[j];
        nums[j] = temp;
    }

}
