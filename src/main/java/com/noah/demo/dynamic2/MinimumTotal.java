package com.noah.demo.dynamic2;

import java.util.ArrayList;
import java.util.List;

/**
 * Title: MinimumTotal.java <br>
 * Description:             <br>
 * Copyright: Copyright (c) 2015<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author yinzo 2022/8/9
 */
public class MinimumTotal {

    /**
     * 给定一个三角形 triangle ，找出自顶向下的最小路径和。
     *
     * 每一步只能移动到下一行中相邻的结点上。相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。
     * 也就是说，如果正位于当前行的下标 i ，那么下一步可以移动到下一行的下标 i 或 i + 1 。
     *
     * 输入：triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
     * 输出：11
     * 解释：如下面简图所示：
     *    2
     *   3 4
     *  6 5 7
     * 4 1 8 3
     * 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
     *
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/triangle
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public int minimumTotal(List<List<Integer>> triangle) {

        if (triangle == null || triangle.size() == 0) {
            return 0;
        }

        List<List<Integer>> dpList = new ArrayList<>();
        dpList.add(triangle.get(0));


        for (int i = 1; i < triangle.size(); i++) {

            List<Integer> list = triangle.get(i);

            List<Integer> dpPre = dpList.get(i - 1);

            List<Integer> dp = new ArrayList<>(list.size());

            for (int j = 0; j < list.size(); j++) {

                if (j == 0) {
                    dp.add(dpPre.get(0) + list.get(0));
                    continue;
                }

                if (j == list.size() - 1) {

                    dp.add(dpPre.get(dpPre.size() - 1) + list.get(j));
                    continue;
                }

                Integer min = Math.min(dpPre.get(j), dpPre.get(j - 1)) + list.get(j);
                dp.add(min);
            }

            dpList.add(dp);
        }

        List<Integer> dpAns = dpList.get(dpList.size() - 1);

        int ans = dpAns.get(0);

        for (int i = 1; i < dpAns.size(); i++) {

            ans = Math.min(ans, dpAns.get(i));
        }

        return ans;
    }


}
