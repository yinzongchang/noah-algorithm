package com.noah.demo.math;

/**
 * Title: Rand10.java <br>
 * Description:             <br>
 * Copyright: Copyright (c) 2015<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author yinzo 2022/9/4
 */
public class Rand10 {


    /**
     * 作者：jerry_nju
     * 链接：https://leetcode.cn/problems/implement-rand10-using-rand7/solution/xiang-xi-si-lu-ji-you-hua-si-lu-fen-xi-zhu-xing-ji/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     * @return
     */
    public int rand10() {


        // 首先得到一个数
        int num = (rand7() - 1) * 7 + rand7();

        // 只要它还大于40，那你就给我不断生成吧
        while (num > 40) {
            num = (rand7() - 1) * 7 + rand7();
        }

        // 返回结果，+1是为了解决 40%10为0的情况
        return 1 + num % 10;
    }


    public int rand7() {

        return Math.round(7);
    }


    public int rand10II() {


        while (true) {

            int num = (rand7() - 1) * 7 + rand7();

            // 如果在40以内，那就直接返回
            if (num <= 40) {
                return 1 + num % 10;
            }

            // 说明刚才生成的在41-49之间，利用随机数再操作一遍
            num = (num - 40 - 1) * 7 + rand7();

            if (num <= 60) {
                return 1 + num % 10;
            }

            // 说明刚才生成的在61-63之间，利用随机数再操作一遍
            num = (num - 60 - 1) * 7 + rand7();

            if (num <= 20) {
                return 1 + num % 10;
            }

        }
    }

    

}
