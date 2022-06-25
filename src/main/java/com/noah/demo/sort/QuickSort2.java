package com.noah.demo.sort;

import org.junit.Test;

import java.util.Arrays;

/**
 * Title: QuickSort2.java <br>
 * Description:             <br>
 * Copyright: Copyright (c) 2015<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author yinzo 2022/5/22
 */
public class QuickSort2 {


    public static void quickSort(int[] arr, int startIndex, int endIndex) {

        if (startIndex >= endIndex) {
            return;
        }


        int middle = partition(arr, startIndex, endIndex);

        quickSort(arr, startIndex, middle - 1);
        quickSort(arr, middle + 1, endIndex);


    }


    public static int partition(int[] arr, int startIndex, int endIndex) {


        int pivot = arr[startIndex];

        int i = startIndex;
        int j = endIndex;


        while (i < j) {

            // 如果j都大于目标值 - 跳过
            while (i < j && arr[j] > pivot) {
                j--;
            }

            // 如果i都小于或者等于目标值 - 跳过
            while (i < j && arr[i] <= pivot) {
                i++;
            }



            if (i < j) {
                // 交换i和j的值
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }

        }

        // i = j 的时候，交汇点的值，小于等于pivot
        arr[startIndex] = arr[i];
        arr[i] = pivot;

        return i;
    }

    @Test
    public void test() {

        int[] a = {3, 2, 5, 7, 9, 3, 3, 3, 9, 8, 7, 4, 1, 0, 3};
        int[] b = {3, 2, 5, 7, 9, 3, 3, 3, 9, 8, 7, 4, 1, 0, 3};

        QuickSort2.quickSort(a, 0, a.length - 1);

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
