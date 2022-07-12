package com.noah.demo.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Title: MinimumAbsDifference.java <br>
 * Description:             <br>
 * Copyright: Copyright (c) 2015<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author yinzo 2022/7/4
 */
public class MinimumAbsDifference {


    public List<List<Integer>> minimumAbsDifference(int[] arr) {

        Arrays.sort(arr);
        List<List<Integer>> ans = new ArrayList<>();

        int min = arr[1] - arr[0];

        for (int i = 0; i < arr.length - 1; i++) {

            int curr = arr[i + 1] - arr[i];
            if (curr < min) {

                ans.clear();
                min = curr;
            }

            if (curr == min) {

                List<Integer> temp = new ArrayList<>();
                temp.add(arr[i]);
                temp.add(arr[i + 1]);
                ans.add(temp);
            }
        }

        return ans;
    }
}
