package com.noah.demo.sort;

import com.alibaba.fastjson.JSON;

/**
 * Title: InsertOrder.java <br>
 * Description:             <br>
 * Copyright: Copyright (c) 2015<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author yinzo 2019-08-06
 */
public class InsertOrder {


    public static void main(String[] args) {
        int a[] = {5, 3, 8, 2, 0, 1, 4};


        for (int i = 1; i <= a.length - 1; i++) {

            int j;

            if (a[i] < a[i - 1]) {

                int temp = a[i];

                for (j = i; j > 0; j--) {

                    if (temp < a[j - 1]) {

                        a[j] = a[j - 1];
                    } else {
                        break;
                    }
                }

                a[j] = temp;
            }

        }

        System.out.println(JSON.toJSONString(a));


    }


    /**
     * 插入排序，a 表示数组，n 表示数组大小
     *
     * @param a
     * @param n
     */
    public void insertionSort(int[] a, int n) {

        if (n <= 1) {
            return;
        }

        for (int i = 1; i < n; i++) {

            if (a[i] < a[i - 1]) {


                int temp = a[i];
                int j = i;

                for (; j > 0; j--) {


                    if (a[j - 1] > temp) {

                        a[j] = a[j - 1];
                    } else {
                        break;
                    }
                }

                a[j] = temp;
            }
        }
    }


}
