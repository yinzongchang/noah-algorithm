package com.noah.demo.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Title: MinSubsequence.java <br>
 * Description:             <br>
 * Copyright: Copyright (c) 2015<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author yinzo 2022/8/4
 */
public class MinSubsequence {


    public List<Integer> minSubsequence(int[] nums) {

        int total = Arrays.stream(nums).sum();
        Arrays.sort(nums);

        List<Integer> ans = new ArrayList<>();

        int currSum = 0;

        for (int i = nums.length - 1; i >= 0; i--) {

            currSum += nums[i];

            ans.add(nums[i]);

            if (currSum > total - currSum) {
                break;
            }
        }

        return ans;
    }

}
