package com.noah.demo.array;

import org.junit.Test;

import java.util.Arrays;

/**
 * Title: DuplicateZeros.java <br>
 * Description:             <br>
 * Copyright: Copyright (c) 2015<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author yinzo 2022/6/17
 */
public class DuplicateZeros {



    public void duplicateZeros(int[] arr) {

        for (int i = 0; i < arr.length; i++) {

            if (arr[i] == 0) {

                for (int j = arr.length - 1; j > i; j--) {

                    arr[j] = arr[j - 1];
                }

                i++;
            }

        }

    }

    @Test
    public void test() {

        int[] arr = {1,0,2,3,0,4,5,0};

        new DuplicateZeros().duplicateZeros(arr);

        System.out.println(Arrays.toString(arr));
    }



}
