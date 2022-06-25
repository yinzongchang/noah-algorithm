package com.noah.demo.array;

import java.util.HashSet;
import java.util.Set;

/**
 * Title: RepeatedNTimes.java <br>
 * Description:             <br>
 * Copyright: Copyright (c) 2015<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author yinzo 2022/5/21
 */
public class RepeatedNTimes {

    /**
     * 记重复 nn 次的元素为 xx。由于数组 \textit{nums}nums 中有 n+1n+1 个不同的元素，而其长度为 2n2n，那么数组中剩余的元素均只出现了一次。也就是说，我们只需要找到重复出现的元素即为答案。
     *
     * 因此我们可以对数组进行一次遍历，并使用哈希集合存储已经出现过的元素。如果遍历到了哈希集合中的元素，那么返回该元素作为答案。
     *
     */
    public int repeatedNTimes(int[] nums) {


        Set<Integer> set = new HashSet<>();

        for (int num : nums) {

            if (set.contains(num)) {
                return num;
            }

            set.add(num);
        }

        return -1;
    }

}
