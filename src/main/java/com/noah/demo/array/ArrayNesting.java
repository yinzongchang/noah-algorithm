package com.noah.demo.array;

import java.util.HashSet;
import java.util.Set;

/**
 * Title: ArrayNesting.java <br>
 * Description:             <br>
 * Copyright: Copyright (c) 2015<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author yinzo 2022/7/17
 */
public class ArrayNesting {


    public int arrayNesting(int[] nums) {


        int ans = 0;

        for (int i = 0; i < nums.length; i++) {


            Set<Integer> set = new HashSet<>();

            int curr = nums[i];
            while (!set.contains(curr)) {

                set.add(curr);

                curr = nums[curr];
            }

            ans = Math.max(ans, set.size());
        }

        return ans;
    }


    // 数字互不相同，所以不会重复
    public int arrayNesting2(int[] nums) {

        int ans = 0;

        int len = nums.length;
        boolean[] visit = new boolean[len];

        for (int i = 0; i < len; i++) {

            int x = i;

            int value = 0;
            while (!visit[x]) {

                visit[x] = true;
                x = nums[x];
                value++;
            }

            ans = Math.max(ans, value);
        }

        return ans;
    }

}
