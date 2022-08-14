package com.noah.demo.map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Title: GroupThePeople.java <br>
 * Description:             <br>
 * Copyright: Copyright (c) 2015<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author yinzo 2022/8/12
 */
public class GroupThePeople {


    /**
     * 输入：groupSizes = [3,3,3,3,3,1,3]
     * 输出：[[5],[0,1,2],[3,4,6]]
     *
     * @param groupSizes
     * @return
     */
    public List<List<Integer>> groupThePeople(int[] groupSizes) {

        List<List<Integer>> ans = new ArrayList<>();

        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < groupSizes.length; i++) {

            if (groupSizes[i] < 1) {
                return new ArrayList<>();
            }

            if (groupSizes[i] == 1) {

                List<Integer> subList = new ArrayList<>(1);
                subList.add(i);
                ans.add(subList);
                continue;
            }

            int key = groupSizes[i];

            List<Integer> subList = map.getOrDefault(key, new ArrayList<>());
            if (subList.size() < key) {
                subList.add(i);
                map.put(key, subList);
            }

            if (subList.size() == key) {
                ans.add(subList);
                map.remove(key);
            }
        }

        if (!map.isEmpty()) {
            return new ArrayList<>();
        }

        return ans;
    }


}
