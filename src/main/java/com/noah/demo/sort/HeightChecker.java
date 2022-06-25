package com.noah.demo.sort;

/**
 * Title: HeightChecker.java <br>
 * Description:             <br>
 * Copyright: Copyright (c) 2015<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author yinzo 2022/6/13
 */
public class HeightChecker {

    public int heightChecker(int[] heights) {

        int[] arr = new int[101];

        for (int height : heights) {

            arr[height]++;
        }

        int count = 0;

        for (int i = 0, j = 0; i < arr.length; i++) {

            while (arr[i] > 0) {

                if (i != heights[j]) {
                    count++;
                }
                j++;
                arr[i]--;
            }
        }

        return count;
    }

}
