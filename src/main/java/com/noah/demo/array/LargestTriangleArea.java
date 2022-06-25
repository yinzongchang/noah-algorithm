package com.noah.demo.array;

/**
 * Title: LargestTriangleArea.java <br>
 * Description:             <br>
 * Copyright: Copyright (c) 2015<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author yinzo 2022/5/15
 */
public class LargestTriangleArea {

    public double largestTriangleArea(int[][] points) {

        int n = points.length;

        double result = 0;

        // 坐标1
        for (int i = 0; i < n; i++) {

            // 坐标2
            for (int j = i + 1; j < n; j++) {

                // 坐标3
                for (int k = j + 1; k < n; k++) {

                    result = Math.max(triangleArea(points[i][0], points[i][1], points[j][0], points[j][1], points[k][0], points[k][1]), result);
                }

            }

        }

        return result;
    }

    public double triangleArea(int x1, int y1, int x2, int y2, int x3, int y3) {
        return 0.5 * Math.abs(x1 * y2 + x2 * y3 + x3 * y1 - x1 * y3 - x2 * y1 - x3 * y2);
    }
}
