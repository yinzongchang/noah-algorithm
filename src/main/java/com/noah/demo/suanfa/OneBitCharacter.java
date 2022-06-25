package com.noah.demo.suanfa;

/**
 * Title: OneBitCharacter.java <br>
 * Description:             <br>
 * Copyright: Copyright (c) 2015<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author yinzo 2022/2/20
 */
public class OneBitCharacter {


    /**
     * 有两种字符串，一种是 0，一种是 10 或 11。即一种长度是1，一种长度是2.
     *
     * 所以找个指针然后遍历一遍：
     *
     * 遇到 0 走一步；
     * 遇到 1走两步。
     *
     *
     * @param bits
     * @return
     */
    public static boolean isOneBitCharacter(int[] bits) {

        int len = bits.length;

        // 定位点位置
        int pos = 0;

        while (pos < len - 1) {

            // 如果是元素为1，走2步；为0走1步
            int step = bits[pos] == 1 ? 2 : 1;
            pos += step;
        }

        return pos == len - 1;
    }

    public static void main(String[] args) {

        int[] a = {1, 0};

        System.out.println(isOneBitCharacter(a));

    }

}
