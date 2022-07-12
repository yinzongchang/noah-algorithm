package com.noah.demo;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Title: ArrayK.java <br>
 * Description:             <br>
 * Copyright: Copyright (c) 2015<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author yinzo 2022/6/30
 */
public class ArrayK {


    public void arrayK(int[] arr, int k) {


        int n = arr.length;

        Deque<Integer> queue = new LinkedList<>();


        queue.offerLast(arr[0]);


        for (int i = 1; i < n; i++) {


            if (arr[i] > queue.peekLast() && queue.size() == k) {

                queue.removeFirst();
            }

            if (arr[i] < queue.peekFirst() && queue.size() == k) {

                continue;
            }

            if (arr[i] >= queue.peekFirst() && arr[i] <= queue.peekLast()) {

                queue.removeFirst();

                int num = arr[i];

                for (int x = 0; x < k; x++) {

                }

            }




            queue.offerLast(arr[i]);
        }




    }


}
