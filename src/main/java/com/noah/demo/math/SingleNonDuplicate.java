package com.noah.demo.math;

import org.junit.Test;

/**
 * Title: SingleNonDuplicate.java <br>
 * Description:             <br>
 * Copyright: Copyright (c) 2015<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author yinzo 2022/7/17
 */
public class SingleNonDuplicate {

    // 剑指 Offer II 070. 排序数组中只出现一次的数字

    /**
     * 给定一个只包含整数的有序数组 nums，每个元素都会出现两次，唯有一个数只会出现一次，请找出这个唯一的数字。
     * <p>
     * 你设计的解决方案必须满足 O(log n) 时间复杂度和 O(1) 空间复杂度。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/skFtm2
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */


    public int singleNonDuplicate(int[] nums) {

        int left = 0;
        int right = nums.length - 1;

        if (nums.length == 1) {
            return nums[0];
        }

        if (nums[0] != nums[1]) {
            return nums[0];
        }

        if (nums[right] != nums[right - 1]) {
            return nums[right];
        }


        while (left <= right) {


            int mid = (right - left) / 2 + left;

            if (nums[mid] == nums[mid - 1]) {

                if (mid % 2 == 0) {
                    right = mid - 2;
                } else {
                    left = mid + 1;
                }

            } else if (nums[mid] == nums[mid + 1]) {

                if (mid % 2 == 0) {
                    left = mid + 2;
                } else {
                    right = mid - 1;
                }

            } else {

                return nums[mid];
            }
        }

        return nums[left];

    }


    @Test
    public void test() {

        int[] arr = {1, 1, 2, 3, 3, 4, 4, 8, 8};


        System.out.println(new SingleNonDuplicate().singleNonDuplicate(arr));

    }
}
