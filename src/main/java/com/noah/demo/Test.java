package com.noah.demo;

import java.util.Arrays;

/**
 * 给你一个包含 n 个整数的数组 nums，
 * 判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？
 * 请你找出所有满足条件且不重复的三元组。 注意：答案中不可以包含重复的三元组。
 * 示例：给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 * 满足要求的三元组集合为：[  [-1, 0, 1],  [-1, -1, 2]]
 */
public class Test {


    public static void main(String[] args) {


        int[] nums = {-1, 0, 1, 2, -1, -4};

        Arrays.sort(nums);


        String s = "123";

        for (char c : s.toCharArray()) {

            int num = (c - '0') + 1;

            System.out.println(num);

        }


    }


}


