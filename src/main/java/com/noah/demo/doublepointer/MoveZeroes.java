package com.noah.demo.doublepointer;

/**
 * Title: MoveZeroes.java <br>
 * Description:             <br>
 * Copyright: Copyright (c) 2015<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author yinzo 2022/8/15
 */
public class MoveZeroes {


    /**
     * 283. 移动零
     * <p>
     * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
     * <p>
     * 请注意 ，必须在不复制数组的情况下原地对数组进行操作。
     * <p>
     * 示例 1:
     * <p>
     * 输入: nums = [0,1,0,3,12]
     * 输出: [1,3,12,0,0]
     *
     * @param nums
     */
    public void moveZeroes(int[] nums) {

        if (nums == null || nums.length <= 1) {
            return;
        }

        int slow = 0;

        int fast = 0;

        while (fast < nums.length) {

            if (nums[fast] != 0) {

                if (fast != slow) {
                    int temp = nums[fast];
                    nums[fast] = nums[slow];
                    nums[slow] = temp;
                }

                slow++;
            }

            fast++;
        }
    }

}
