package com.noah.demo.treemap;

import java.util.Map;
import java.util.TreeMap;

/**
 * Title: MyCalendar.java <br>
 * Description:             <br>
 * Copyright: Copyright (c) 2015<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author yinzo 2022/7/6
 */
public class MyCalendar {

    TreeMap<Integer, Integer> treeMap;

    public MyCalendar() {

        treeMap = new TreeMap<>();
    }


    /**
     * 添加区间
     *
     * @param start
     * @param end
     * @return
     */
    public boolean book(int start, int end) {

//        if (treeMap.isEmpty()) {
//            treeMap.put(start, end);
//            return true;
//        }

        // 1. 现有区间中存在，与新预订区间的开始时间start是相同的，这肯定无法订了
        if (treeMap.containsKey(start)) {
            return false;
        }

        // 2. 对于开始时间小于start的区间，如果存在结束时间大于start，则不可预订
        // key小于start并最接近start
        Map.Entry<Integer, Integer> floor = treeMap.floorEntry(start);
        if (floor != null && floor.getValue() > start) {
            return false;
        }

        // 3. 对于开始时间大于start的区间，如果存在开始时间小于end，不可预订
        // key 大于start并最接近start
        Map.Entry<Integer, Integer> celling = treeMap.ceilingEntry(start);
        if (celling != null && celling.getKey() < end) {
            return false;
        }

        treeMap.put(start, end);
        return true;
    }
}
