package com.noah.demo.window;

import java.util.TreeSet;

/**
 * Title: ContainsNearbyAlmostDuplicate.java <br>
 * Description:             <br>
 * Copyright: Copyright (c) 2015<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author yinzo 2022/8/21
 */
public class ContainsNearbyAlmostDuplicate {

    /**
     * 220. 存在重复元素 III
     *
     * 给你一个整数数组 nums 和两个整数 k 和 t 。请你判断是否存在 两个不同下标 i 和 j，使得 abs(nums[i] - nums[j]) <= t ，同时又满足 abs(i - j) <= k 。
     *
     * 如果存在则返回 true，不存在返回 false。
     *
     * 示例 1：
     *
     * 输入：nums = [1,2,3,1], k = 3, t = 0
     * 输出：true
     * 示例 2：
     *
     * 输入：nums = [1,0,1,1], k = 1, t = 2
     * 输出：true
     *
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/contains-duplicate-iii
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param nums
     * @param k
     * @param t
     * @return
     */
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {

        int length = nums.length;

        TreeSet<Long> treeSet = new TreeSet<>();

        for (int i = 0; i < length; i++) {

            Long num = nums[i] * 1L;

            // 从 ts 中找到小于等于 u 的最大值（小于等于 u 的最接近 u 的数）
            Long left = treeSet.floor(num);

            // 从 ts 中找到大于等于 u 的最小值（大于等于 u 的最接近 u 的数）
            Long right = treeSet.ceiling(num);

            if (left != null && num - left <= t) {
                return true;
            }

            if (right != null && right - num <= t) {
                return true;
            }

            // 将当前数加到 ts 中，并移除下标范围不在 [max(0, i - k), i) 的数（维持滑动窗口大小为 k）
            treeSet.add(num);

            if (i >= k) {
                treeSet.remove(nums[i - k] * 1L);
            }
        }

        return false;
    }

}
