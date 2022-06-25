package com.noah.demo.suanfa;

/**
 * Title: ProductExceptSelf.java <br>
 * Description:             <br>
 * Copyright: Copyright (c) 2015<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author yinzo 2021/11/7
 */
public class ProductExceptSelf {


    public int[] productExceptSelf(int[] nums) {

        if (nums == null || nums.length == 0) {

            return new int[]{};
        }

        int len = nums.length;
        int[] answer = new int[len];


        answer[0] = 1;
        // 初始化数据，初始化为左侧所有元素乘积
        for (int i = 1; i < nums.length; i++) {

            answer[i] = nums[i - 1] * answer[i - 1];
        }

        // 计算右侧数据
        int r = 1;
        for (int i = len - 1; i >= 0; i--) {

            answer[i] = answer[i] * r;

            r = r * nums[i];
        }

        return answer;
    }

}
