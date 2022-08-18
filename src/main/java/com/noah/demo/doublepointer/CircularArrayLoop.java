package com.noah.demo.doublepointer;

/**
 * Title: CircularArrayLoop.java <br>
 * Description:             <br>
 * Copyright: Copyright (c) 2015<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author yinzo 2022/8/17
 */
public class CircularArrayLoop {

    /**
     * 457. 环形数组是否存在循环
     *
     * https://leetcode.cn/problems/circular-array-loop/
     *
     * @param nums
     * @return
     */
    public boolean circularArrayLoop(int[] nums) {

        if (nums == null || nums.length <= 1) {
            return false;
        }

        int n = nums.length;

        for (int i = 0; i < n; i++) {

            if (nums[i] == 0) {
                continue;
            }

            int slow = i;
            int fast = next(nums, i);

            // 判断非零且方向相同
            while (nums[slow] * nums[fast] > 0
                    && nums[slow] * nums[next(nums, fast)] > 0) {

                if (slow == fast) {

                    // 判断长度大于1
                    if (slow != next(nums, slow)) {
                        return true;
                    } else {
                        break;
                    }
                }

                slow = next(nums, slow);
                fast = next(nums, next(nums, fast));
            }

            int add = i;

            while (nums[add] * nums[next(nums, add)] > 0) {

                int tmp = add;
                add = next(nums, add);
                nums[tmp] = 0;
            }
        }


        return false;
    }

    public int next(int[] nums, int curr) {

        int n = nums.length;

        // +n 为了保证 [0, n)
        curr = ((curr + nums[curr]) % n + n) % n;

        return curr;
    }


}
