package com.noah.demo.array;

import org.junit.Test;

/**
 * Title: GenerateMatrix.java <br>
 * Description:             <br>
 * Copyright: Copyright (c) 2015<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author yinzo 2022/6/13
 */
public class GenerateMatrix {

    public int[][] generateMatrix(int n) {

        int[][] matrix = new int[n][n];

        int left = 0;
        int right = n - 1;

        int top = 0;
        int bottom = n - 1;

        int x = 1;

        while (left <= right && top <= bottom) {

            for (int i = left; i <= right; i++) {

                matrix[top][i] = x;
                x++;
            }

            for (int i = top + 1; i <= bottom; i++) {

                matrix[i][right] = x;
                x++;
            }

            if (left < right && top < bottom) {

                for (int i = right - 1; i >= left; i--) {

                    matrix[bottom][i] = x;
                    x++;
                }

                for (int i = bottom - 1; i >= top + 1; i--) {

                    matrix[i][left] = x;
                    x++;
                }
            }

            top++;
            right--;
            bottom--;
            left++;


        }

        return matrix;
    }

    @Test
    public void test() {


        System.out.println(new GenerateMatrix().generateMatrix(3));

    }

}
