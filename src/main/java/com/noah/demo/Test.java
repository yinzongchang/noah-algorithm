package com.noah.demo;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你一个包含 n 个整数的数组 nums，
 * 判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？
 * 请你找出所有满足条件且不重复的三元组。 注意：答案中不可以包含重复的三元组。
 * 示例：给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 * 满足要求的三元组集合为：[  [-1, 0, 1],  [-1, -1, 2]]
 */
public class Test {

    private volatile Long a = 1L;


    public static void main(String[] args) {



//
//        int[] nums = {-1, 0, 1, 2, -1, -4};
//
//        Arrays.sort(nums);
//
//
//        String s = "123";
//
//        for (char c : s.toCharArray()) {
//
//            int num = (c - '0') + 1;
//
//            System.out.println(num);
//
//        }


//        String B = "𝄞"; // 这个就是那个音符字符，只不过由于当前的网页没支持这种编码，所以没显示。
//        String C = "\uD834\uDD1E";// 这个就是音符字符的UTF-16编码
//        System.out.println(C);
//        System.out.println(B.length());
//        System.out.println(C.length());
//        System.out.println(B.codePointCount(0,B.length()));
//        System.out.println(C.codePointCount(0,B.length()));


        List<Integer> list = new ArrayList<>(2);
        list.add(1);
        list.add(2);

        list.add(1, 33);

        System.out.println(JSONObject.toJSONString(list));

    }


}


