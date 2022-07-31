package com.noah.demo.hash;

import java.util.HashMap;
import java.util.Map;

/**
 * Title: CountNums.java <br>
 * Description:             <br>
 * Copyright: Copyright (c) 2015<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author yinzo 2022/7/27
 */
public class CountNums {

    public int majorityElement(int[] nums) {


        Map<Integer, Integer> counts = new HashMap<>();
        for (int num : nums) {
            if (!counts.containsKey(num)) {
                counts.put(num, 1);
            } else {
                counts.put(num, counts.get(num) + 1);
            }
        }

        Map.Entry<Integer, Integer> majorityEntry = null;

        for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {

            if (majorityEntry == null || majorityEntry.getValue() < entry.getValue()) {
                majorityEntry = entry;
            }
        }

        return majorityEntry.getKey();
    }

}
