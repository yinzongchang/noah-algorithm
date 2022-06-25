package com.noah.demo.array;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Title: SpiralOrder.java <br>
 * Description:             <br>
 * Copyright: Copyright (c) 2015<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author yinzo 2022/6/13
 */
public class SpiralOrder {


    public List<Integer> spiralOrder(int[][] matrix) {

        int top = 0;
        int bottom = matrix.length - 1;

        int[] arr = matrix[0];

        int left = 0;
        int right = arr.length - 1;

        List<Integer> result = new ArrayList<>();

        while (top <= bottom && left <= right) {

            for (int i = left; i <= right; i++) {

                result.add(matrix[top][i]);
            }

            for (int i = top + 1; i <= bottom; i++) {

                result.add(matrix[i][right]);
            }

            if (left < right && top < bottom) {

                for (int i = right - 1; i >= left; i--) {
                    result.add(matrix[bottom][i]);
                }

                for (int i = bottom - 1; i >= top + 1; i--) {

                    result.add(matrix[i][left]);
                }

            }

            top++;
            right--;
            bottom--;
            left++;
        }


        return result;
    }


    @Test
    public void test() {

        int[][] arr = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};

        System.out.println(new SpiralOrder().spiralOrder(arr));


    }


}
