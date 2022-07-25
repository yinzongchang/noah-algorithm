package com.noah.demo.array;

/**
 * Title: DistanceBetweenBusStops.java <br>
 * Description:             <br>
 * Copyright: Copyright (c) 2015<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author yinzo 2022/7/24
 */
public class DistanceBetweenBusStops {

    public int distanceBetweenBusStops(int[] distance, int start, int destination) {

        if (start > destination) {

            int tmp = start;
            start = destination;
            destination = tmp;
        }


        int sum1 = 0;
        int sum2 = 0;

        for (int i = 0; i < distance.length; i++) {

            if (i >= start && i < destination) {
                sum1 += distance[i];
            } else {
                sum2 += distance[i];
            }
        }

        return Math.min(sum1, sum2);
    }

}
