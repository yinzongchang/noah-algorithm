package com.noah.demo.dynamic;

/**
 * Title: Rob2.java <br>
 * Description:             <br>
 * Copyright: Copyright (c) 2015<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author yinzo 2022/7/14
 */
public class Rob2 {

    /**
     * 213. 打家劫舍 II
     * 你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都 围成一圈 ，
     * 这意味着第一个房屋和最后一个房屋是紧挨着的。同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警 。
     * <p>
     * 给定一个代表每个房屋存放金额的非负整数数组，计算你 在不触动警报装置的情况下 ，今晚能够偷窃到的最高金额。
     * <p>
     * 示例1：
     * <p>
     * 输入：nums = [2,3,2]
     * 输出：3
     * 解释：你不能先偷窃 1 号房屋（金额 = 2），然后偷窃 3 号房屋（金额 = 2）, 因为他们是相邻的。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/house-robber-ii
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public int rob(int[] nums) {

        if (nums == null || nums.length == 0) {
            return 0;
        }

        int len = nums.length;

        if (len == 1) {
            return nums[0];
        }

        int[][] dp1 = new int[len - 1][2];
        int[][] dp2 = new int[len - 1][2];


        // 1. 最后一个不打劫
        dp1[0][0] = 0;
        dp1[0][1] = nums[0];
        for (int i = 1; i < len - 1; i++) {

            dp1[i][0] = Math.max(dp1[i - 1][0], dp1[i - 1][1]);
            dp1[i][1] = dp1[i - 1][0] + nums[i];
        }

        // 2. 第一家不打劫
        dp2[0][0] = 0;
        dp2[0][1] = nums[1];

        for (int i = 2; i < len; i++) {

            dp2[i - 1][0] = Math.max(dp2[i - 2][0], dp2[i - 2][1]);
            dp2[i - 1][1] = dp2[i - 2][0] + nums[i];
        }


        return Math.max(
                Math.max(dp1[len - 2][0], dp1[len - 2][1]),
                Math.max(dp2[len - 2][0], dp2[len - 2][1]));

    }


}
