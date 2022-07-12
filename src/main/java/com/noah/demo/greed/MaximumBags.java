package com.noah.demo.greed;

import java.util.Arrays;

/**
 * Title: MaximumBags.java <br>
 * Description:             <br>
 * Copyright: Copyright (c) 2015<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author yinzo 2022/7/4
 */
public class MaximumBags {

    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {

        int len = capacity.length;

        int[] addArray = new int[len];

        for (int i = 0; i < len; i++) {

            addArray[i] = capacity[i] - rocks[i];
        }

        Arrays.sort(addArray);

        int ans = 0;

        for (int add : addArray) {

            additionalRocks -= add;
            if (additionalRocks < 0) {
                break;
            }

            ans++;
        }

        return ans;
    }
}
