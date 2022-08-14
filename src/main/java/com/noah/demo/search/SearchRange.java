package com.noah.demo.search;

/**
 * Title: SearchRange.java <br>
 * Description:             <br>
 * Copyright: Copyright (c) 2015<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author yinzo 2022/8/11
 */
public class SearchRange {

    public int[] searchRange(int[] nums, int target) {


        int left = 0;
        int right = nums.length - 1;

        int ansLeft = -1;
        int ansRight = -1;


        while (left <= right) {

            if (nums[left] == target) {
                ansLeft = left;
            }

            if (nums[right] == target) {
                ansRight = right;
            }


            if (ansLeft != -1 && ansRight != -1) {
                break;
            }

            int mid = (left + right) / 2;

            if (nums[mid] < target) {
                left = mid;
            } else if (nums[mid] > target) {

                right = mid;
            } else {

                if (ansLeft == -1) {
                    ansLeft = mid;
                }

                if (ansRight == -1) {
                    ansRight = mid;
                }

                break;
            }

        }

        if (ansLeft != -1) {

            while (ansLeft > 0 && nums[ansLeft - 1] == target) {
                ansLeft--;
            }
        }

        if (ansRight != -1) {

            while (ansRight < nums.length - 1 && nums[ansRight + 1] == target) {
                ansRight++;
            }
        }


        return new int[]{ansLeft, ansRight};
    }


    public int[] searchRange2(int[] nums, int target) {

        int leftIdx = binarySearch(nums, target, true);
        int rightIdx = binarySearch(nums, target, false) - 1;


        if (leftIdx <= rightIdx && rightIdx < nums.length
                && nums[leftIdx] == target && nums[rightIdx] == target) {

            return new int[]{leftIdx, rightIdx};
        }
        return new int[]{-1, -1};
    }


    public int binarySearch(int[] nums, int target, boolean lower) {

        int left = 0;
        int right = nums.length - 1;

        int ans = nums.length;

        while (left <= right) {

            int mid = (left + right) / 2;

            if (nums[mid] > target || (lower && nums[mid] >= target)) {
                right = mid - 1;
                ans = mid;
            } else {
                left = mid + 1;
            }
        }

        return ans;
    }


}
