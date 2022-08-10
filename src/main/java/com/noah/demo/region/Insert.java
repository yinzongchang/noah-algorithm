package com.noah.demo.region;

import java.util.ArrayList;
import java.util.List;

/**
 * Title: Insert.java <br>
 * Description:             <br>
 * Copyright: Copyright (c) 2015<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author yinzo 2022/8/2
 */
public class Insert {


    public int[][] insert(int[][] intervals, int[] newInterval) {

        int left = newInterval[0];
        int right = newInterval[1];


        List<int[]> ansList = new ArrayList<>();

        boolean placed = false;

        for (int[] interval : intervals) {

            // 插入区间在 当前区间 的右侧，无交集
            if (left > interval[1]) {

                ansList.add(interval);
            } else if (right < interval[0]) {

                if (!placed) {

                    ansList.add(new int[]{left, right});
                    placed = true;
                }

                ansList.add(interval);
            } else {

                // 有交集
                left = Math.min(interval[0], left);
                right = Math.max(interval[1], right);
            }
        }

        if (!placed) {

            ansList.add(new int[]{left, right});
        }

        int[][] ans = new int[ansList.size()][2];

        for (int i = 0; i < ansList.size(); i++) {

            ans[i] = ansList.get(i);
        }

        return ans;
    }
}
