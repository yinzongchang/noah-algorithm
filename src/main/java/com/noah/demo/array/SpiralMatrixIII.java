package com.noah.demo.array;

import org.junit.Test;

/**
 * Title: SpiralMatrixIII.java <br>
 * Description:             <br>
 * Copyright: Copyright (c) 2015<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author yinzo 2022/6/13
 */
public class SpiralMatrixIII {


    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {

        int row = rStart;
        int col = cStart;

        int left = col;
        int right = col;

        int top = row;
        int bottom = row;

        int[][] matrix = new int[rows * cols][2];

        int step = 1;

        int index = 0;

        while (left >= 0 || right <= cols - 1 || top >= 0 || bottom <= rows - 1) {


            for (int i = col; i <= col + step; i++) {

                if (i >= 0 && i <= cols - 1 && row >= 0 & row <= rows - 1) {

                    matrix[index][0] = row;
                    matrix[index][1] = i;
                    index++;
                }
            }

            col = col + step;


            for (int i = row + 1; i <= row + step; i++) {

                if (col >= 0 && col <= cols - 1 && i >= 0 & i <= rows - 1) {

                    matrix[index][0] = i;
                    matrix[index][1] = col;
                    index++;
                }
            }

            row = row + step;


            step++;

            for (int i = col - 1; i >= col - step; i--) {

                if (i >= 0 && i <= cols - 1 && row >= 0 & row <= rows - 1) {

                    matrix[index][0] = row;
                    matrix[index][1] = i;
                    index++;
                }
            }

            col = col - step;


            for (int i = row - 1; i >= row - step + 1; i--) {

                if (col >= 0 && col <= cols - 1 && i >= 0 & i <= rows - 1) {

                    matrix[index][0] = i;
                    matrix[index][1] = col;
                    index++;
                }
            }

            row = row - step;


            step++;

            right = right + 1;
            bottom = bottom + 1;
            left = left - 1;
            top = top - 1;
        }


        return matrix;
    }


    @Test
    public void test() {

        new SpiralMatrixIII().spiralMatrixIII(1, 4, 0, 0);

    }

}
