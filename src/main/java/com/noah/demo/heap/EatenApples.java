package com.noah.demo.heap;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Title: EatenApples.java <br>
 * Description:             <br>
 * Copyright: Copyright (c) 2015<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author yinzo 2022/9/4
 */
public class EatenApples {


    /**
     * 1705. 吃苹果的最大数目
     * <p>
     * 有一棵特殊的苹果树，一连 n 天，每天都可以长出若干个苹果。在第 i 天，树上会长出 apples[i] 个苹果，
     * 这些苹果将会在 days[i] 天后（也就是说，第 i + days[i] 天时）腐烂，变得无法食用。
     * 也可能有那么几天，树上不会长出新的苹果，此时用 apples[i] == 0 且 days[i] == 0 表示。
     * <p>
     * 你打算每天 最多 吃一个苹果来保证营养均衡。注意，你可以在这 n 天之后继续吃苹果。
     * 给你两个长度为 n 的整数数组 days 和 apples ，返回你可以吃掉的苹果的最大数目。
     * <p>
     * https://leetcode.cn/problems/maximum-number-of-eaten-apples/
     *
     * @return
     */
    public int eatenApples(int[] apples, int[] days) {

        int ans = 0;

        // 优先队列 - 按失效时间
        // 数组 0: 失效时间 1: 剩余数量
        Queue<int[]> priorityQueue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        int len = apples.length;

        for (int i = 0; i < len; i++) {

            while (!priorityQueue.isEmpty() && (priorityQueue.peek()[0] <= i || priorityQueue.peek()[1] <= 0)) {
                priorityQueue.poll();
            }


            // i 天收获的苹果大于 0
            if (apples[i] > 0) {

                int rottenDay = i + days[i];
                priorityQueue.offer(new int[]{rottenDay, apples[i]});
            }

            // 队列为空，这一天没有苹果吃了
            if (priorityQueue.isEmpty()) {
                continue;
            }

            int[] appleNode = priorityQueue.peek();
            appleNode[1]--;
            ans++;

            if (appleNode[1] == 0) {
                priorityQueue.poll();
            }
        }

        int i = len;

        while (!priorityQueue.isEmpty()) {

            while (!priorityQueue.isEmpty() && priorityQueue.peek()[0] <= i) {
                priorityQueue.poll();
            }

            if (priorityQueue.isEmpty()) {
                break;
            }

            int[] appleNode = priorityQueue.poll();

            int num = Math.min(appleNode[0] - i, appleNode[1]);

            // 下次的起点后移 num
            i += num;

            ans += num;
        }

        return ans;
    }


}
