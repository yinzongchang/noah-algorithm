package com.noah.demo.heap;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Title: FurthestBuilding.java <br>
 * Description:             <br>
 * Copyright: Copyright (c) 2015<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author yinzo 2022/9/4
 */
public class FurthestBuilding {


    /**
     *
     * 1642. 可以到达的最远建筑
     * https://leetcode.cn/problems/furthest-building-you-can-reach/
     *
     * 例 2：跳跃游戏
     *
     * 【题目】假设你正在玩跳跃游戏，从低处往高处跳的时候，可以有两种方法。
     * 方法一：塞砖块，但是你拥有砖块数是有限制的。为了简单起见，高度差就是你需要砖块数。
     * 方法二：用梯子，梯子可以无视高度差（你可以认为再高也能爬上去），但是梯子的个数是有限的(一个只能用一次)。
     *
     * 其他无论是平着跳，还是从高处往低处跳，不需要借助什么就可以完成（在这道题中我们默认无论从多高跳下来，也摔不死）。
     * 给你一个数组，用来表示不同的高度。假设你总是站在 index = 0 的高度开始。那么请问，你最远能跳到哪里?
     *
     * 输入：[3, 1, 6, 20, 10, 20], bricks = 5, landers = 1
     * 输出：4
     *
     * 解释：
     * Step 1. 从 3 跳到 1 时，因为是从高往低处跳，直接跳就可以了
     * Step 2. 从 1 到 6 时，用掉 5 个砖块
     * Step 3. 从 6 到 20 时，用掉梯子
     * Step 4. 从 20 到 10 可以直接跳
     * Step 5.到 10 这里就停住了，没有东西可以帮助你跳到 20 了，所以只能跳到下标 index = 4 这里。
     *
     */
    public int furthestBuilding(int[] heights, int bricks, int ladders) {

        // 注意处理非法输入
        if (heights == null || heights.length == 0) {
            return -1;
        }


        // 优先队列
        Queue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        // 已使用砖块数量
        int doneBricks = 0;

        // 能走到最后一个位置
        int lastIndex = 0;

        // 上一次的高度 - 为了计算落差使用
        int preHeight = heights[0];

        for (int i = 1; i < heights.length; i++) {

            // 平跳或者往低跳
            if (heights[i] <= preHeight) {

                preHeight = heights[i];
                lastIndex = i;
                continue;
            }

            // 向上跳 - 高度差
            final int delta = heights[i] - preHeight;

            // 高度差入队
            priorityQueue.offer(delta);

            doneBricks += delta;

            // 已使用砖块数量大于
            while (doneBricks > bricks && ladders > 0) {

                // 优先取最大高度差 - 砖块数量保证了队列不为空
                doneBricks -= priorityQueue.poll();
                ladders--;
            }

            if (doneBricks <= bricks) {

                lastIndex = i;
            } else {

                break;
            }

            preHeight = heights[i];
        }

        return lastIndex;
    }

}
