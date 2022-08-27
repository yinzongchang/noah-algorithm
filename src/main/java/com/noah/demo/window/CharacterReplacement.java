package com.noah.demo.window;

/**
 * Title: CharacterReplacement.java <br>
 * Description:             <br>
 * Copyright: Copyright (c) 2015<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author yinzo 2022/8/22
 */
public class CharacterReplacement {


    /**
     * 424. 替换后的最长重复字符
     * 给你一个字符串 s 和一个整数 k 。你可以选择字符串中的任一字符，并将其更改为任何其他大写英文字符。该操作最多可执行 k 次。
     *
     * 在执行上述操作后，返回包含相同字母的最长子字符串的长度。
     *
     * 示例 1：
     *
     * 输入：s = "ABAB", k = 2
     * 输出：4
     * 解释：用两个'A'替换为两个'B',反之亦然。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/longest-repeating-character-replacement
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     *
     * 作者：LeetCode
     * 链接：https://leetcode.cn/problems/longest-repeating-character-replacement/solution/ti-huan-hou-de-zui-chang-zhong-fu-zi-fu-eaacp/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     * @param s
     * @param k
     * @return
     */
    public int characterReplacement(String s, int k) {

        int len = s.length();
        if (len < 2) {
            return len;
        }

        char[] charArray = s.toCharArray();
        int left = 0;
        int right = 0;

        int res = 0;
        int maxCount = 0;
        int[] freq = new int[26];


        // [left, right) 内最多替换 k 个字符可以得到只有一种字符的子串
        // 如果没有更多的相同字符，left right 会同时右移
        while (right < len) {

            freq[charArray[right] - 'A']++;
            // 在这里维护 maxCount，因为每一次右边界读入一个字符，字符频数增加，才会使得 maxCount 增加
            maxCount = Math.max(maxCount, freq[charArray[right] - 'A']);

            right++;

            if (right - left > maxCount + k) {

                // 说明此时 k 不够用
                // 把其它不是最多出现的字符替换以后，都不能填满这个滑动的窗口，这个时候须要考虑左边界向右移动
                // 移出滑动窗口的时候，频数数组须要相应地做减法
                freq[charArray[left] - 'A']--;
                left++;
            }

            res = Math.max(res, right - left);
        }

        return res;
    }

}
