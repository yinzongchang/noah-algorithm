package com.noah.demo.doublepointer;

/**
 * Title: IsHappy.java <br>
 * Description:             <br>
 * Copyright: Copyright (c) 2015<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author yinzo 2022/8/14
 */
public class IsHappy {


    /**
     * 202. 快乐数
     *
     * 编写一个算法来判断一个数 n 是不是快乐数。
     *
     * 「快乐数」定义为：
     *
     * 对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和。
     * 然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。
     * 如果这个过程 结果为 1，那么这个数就是快乐数。
     *
     * 示例 1：
     *
     * 输入：n = 19
     * 输出：true
     * 解释：
     * 12 + 92 = 82
     * 82 + 22 = 68
     * 62 + 82 = 100
     * 12 + 02 + 02 = 1
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/happy-number
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param n
     * @return
     */
    public boolean isHappy(int n) {


        int slow = n;
        int fast = squareSum(n);


        while (fast != 1 && fast != slow) {

            slow = squareSum(slow);

            fast = squareSum(squareSum(fast));
        }

        return fast == 1;
    }


    public int squareSum(int n) {

        int sum = 0;

        while (n > 0) {

            int digit = n % 10;
            sum += digit * digit;
            n = n / 10;
        }

        return sum;
    }


}
