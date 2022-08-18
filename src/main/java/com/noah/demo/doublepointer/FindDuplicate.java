package com.noah.demo.doublepointer;

/**
 * Title: FindDuplicate.java <br>
 * Description:             <br>
 * Copyright: Copyright (c) 2015<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author yinzo 2022/8/15
 */
public class FindDuplicate {

    /**
     * 287. 寻找重复数
     * <p>
     * 给定一个包含 n + 1 个整数的数组 nums ，其数字都在 [1, n] 范围内（包括 1 和 n），可知至少存在一个重复的整数。
     * <p>
     * 假设 nums 只有 一个重复的整数 ，返回 这个重复的数 。
     * <p>
     * 你设计的解决方案必须 不修改 数组 nums 且只用常量级 O(1) 的额外空间。
     * <p>
     * 示例 1：
     * 输入：nums = [1,3,4,2,2]
     * 输出：2
     * <p>
     * 示例 2：
     * 输入：nums = [3,1,3,4,2]
     * 输出：3
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/find-the-duplicate-number
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param nums
     * @return
     */
    public int findDuplicate(int[] nums) {

        int slow = 0;
        int fast = 0;

        slow = nums[slow];
        fast = nums[nums[fast]];

        while (slow != fast) {

            slow = nums[slow];
            fast = nums[nums[fast]];
        }

        int pre1 = 0;
        int pre2 = slow;

        while (pre1 != pre2) {
            pre1 = nums[pre1];
            pre2 = nums[pre2];
        }

        return pre1;
    }

}
