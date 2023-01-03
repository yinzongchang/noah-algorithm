package com.noah.demo.greed;

/**
 * Title: CanCompleteCircuit.java <br>
 * Description:             <br>
 * Copyright: Copyright (c) 2015<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author yinzo 2022/9/4
 */
public class CanCompleteCircuit {

    /**
     * 134. 加油站
     * 
     * 在一条环路上有 n 个加油站，其中第 i 个加油站有汽油 gas[i] 升。
     * 你有一辆油箱容量无限的的汽车，从第 i 个加油站开往第 i+1 个加油站需要消耗汽油 cost[i] 升。你从其中的一个加油站出发，开始时油箱为空。
     * 给定两个整数数组 gas 和 cost ，如果你可以绕环路行驶一周，则返回出发时加油站的编号，否则返回 -1 。如果存在解，则 保证 它是 唯一 的。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/gas-station
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * 
     * @param gas
     * @param cost
     * @return
     */
    public int canCompleteCircuit(int[] gas, int[] cost) {

        // 油量总和
        int sum = 0;

        // 当前油量和
        int currSum = 0;

        int start = 0;

        for (int i = 0; i < gas.length; i++) {

            sum += gas[i] - cost[i];

            currSum += gas[i] - cost[i];

            if (currSum < 0) {

                // 起点就是当前节点的后一位
                start = i + 1;
                currSum = 0;
            }
        }

        if (sum < 0) {
            return -1;
        }

        return start;
    }
    
}
