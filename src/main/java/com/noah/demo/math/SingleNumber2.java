package com.noah.demo.math;

/**
 * Title: SingleNumber2.java <br>
 * Description:             <br>
 * Copyright: Copyright (c) 2015<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author yinzo 2022/7/17
 */
public class SingleNumber2 {

    /**
     * 给你一个整数数组 nums ，除某个元素仅出现 一次 外，其余每个元素都恰出现 三次 。请你找出并返回那个只出现了一次的元素。
     * <p>
     * 示例 1：
     * <p>
     * 输入：nums = [2,2,3,2]
     * 输出：3
     * 示例 2：
     * <p>
     * 输入：nums = [0,1,0,1,0,1,100]
     * 输出：100
     *
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {


        int ans = 0;

        // int 32 位计算
        for (int i = 0; i < 32; i++) {

            int cnt = 0;

            for (int num : nums) {

                cnt += (num >> i) & 1;
            }

            if (cnt % 3 != 0) {

                ans |= 1 << i;
            }

        }

        return ans;
    }

}
