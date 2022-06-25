package com.noah.demo.suanfa;

/**
 * Title: SearchMatrix.java <br>
 * Description:             <br>
 * Copyright: Copyright (c) 2015<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author yinzo 2021/11/7
 */
public class SearchMatrix {


//    public boolean searchMatrix(int[][] matrix, int target) {
//        if (matrix.length == 0 || matrix[0].length == 0) {
//            return false;
//        }
//        for (int i = 0; i < matrix.length; i++) {
//            if (matrix[i][0] > target) {
//                break;
//            }
//            if (matrix[i][matrix[i].length - 1] < target) {
//                continue;
//            }
//            int col = binarySearch(matrix[i], target);
//            if (col != -1) {
//                return true;
//            }
//        }
//        return false;
//    }
//
//    //二分查找
//    private int binarySearch(int[] nums, int target) {
//        int start = 0;
//        int end = nums.length - 1;
//        while (start <= end) {
//            int mid = (start + end) >>> 1;
//            if (nums[mid] == target) {
//                return mid;
//            } else if (nums[mid] < target) {
//                start = mid + 1;
//            } else {
//                end = mid - 1;
//            }
//        }
//        return -1;
//    }

    public boolean searchMatrix(int[][] matrix, int target) {

        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int row = 0;
        int col = matrix[0].length - 1;

        while (row < matrix.length && col >= 0) {

            if (target > matrix[row][col]) {
                row++;
            } else if (target < matrix[row][col]) {
                col--;
            } else {
                return true;
            }

        }

        return false;
    }

}
