package com.noah.demo.doublepointer;

/**
 * Title: IsPalindrome.java <br>
 * Description:             <br>
 * Copyright: Copyright (c) 2015<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author yinzo 2022/8/14
 */
public class IsPalindrome {

    /**
     * 125. 验证回文串
     * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
     * <p>
     * 示例 1:
     * <p>
     * 输入: "A man, a plan, a canal: Panama"
     * 输出: true
     * 解释："amanaplanacanalpanama" 是回文串
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/valid-palindrome
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public boolean isPalindrome(String s) {


        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {

            char c = s.charAt(i);

            if (Character.isLetterOrDigit(c)) {
                stringBuilder.append(Character.toLowerCase(c));
            }
        }

        int len = stringBuilder.length();

        int left = 0;
        int right = len - 1;

        while (left < right) {

            if (stringBuilder.charAt(left) != stringBuilder.charAt(right)) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }


}
