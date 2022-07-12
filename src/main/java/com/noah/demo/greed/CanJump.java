package com.noah.demo.greed;

/**
 * Title: CanJump.java <br>
 * Description:             <br>
 * Copyright: Copyright (c) 2015<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author yinzo 2022/6/27
 */
public class CanJump {

    public boolean canJump(int[] nums) {

        if (nums == null || nums.length <= 1) {
            return true;
        }

        int maxIndex = 0;

        for (int i = 0; i < nums.length; i++) {

            // 表示 i 可达
            if (maxIndex >= i) {

                maxIndex = Math.max(maxIndex, i + nums[i]);

                if (maxIndex >= nums.length - 1) {
                    return true;
                }

            }
        }

        return false;
    }

}
