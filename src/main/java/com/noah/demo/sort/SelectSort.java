package com.noah.demo.sort;

import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

import java.util.Arrays;

/**
 * Title: SelectSort.java <br>
 * Description:             <br>
 * Copyright: Copyright (c) 2015<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author yinzo 2022/5/22
 */
public class SelectSort {


    public void selectSort(int[] a, int n) {

        if (n <= 1) {
            return;
        }


        for (int i = 0; i < n; i++) {


            int min = a[i];
            int minIndex = i;

            for (int j = i + 1; j < n; j++) {

                if (min <= a[j]) {
                    continue;
                } else {

                    min = a[j];
                    minIndex = j;
                }
            }


            a[minIndex] = a[i];
            a[i] = min;
        }
    }


    @Test
    public void test() {

        int[] a = {1, 3, 5, 3, 5, 2, 3, 9, 6, 4, 3, 2, 2};

        int[] b = {1, 3, 5, 3, 5, 2, 3, 9, 6, 4, 3, 2, 2};

        new SelectSort().selectSort(a, a.length);

        Arrays.sort(b);


        Arrays.stream(a).forEach(num -> {
            System.out.print(num + " ");
        });

        System.out.println("\n");

        Arrays.stream(b).forEach(num -> {
            System.out.print(num + " ");
        });

    }


}
