package com.noah.demo.greed;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Title: EraseOverlapIntervals.java <br>
 * Description:             <br>
 * Copyright: Copyright (c) 2015<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author yinzo 2022/6/29
 */
public class EraseOverlapIntervals {

    public int eraseOverlapIntervals(int[][] intervals) {


        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });

        int len = intervals.length;

        // 有效的区间
        int x = 1;

        int right = intervals[0][1];

        for (int i = 1; i < len; i++) {

            if (intervals[i][0] >= right) {

                x++;
                right = intervals[i][1];
            }
        }


        return len - x;

    }

}
