package com.noah.demo.topology;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

/**
 * Title: SequenceReconstruction.java <br>
 * Description:             <br>
 * Copyright: Copyright (c) 2015<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author yinzo 2022/7/23
 */
public class SequenceReconstruction {

    /**
     * 作者：LeetCode-Solution
     * 链接：https://leetcode.cn/problems/ur2n8P/solution/zhong-jian-xu-lie-by-leetcode-solution-urxc/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     * @param nums
     * @param sequences
     * @return
     */
    public boolean sequenceReconstruction(int[] nums, int[][] sequences) {

        int n = nums.length;

        // 计算入度
        int[] indegrees = new int[n + 1];

        // 存储有向图的边
        Set<Integer>[] graph = new Set[n + 1];

        for (int i = 1; i <= n; i++) {

            graph[i] = new HashSet<>();
        }

        for (int[] sequence : sequences) {

            int size = sequence.length;

            for (int i = 1; i < size; i++) {

                int prev = sequence[i - 1];
                int next = sequence[i];

                if (graph[prev].add(next)) {
                    indegrees[next]++;
                }
            }
        }

        Queue<Integer> queue = new ArrayDeque<Integer>();

        for (int i = 1; i <= n; i++) {
            if (indegrees[i] == 0) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {

            if (queue.size() > 1) {
                return false;
            }

            int num = queue.poll();

            Set<Integer> set = graph[num];
            for (int next : set) {
                indegrees[next]--;
                if (indegrees[next] == 0) {
                    queue.offer(next);
                }
            }
        }

        return true;
    }

}
