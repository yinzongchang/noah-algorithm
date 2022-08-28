package com.noah.demo.array;

import java.util.HashSet;
import java.util.Set;

/**
 * Title: LongestConsecutive.java <br>
 * Description:             <br>
 * Copyright: Copyright (c) 2015<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author yinzo 2022/8/28
 */
public class LongestConsecutive {


    /**
     * 128. 最长连续序列
     * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
     * 请你设计并实现时间复杂度为 O(n) 的算法解决此问题。
     * <p>
     * 示例 1：
     * <p>
     * 输入：nums = [100,4,200,1,3,2]
     * 输出：4
     * 解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/longest-consecutive-sequence
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param nums
     * @return
     */
    public int longestConsecutive(int[] nums) {

        if (nums == null || nums.length == 0) {
            return 0;
        }

        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }


        // 最长序列
        int maxLen = 0;

        for (int i = 0; i < nums.length; i++) {


            // 包括 前一个数字，不是最长，直接跳过
            if (set.contains(nums[i] - 1)) {
                continue;
            }

            int currentLen = 1;
            int currentNum = nums[i];

            while (set.contains(currentNum + 1)) {

                currentLen++;
                currentNum++;

            }

            maxLen = Math.max(maxLen, currentLen);
        }

        return maxLen;
    }

}
