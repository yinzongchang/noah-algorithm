package com.noah.demo.doublepointer;

/**
 * Title: NextGreaterElement.java <br>
 * Description:             <br>
 * Copyright: Copyright (c) 2015<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author yinzo 2022/8/21
 */
public class NextGreaterElement {


    /**
     * 556. 下一个更大元素 III
     * <p>
     * 给你一个正整数 n ，请你找出符合条件的最小整数，其由重新排列 n 中存在的每位数字组成，并且其值大于 n 。
     * 如果不存在这样的正整数，则返回 -1 。
     * <p>
     * 注意 ，返回的整数应当是一个 32 位整数 ，如果存在满足题意的答案，但不是 32 位整数 ，同样返回 -1 。
     * <p>
     * 示例 1：
     * <p>
     * 输入：n = 12
     * 输出：21
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/next-greater-element-iii
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param n
     * @return
     */
    public int nextGreaterElement(int n) {

        char[] nums = Integer.toString(n).toCharArray();

        int i = nums.length - 2;

        // 从末尾开始往前遍历
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }

        // i < 0 说明当前序列为最大序列
        if (i < 0) {
            return -1;
        }

        int j = nums.length - 1;

        // 找到需要交换的位置 j
        while (j >= 0 && nums[i] >= nums[j]) {

            j--;
        }

        swap(nums, i, j);

        reverse(nums, i + 1, nums.length - 1);

        long ans = Long.parseLong(new String(nums));

        return ans > Integer.MAX_VALUE ? -1 : (int) ans;

    }


    public void swap(char[] nums, int i, int j) {

        char temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void reverse(char[] nums, int i, int j) {

        while (i < j) {

            swap(nums, i, j);
            i++;
            j--;
        }

    }

}
