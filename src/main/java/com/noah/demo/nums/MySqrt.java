package com.noah.demo.nums;

/**
 * Title: MySqrt.java <br>
 * Description:             <br>
 * Copyright: Copyright (c) 2015<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author yinzo 2022/5/19
 */
public class MySqrt {


    public int mySqrt(int x) {

        // 特殊值判断
        if (x == 0) {
            return 0;
        }
        if (x == 1) {
            return 1;
        }

        int left = 1;
        int right = x / 2;

        // 在区间 [left..right] 查找目标元素
        while (left < right) {

            int mid = left + (right - left + 1) / 2;

            // 注意：这里为了避免乘法溢出，改用除法
            if (mid > x / mid) {
                // 下一轮搜索区间是 [left..mid - 1]
                right = mid - 1;
            } else {
                // 下一轮搜索区间是 [mid..right]
                left = mid;
            }
        }

        return left;
    }

}
