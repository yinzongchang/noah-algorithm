package com.noah.demo.back;

import org.junit.Test;

/**
 * Title: MinDistBT.java <br>
 * Description:             <br>
 * Copyright: Copyright (c) 2015<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author yinzo 2022/6/11
 */
public class MinDistBT {


    public int minDist = Integer.MAX_VALUE; // 全局变量或者成员变量


    // 调用方式：minDistBacktracing(0, 0, 0, w, n);
    public void minDistBT(int i, int j, int dist, int[][] w, int n) {
        // 到达了 n-1, n-1 这个位置了，这里看着有点奇怪哈，你自己举个例子看下
        if (i == n && j == n) {

            System.out.println(dist);
            if (dist < minDist) {
                minDist = dist;
            }
            return;
        }

        if (i < n) { // 往下走，更新 i=i+1, j=j


            minDistBT(i + 1, j, dist + w[i][j], w, n);
        }

        if (j < n) { // 往右走，更新 i=i, j=j+1


            minDistBT(i, j + 1, dist + w[i][j], w, n);
        }

    }


    public int getMinDist() {
        return minDist;
    }

    @Test
    public void test() {


        int[][] w = new int[3][3];
        w[0][0] = 5;
        w[0][1] = 10;
        w[0][2] = 20;

        w[1][0] = 100;
        w[1][1] = 1000;
        w[1][2] = 10000;

        w[2][0] = 200;
        w[2][1] = 2000;
        w[2][2] = 20000;

        MinDistBT minDistBT = new MinDistBT();

        minDistBT.minDistBT(0, 0, 0, w, 2);

//        System.out.println(minDistBT.getMinDist());

    }


}
