package com.noah.demo.array;

/**
 * Title: Trap.java <br>
 * Description:             <br>
 * Copyright: Copyright (c) 2015<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author yinzo 2022/5/13
 */
public class Trap {


    public int trap(int[] height) {

        int left = 0;
        int right = height.length - 1;

        int leftMax = 0;
        int rightMax = 0;

        int result = 0;

        while (left < right) {


            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);

            if (height[left] < height[right]) {

                result = result + (leftMax - height[left]);
                left++;

            } else {

                result = result + (rightMax - height[right]);
                right--;

            }
        }

        return result;
    }

}
