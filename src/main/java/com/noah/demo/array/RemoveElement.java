package com.noah.demo.array;

/**
 * Title: RemoveElement.java <br>
 * Description:             <br>
 * Copyright: Copyright (c) 2015<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author yinzo 2022/5/10
 */
public class RemoveElement {


    public int removeElement(int[] nums, int val) {

        int i = 0;
        int j = nums.length;

        while (i < j) {

            if (nums[i] == val) {
                nums[i] = nums[j - 1];
                j--;
            } else {
                i++;
            }
        }

        return i;
    }


    public int removeElement2(int[] nums, int val) {

        int slow = 0;
        int fast = 0;

        while (fast < nums.length) {

            if (nums[fast] != val) {
                nums[slow] = nums[fast];
                slow++;
            }

            fast++;
        }


        return slow;
    }

}
