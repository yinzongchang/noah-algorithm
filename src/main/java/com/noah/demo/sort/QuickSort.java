package com.noah.demo.sort;

import java.util.Arrays;

/**
 * Title: QuickSort.java <br>
 * Description:             <br>
 * Copyright: Copyright (c) 2015<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author yinzo 2019-08-10
 */
public class QuickSort {


    public static void quickSort(int[] arr, int startIndex, int endIndex) {

        // 递归结束条件：startIndex大等于endIndex的时候
        if (startIndex >= endIndex) {
            return;
        }


        int pivotIndex = partition(arr, startIndex, endIndex);
        quickSort(arr, startIndex, pivotIndex - 1);
        quickSort(arr, pivotIndex + 1, endIndex);
    }


    /**
     * 分治（双边循环法）
     *
     * @param arr        待交换的数组
     * @param startIndex 起始下标
     * @param endIndex   结束下标
     */
    private static int partition(int[] arr, int startIndex, int endIndex) {

        // 取第一个位置的元素作为基准元素（也可以选择随机位置）
        int pivot = arr[startIndex];

        int left = startIndex;
        int right = endIndex;

        while (left != right) {

            //控制right指针比较并左移
            while (left < right && arr[right] > pivot) {
                right--;
            }

            //控制left指针比较并右移
            while (left < right && arr[left] <= pivot) {
                left++;
            }

            //交换left和right指向的元素
            if (left < right) {
                int p = arr[left];
                arr[left] = arr[right];
                arr[right] = p;
            }
        }

        //pivot和指针重合点交换
        arr[startIndex] = arr[left];
        arr[left] = pivot;

        return left;
    }

    public static void quickSortV2(int[] arr, int startIndex, int endIndex) {

        // 递归结束条件：startIndex大等于endIndex的时候
        if (startIndex >= endIndex) {
            return;
        }

        int pivotIndex = partitionV2(arr, startIndex, endIndex);
        quickSortV2(arr, startIndex, pivotIndex - 1);
        quickSortV2(arr, pivotIndex + 1, endIndex);

    }

    /**
     * 分治（单边循环法）
     *
     * @param arr        待交换的数组
     * @param startIndex 起始下标
     * @param endIndex   结束下标
     */
    private static int partitionV2(int[] arr, int startIndex, int endIndex) {
        // 取第一个位置的元素作为基准元素（也可以选择随机位置）
        int pivot = arr[startIndex];
        int mark = startIndex;

        for (int i = startIndex + 1; i <= endIndex; i++) {
            if (arr[i] < pivot) {
                mark++;
                int p = arr[mark];
                arr[mark] = arr[i];
                arr[i] = p;
            }
        }

        arr[startIndex] = arr[mark];
        arr[mark] = pivot;
        return mark;
    }

    public static void main(String[] args) {

        int[] arr = {4, 2, 3, 5, 9, 8, 2, 3, 4, 3, 2};

        quickSortV2(arr, 0, arr.length - 1);

        Arrays.stream(arr).forEach(System.out::println);

    }


}
