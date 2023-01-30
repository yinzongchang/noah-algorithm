package com.noah.demo.search;

/**
 * Title: RotateHalf.java <br>
 * Description:             <br>
 * Copyright: Copyright (c) 2015<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author yinzo 2022/8/13
 */
public class RotateHalf {


    /**
     * 33. 搜索旋转排序数组
     * <p>
     * 整数数组 nums 按升序排列，数组中的值 互不相同 。
     * 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转，使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。
     * 例如， [0,1,2,4,5,6,7] 在下标 3 处经旋转后可能变为 [4,5,6,7,0,1,2] 。
     * <p>
     * 给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的下标，否则返回 -1。
     * <p>
     * 你必须设计一个时间复杂度为 O(log n) 的算法解决此问题。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/search-in-rotated-sorted-array
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * <p>
     * 示例 1：
     * <p>
     * 输入：nums = [4,5,6,7,0,1,2], target = 0
     * 输出：4
     *
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {

        if (nums == null || nums.length == 0) {
            return -1;
        }

        if (nums.length == 1) {

            return nums[0] == target ? 0 : -1;
        }

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {

//            (left + right) / 2;
            int mid = (right - left) / 2 + left;

            if (nums[mid] == target) {

                return mid;
            }


            if (target < nums[mid]) {

                if (nums[left] <= nums[mid] && target < nums[left]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else {

                if (nums[right] >= nums[mid] && target > nums[right]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }

            }
        }

        return -1;
    }


    public int search2(int[] nums, int target) {

        if (nums == null || nums.length == 0) {
            return -1;
        }

        if (nums.length == 1) {

            return nums[0] == target ? 0 : -1;
        }

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {

            int mid = (right - left) / 2 + left;

            if (nums[mid] == target) {
                return mid;
            }

            // [left, mid] 是有序
            if (nums[left] <= nums[mid]) {

                if (target >= nums[left] && target < nums[mid]) {

                    right = mid - 1;
                } else {

                    left = mid + 1;
                }
            } else {

                // [mid, right] 一定有序
                if (target <= nums[right] && target > nums[mid]) {
                    left = mid + 1;
                } else {

                    right = mid - 1;
                }
            }
        }


        return -1;
    }


    public static void main(String[] args) {

        System.out.println(new RotateHalf().search2(new int[]{4, 5, 6, 7, 0, 1, 2}, 3));


    }

}
