package com.noah.demo.search;

/**
 * Title: HalfSearch.java <br>
 * Description:             <br>
 * Copyright: Copyright (c) 2015<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author yinzo 2019-08-08
 */
public class HalfSearch {


    public static void main(String[] args) {

        HalfSearch halfSearch = new HalfSearch();

        int[] a = {1, 3, 3, 5, 6, 6, 7, 7};

        System.out.println(halfSearch.search(a, 7));

    }


    public int search(int[] arr, int number) {

        if (arr == null) {
            return -1;
        }

        int min = 0;
        int max = arr.length - 1;
        int mid = 0;

        while (min < max) {
            mid = (min + max) / 2;

            if (arr[mid] < number) {

                min = mid + 1;
            } else if (arr[mid] > number) {
                max = mid - 1;
            } else {

                return mid;
            }
        }

        return -1;
    }

}
