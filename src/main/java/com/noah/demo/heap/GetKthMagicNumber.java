package com.noah.demo.heap;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * Title: GetKthMagicNumber.java <br>
 * Description:             <br>
 * Copyright: Copyright (c) 2015<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author yinzo 2022/9/28
 */
public class GetKthMagicNumber {


    /**
     * 面试题 17.09. 第 k 个数
     * <p>
     * 有些数的素因子只有 3，5，7，请设计一个算法找出第 k 个数。注意，不是必须有这些素因子，而是必须不包含其他的素因子。例如，前几个数按顺序应该是 1，3，5，7，9，15，21。
     * <p>
     * 示例 1:
     * 输入: k = 5
     * 输出: 9
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/get-kth-magic-number-lcci
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param k
     * @return
     */
    public int getKthMagicNumber(int k) {

        int[] factors = {3, 5, 7};

        Set<Long> seen = new HashSet<>();

        PriorityQueue<Long> priorityQueue = new PriorityQueue<>();

        seen.add(1L);
        priorityQueue.offer(1L);

        int magic = 0;

        for (int i = 0; i < k; i++) {

            long curr = priorityQueue.poll();
            magic = (int) curr;

            for (int factor : factors) {

                long next = factor * curr;
                if (seen.add(next)) {
                    priorityQueue.offer(next);
                }
            }
        }

        return magic;
    }

}
