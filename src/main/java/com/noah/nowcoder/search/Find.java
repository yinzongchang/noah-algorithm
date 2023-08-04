package com.noah.nowcoder.search;

import org.junit.Test;

import java.util.UUID;

/**
 * Find.java
 *
 * @author yinzongchang
 * 创建时间 2023/5/26
 * @since 1.0
 */
public class Find {

    /**
     * BM18 二维数组中的查找
     * <p>
     * 描述
     * 在一个二维数组array中（每个一维数组的长度相同），
     * 每一行都按照从左到右递增的顺序排序，
     * 每一列都按照从上到下递增的顺序排序。
     * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
     * <p>
     * [
     * [1,2, 8, 9],
     * [2,4, 9,12],
     * [4,7,10,13],
     * [6,8,11,15]
     * ]
     * 给定 target = 7，返回 true。
     * 给定 target = 3，返回 false。
     *
     * @param target
     * @param array
     * @return
     */
    public boolean find(int target, int[][] array) {

        if (array == null || array[0] == null || array[0].length == 0) {
            return false;
        }

        int rows = array.length;
        int cols = array[0].length;

        int i = rows - 1;
        int j = 0;
        while (i >= 0 && j < cols) {

            if (array[i][j] == target) {
                return true;
            }

            if (array[i][j] < target && j < cols - 1) {
                j++;
            }

            if (array[i][j] > target && i >= 1) {
                i--;
            }
        }

        return false;
    }

    @Test
    public void test() {

        int[][] arr = {{1, 1}};

        new Find().find(2, arr);
    }

    public static void main(String[] args) {
        System.out.println(UUID.randomUUID().toString());
    }

}
