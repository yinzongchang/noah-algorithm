package com.noah.demo.window;

import java.util.HashSet;
import java.util.Set;

/**
 * Title: ContainsNearbyDuplicate.java <br>
 * Description:             <br>
 * Copyright: Copyright (c) 2015<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author yinzo 2022/7/28
 */
public class ContainsNearbyDuplicate {

    public boolean containsNearbyDuplicate(int[] nums, int k) {

        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {

            if (i > k) {

                set.remove(nums[i - k - 1]);
            }

            if (!set.add(nums[i])) {

                return true;
            }
        }

        return false;
    }

}
