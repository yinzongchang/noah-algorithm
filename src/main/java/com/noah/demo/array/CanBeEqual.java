package com.noah.demo.array;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Title: CanBeEqual.java <br>
 * Description:             <br>
 * Copyright: Copyright (c) 2015<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author yinzo 2022/8/24
 */
public class CanBeEqual {

    public boolean canBeEqual(int[] target, int[] arr) {

        if (target.length != arr.length) {
            return false;
        }

        Map<Integer, Integer> map1 = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();

        for (int t : target) {
            map1.put(t, map1.getOrDefault(t, 0) + 1);
        }

        for (int num : arr) {
            map2.put(num, map2.getOrDefault(num, 0) + 1);
        }

        if (map1.size() != map2.size()) {
            return false;
        }


        for (Map.Entry<Integer, Integer> entry : map1.entrySet()) {

            Integer key = entry.getKey();
            Integer value = entry.getValue();

            if (!map2.containsKey(key) || !Objects.equals(map2.getOrDefault(key, 0), value)) {
                return false;
            }
        }

        return true;
    }
}
