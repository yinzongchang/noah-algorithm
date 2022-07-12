package com.noah.demo.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Title: Merge.java <br>
 * Description:             <br>
 * Copyright: Copyright (c) 2015<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author yinzo 2022/7/1
 */
public class Merge {

    public int[][] merge(int[][] intervals) {

        if (intervals.length == 0) {
            return new int[0][2];
        }

        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });


        List<int[]> merge = new ArrayList<>();

        for (int i = 0; i < intervals.length; i++) {

            int left = intervals[i][0];
            int right = intervals[i][1];

            if (merge.isEmpty() || merge.get(merge.size() - 1)[1] < left) {

                merge.add(new int[]{left, right});
            } else {

                int[] last = merge.get(merge.size() - 1);

                last[1] = Math.max(last[1], right);
            }
        }

        return merge.toArray(new int[merge.size()][]);
    }

}
