package com.noah.demo.array2;

/**
 * Title: Roate.java <br>
 * Description:             <br>
 * Copyright: Copyright (c) 2015<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author yinzo 2022/8/14
 */
public class Rotate {

    /**
     * 48. 旋转图像
     * <p>
     * 给定一个 n × n 的二维矩阵 matrix 表示一个图像。请你将图像顺时针旋转 90 度。
     * <p>
     * 你必须在 原地 旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要 使用另一个矩阵来旋转图像。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/rotate-image
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    public void rotate(int[][] matrix) {

        int n = matrix.length;


        // 1.对角线翻转
        for (int i = 0; i < n; i++) {

            for (int j = 0; j < i; j++) {

                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // 2. 水平翻转
        for (int i = 0; i < n; i++) {


            for (int j = 0, k = n - 1; j < k; j++, k--) {

                int temp = matrix[i][j];

                matrix[i][j] = matrix[i][k];
                matrix[i][k] = temp;
            }
        }
    }

}
