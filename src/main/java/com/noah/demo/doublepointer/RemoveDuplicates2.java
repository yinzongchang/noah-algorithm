package com.noah.demo.doublepointer;

/**
 * Title: RemoveDuplicates2.java <br>
 * Description:             <br>
 * Copyright: Copyright (c) 2015<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author yinzo 2022/8/13
 */
public class RemoveDuplicates2 {

    /**
     * 80. 删除有序数组中的重复项 II
     * <p>
     * 给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使得出现次数超过两次的元素只出现两次 ，返回删除后数组的新长度。
     * <p>
     * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/remove-duplicates-from-sorted-array-ii
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * <p>
     * 输入：nums = [1,1,1,2,2,3]
     * 输出：5, nums = [1,1,2,2,3]
     * 解释：函数应返回新长度 length = 5, 并且原数组的前五个元素被修改为 1, 1, 2, 2, 3 。 不需要考虑数组中超出新长度后面的元素。
     *
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {

        if (nums == null || nums.length == 0) {
            return 0;
        }


        int slow = 0;
        int count = 0;

        int num = nums[0];

        for (int i = 0; i < nums.length; i++) {

            if (nums[i] == num) {

                count++;
                if (count <= 2) {

                    nums[slow] = nums[i];
                    slow++;
                }


            } else {

                nums[slow] = nums[i];
                num = nums[i];
                count = 1;
                slow++;
            }

        }

        return slow;
    }


    public static void main(String[] args) {

        System.out.println(new RemoveDuplicates2().removeDuplicates(new int[]{0, 0, 1, 1, 1, 1, 2, 3, 3}));

    }

}
