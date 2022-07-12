package com.noah.demo.heap;

/**
 * Title: Heap.java <br>
 * Description:             <br>
 * Copyright: Copyright (c) 2015<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author yinzo 2022/6/30
 */
public class Heap {

    /**
     * 存储数组
     */
    private int[] a;

    /**
     * 堆可以存储的最大元素数
     */
    private int n;

    /**
     * 元素个数
     */
    private int count;


    public Heap(int capacity) {

        a = new int[capacity + 1];
        n = capacity;
        count = 0;
    }


    /**
     * 插入数据
     *
     * @param data
     */
    public void insert(int data) {

        if (count >= n) {
            return;
        }

        count++;
        a[count] = data;

        int i = count;

        // 这是一个大根堆
        // 从下往上堆化
        while (i / 2 > 0 && a[i] > a[i - 2]) {

            swap(a, i, i / 2);
            i = i / 2;
        }
    }

    public void removeMax() {

        if (count == 0) {
            return;
        }

        a[1] = a[count];
        count--;

        heapify(a, count, 1);

    }

    private void heapify(int[] a, int n, int i) { // 自上往下堆化

        while (true) {

            int maxPos = i;
            if (i * 2 <= n && a[i] < a[i * 2]) {
                maxPos = i * 2;
            }

            if (i * 2 + 1 <= n && a[maxPos] < a[i * 2 + 1]) {

                maxPos = i * 2 + 1;
            }

            if (maxPos == i) {
                break;
            }

            swap(a, i, maxPos);

            i = maxPos;
        }

    }


    private void swap(int[] a, int i, int j) {

        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;

    }

}
