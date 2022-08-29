package com.noah.demo.stack;

import com.noah.demo.search.Main;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * Title: RightFirstMax.java <br>
 * Description:             <br>
 * Copyright: Copyright (c) 2015<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author yinzo 2022/8/29
 */
public class RightFirstMax {


    /**
     * 思路1、暴力遍历
     * 我们很容易想到复杂度为O(n^2)的解法，遍历数组中的每一个后面所有元素，找到第一个大于它的，输出即可。
     *
     * @param arr
     * @return
     */
    public int[] rightFirstMax(int[] arr) {


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


    /**
     * 找出数组中每个数右边第一个比它大的元素
     *
     * 题目：给定一个整型数组，数组元素随机无序的，要求打印出所有元素右边第一个大于该元素的值。
     *
     * 如数组A=[1, 5, 3, 6, 4, 8, 9, 10] 输出[5, 6, 6, 8, 8, 9, 10, -1]
     * 如数组A=[8, 2, 5, 4, 3, 9, 7, 2, 5] 输出[9, 5, 9, 9, 9, -1, -1, 5, -1]
     *
     * 思路2、借助栈，时间复杂度O(n)
     *
     * 我们用栈来保存未找到右边第一个比它大的元素的索引（保存索引是因为后面需要靠索引来给新数组赋值），初始时，栈里放的是第一个元素的索引值（也就是0）。
     *
     * 以A=[8, 2, 5, 4, 3, 9, 7, 2, 5] 举例
     *
     * 1) 初始栈顶元素数组的第一个索引 0，栈顶A[stack.pop()]=A[0]=8
     *
     * 2) 遍历到下一个元素值为2，它比栈顶A[stack.pop()]=A[0]=8元素值小，直接将该元素的索引入栈，栈中元素是1, 0, 栈顶A[stack.pop()]=A[1]=2
     *
     * 3) 遍历到下一个元素值为5，它比栈顶A[stack.pop()]=A[1]=2元素值大，将栈顶元素出栈，并且赋值result[stack.pop()]=result[1]=5，现在栈中还剩下 0, 栈顶A[stack.pop()]=A[0]=8
     *
     * 接着判断当前遍历的元素值5是否在大于栈顶A[stack.pop()]=A[0]=8，发现小于栈顶元素，直接将该元素的索引入栈，栈中元素是2, 0, 栈顶A[stack.pop()]=A[2]=5
     *
     * 4) 遍历到下一个元素值为4，它比栈顶A[stack.pop()]=A[2]=5元素值小，直接将该元素的索引入栈，栈中元素是3，2, 0, 栈顶A[stack.pop()]=A[3]=4
     *
     * 5) 遍历到下一个元素值为3，它比栈顶A[stack.pop()]=A[3]=4元素值小，直接将该元素的索引入栈，栈中元素是4，3，2, 0, 栈顶A[stack.pop()]=A[4]=3
     *
     * 6) 遍历到下一个元素值为9，它比栈顶A[stack.pop()]=A[4]=3元素值大，将栈顶元素出栈，并且赋值result[stack.pop()]=result[4]=9，现在栈中还剩下3, 2, 0, ....重复这个步骤，最终都因为9比栈顶元素大，栈中元素出栈，最终result[3]=9, result[2]=9, result[0]=9， 直到栈中元素都出栈了，栈为空，直接将当前元素索引值存入栈。即栈顶A[stack.pop()]=A[5]=9
     *
     * 7) 遍历到下一个元素值为7，它比栈顶A[stack.pop()]=A[5]=9元素值小，直接将该元素的索引入栈，栈中元素是6,5, 栈顶A[stack.pop()]=A[6]=7
     *
     * 8) 遍历到下一个元素值为2，它比栈顶A[stack.pop()]=A[6]=7元素值小，直接将该元素的索引入栈，栈中元素是7, 6,5, 栈顶A[stack.pop()]=A[7]=2
     *
     * 9) 遍历到下一个元素值为5，它比栈顶A[stack.pop()]=A[7]=2元素值大，将栈顶元素出栈，并且赋值result[stack.pop()]=result[7]=5，现在栈中还剩下6, 5， 栈顶元素A[stack.pop()]=A[6]=7比当前处理的元素值5大，所以将当前元素的索引值入栈，栈中变成8, 6, 5
     *
     * 由于元素遍历完了，栈中还保存的元素代表该索引处找不到右边第一个比它大的元素值了，所以挨个将栈中元素出栈，并赋值result[8]=-1, result[6]=-1, result[5]=-1
     *
     * @param arr
     * @return
     */
    public int[] rightFirstMax2(int[] arr) {


        int[] ans = new int[arr.length];

        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < arr.length; i++) {

            while (!stack.isEmpty() && arr[stack.peekLast()] < arr[i]) {

                ans[stack.pollLast()] = arr[i];
            }

            stack.offerLast(i);
        }

        while (!stack.isEmpty()) {

            ans[stack.pollLast()] = -1;
        }

        return ans;
    }

    public static void main(String[] args) {

        int[] arr = {8, 2, 5, 4, 3, 9, 7, 2, 5};

        int[] ans = new RightFirstMax().rightFirstMax2(arr);

        System.out.println(Arrays.toString(ans));


    }

}
