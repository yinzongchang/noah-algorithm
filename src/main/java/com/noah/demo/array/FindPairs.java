package com.noah.demo.array;

import java.util.HashSet;
import java.util.Set;

/**
 * Title: FindPairs.java <br>
 * Description:             <br>
 * Copyright: Copyright (c) 2015<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author yinzo 2022/6/16
 */
public class FindPairs {

    public int findPairs(int[] nums, int k) {


        Set<Integer> visitedSet = new HashSet<>();
        Set<Integer> resultSet = new HashSet<>();

        for (int num : nums) {

            if (visitedSet.contains(num - k)) {
                resultSet.add(num - k);
            }

            if (visitedSet.contains(num + k)) {
                resultSet.add(num);
            }

            visitedSet.add(num);
        }

        return resultSet.size();
    }

}
