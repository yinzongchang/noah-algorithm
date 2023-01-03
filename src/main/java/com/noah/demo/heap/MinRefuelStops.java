package com.noah.demo.heap;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Title: MinRefuelStops.java <br>
 * Description:             <br>
 * Copyright: Copyright (c) 2015<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author yinzo 2022/9/4
 */
public class MinRefuelStops {


    /**
     * 871. 最低加油次数
     * <p>
     * 汽车从起点出发驶向目的地，该目的地位于出发位置东面 target 英里处。
     * 沿途有加油站，每个 station[i] 代表一个加油站，它位于出发位置东面 station[i][0] 英里处，并且有 station[i][1] 升汽油。
     * 假设汽车油箱的容量是无限的，其中最初有 startFuel 升燃料。它每行驶 1 英里就会用掉 1 升汽油。
     * 当汽车到达加油站时，它可能停下来加油，将所有汽油从加油站转移到汽车中。
     * 为了到达目的地，汽车所必要的最低加油次数是多少？如果无法到达目的地，则返回 -1 。
     * <p>
     * 注意：如果汽车到达加油站时剩余燃料为 0，它仍然可以在那里加油。如果汽车到达目的地时剩余燃料为 0，仍然认为它已经到达目的地。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/minimum-number-of-refueling-stops
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public int minRefuelStops(int target, int startFuel, int[][] stations) {


        // 加油次数
        int ans = 0;

        int len = stations.length;

        // 当前能够到达的位置
        int currReach = startFuel;

        // 存放已经经过的 加油站大小
        Queue<int[]> priorityQueue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[1] - o1[1];
            }
        });

        // 加油站下标
        int stationIndex = 0;

        while (currReach < target) {

            // 能够到达加油站位置
            while (stationIndex < len && currReach >= stations[stationIndex][0]) {

                priorityQueue.offer(stations[stationIndex]);
                stationIndex++;
            }

            // 终止条件
            if (priorityQueue.isEmpty()) {

                return -1;
            }

            // 优先队列中获取最大油量
            int[] station = priorityQueue.poll();
            currReach += station[1];
            ans++;
        }

        return ans;
    }
}
