package com.noah.demo.search;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Title: Main.java <br>
 * Description:             <br>
 * Copyright: Copyright (c) 2015<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author yinzo 2022/8/29
 */
public class Main {

    public static void main(String[] args) {
        // Scanner input=new Scanner(System.in);
        // String str=input.next();
        System.out.println("hello world");

        int[] arr = {1, 3, 5, 2, 4};

        int[] ans = new Main().rightMax2(arr);

        for (int num : ans) {
            System.out.println(num);
        }

    }

    public int[] rightMax(int[] arr) {

        int[] ans = new int[arr.length];

        int len = arr.length;

        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < arr.length; i++) {

            stack.clear();

            int j = i;
            while (j < len && arr[stack.peekLast()] <= arr[i]) {
                stack.offerLast(j);
                j++;
            }

            if (!stack.isEmpty() && i == stack.peekLast()) {
                stack.clear();
            }

            if (stack.peekLast() == null) {
                ans[i] = -1;
            } else {

                if (stack.peekLast() == i) {
                    ans[i] = -1;
                } else {
                    ans[i] = arr[stack.peekLast()];
                }

            }

        }

        ans[len] = -1;
        return ans;
    }



    public int[] rightMax2(int[] arr) {

        int[] ans = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {


            int j = i;
            while (j < arr.length && arr[j] <= arr[i]) {
                j++;
            }

            if (j < arr.length) {
                ans[i] = arr[j];
            } else {
                ans[i] = -1;

            }
        }
        return ans;
    }




}
