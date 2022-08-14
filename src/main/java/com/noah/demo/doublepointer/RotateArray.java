package com.noah.demo.doublepointer;

/**
 * Title: RotateArray.java <br>
 * Description:             <br>
 * Copyright: Copyright (c) 2015<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author yinzo 2022/8/14
 */
public class RotateArray {

    /**
     * 189. 轮转数组
     * 给你一个数组，将数组中的元素向右轮转 k 个位置，其中 k 是非负数。
     * <p>
     * 示例 1:
     * <p>
     * 输入: nums = [1,2,3,4,5,6,7], k = 3
     * 输出: [5,6,7,1,2,3,4]
     * 解释:
     * 向右轮转 1 步: [7,1,2,3,4,5,6]
     * 向右轮转 2 步: [6,7,1,2,3,4,5]
     * 向右轮转 3 步: [5,6,7,1,2,3,4]
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/rotate-array
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public void rotate(int[] nums, int k) {

        int len = nums.length;

        k = k % len;

        // 1. 将整个数组翻转
        // [7, 6, 5, 4, 3, 2, 1]
        reverse(nums, 0, len - 1);

        // 2. 将前k个翻转
        // [5, 6 , 7]
        reverse(nums, 0, k - 1);

        // 3. 将后续翻转
        // [1, 2, 3, 4]
        reverse(nums, k, len - 1);
    }

    /**
     * 翻转数组
     *
     * @param nums
     * @param left
     * @param right
     */
    public void reverse(int[] nums, int left, int right) {


        while (left < right) {

            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }

}
