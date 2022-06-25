package com.noah.demo.array;

/**
 * Title: MaxArea.java <br>
 * Description:             <br>
 * Copyright: Copyright (c) 2015<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author yinzo 2022/5/10
 */
public class MaxArea {



    public int maxArea(int[] height) {


        int i = 0;
        int j = height.length - 1;


        int result = 0;


        while (i < j) {


            result = Math.max(result, (j - i) * Math.min(height[i], height[j]));

            if (height[i] < height[j]) {
                i++;

                while (i < j && height[i] < height[i-1]) {
                    i++;
                }

            } else {
                j--;

                while (i < j && height[j+1] > height[j]) {
                    j--;
                }
            }
        }

        return result;
    }


}
