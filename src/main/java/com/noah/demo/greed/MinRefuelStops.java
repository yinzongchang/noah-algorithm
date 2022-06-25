package com.noah.demo.greed;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Title: MinRefuelStops.java <br>
 * Description:             <br>
 * Copyright: Copyright (c) 2015<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author yinzo 2022/6/25
 */
public class MinRefuelStops {

    public int minRefuelStops(int target, int startFuel, int[][] stations) {

        if (startFuel >= target) {
            return 0;
        }

        // 定义大根堆
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        // 加油站个数
        int n = stations.length;

        // 当前到达的位置
        int currReach = startFuel;


        // 当前到达加油站
        int currIndex = 0;

        // 需要加油的次数
        int ans = 0;

        while (currReach < target) {

            // 当前到达站点小于加油站个数
            // 加油站位置，小于等于当前能到达距离才有效
            while (currIndex < n && stations[currIndex][0] <= currReach) {

                priorityQueue.offer(stations[currIndex][1]);
                currIndex++;
            }


            if (priorityQueue.isEmpty()) {
                return -1;
            }

            // 弹出最大值
            int step = priorityQueue.poll();

            currReach += step;
            ans++;
        }

        return ans;
    }
}
