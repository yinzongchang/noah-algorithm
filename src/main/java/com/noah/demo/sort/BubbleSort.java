package com.noah.demo.sort;

import com.alibaba.fastjson.JSON;

/**
 * Title: BubbleSort.java <br>
 * Description:             <br>
 * Copyright: Copyright (c) 2015<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author yinzo 2019-08-08
 */
public class BubbleSort {


    public static void main(String[] args) {

        int[] a = {1, 3, 5, 3, 5, 2, 3, 9, 6, 4, 3, 2, 2};

        BubbleSort bubbleSort = new BubbleSort();
//        bubbleSort.bubble(a);

        bubbleSort.bubble2(a);

        System.out.println(JSON.toJSONString(a));
    }


    private void bubble(int[] arr) {


        for (int i = 0; i < arr.length - 1; i++) {

            for (int j = 0; j < arr.length - 1 - i; j++) {

                if (arr[j] > arr[j + 1]) {

                    int temp = arr[j + 1];

                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                }
            }

        }
    }


    private void bubble2(int[] arr) {


        int lastExchange = 0;

        //无序数列的边界，每次比较只需要比到这里为止
        int sortBorder = arr.length - 1;


        for (int i = 0; i < arr.length - 1; i++) {

            //有序标记，每一轮的初始是true
            boolean isSorted = true;

            for (int j = 0; j < sortBorder; j++) {

                if (arr[j] > arr[j + 1]) {

                    int temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;

                    //有元素交换，所以不是有序，标记变为false
                    isSorted = false;

                    //把无序数列的边界更新为最后一次交换元素的位置
                    lastExchange = j;
                }
            }

            sortBorder = lastExchange;

            if (isSorted) {
                break;
            }


        }

    }

}
