package com.noah.demo.greed;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Title: FindLongestChain.java <br>
 * Description:             <br>
 * Copyright: Copyright (c) 2015<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author yinzo 2022/9/3
 */
public class FindLongestChain {


    /**
     * 646. 最长数对链
     * <p>
     * 给出 n 个数对。 在每一个数对中，第一个数字总是比第二个数字小。
     * <p>
     * 现在，我们定义一种跟随关系，当且仅当 b < c 时，数对(c, d) 才可以跟在 (a, b) 后面。我们用这种形式来构造一个数对链。
     * <p>
     * 给定一个数对集合，找出能够形成的最长数对链的长度。你不需要用到所有的数对，你可以以任何顺序选择其中的一些数对来构造。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/maximum-length-of-pair-chain
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param pairs
     * @return
     */
    public int findLongestChain(int[][] pairs) {


        // 排序
        Arrays.sort(pairs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });


        // 区间数量
        int ans = 0;

        // 当前右区间的值
        int curr = Integer.MIN_VALUE;


        for (int[] pair : pairs) {

            if (curr < pair[0]) {

                curr = pair[1];
                ans++;
            }
        }


        return ans;
    }

}
