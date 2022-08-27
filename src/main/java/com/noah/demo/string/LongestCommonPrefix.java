package com.noah.demo.string;

/**
 * Title: LongestCommonPrefix.java <br>
 * Description:             <br>
 * Copyright: Copyright (c) 2015<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author yinzo 2022/8/27
 */
public class LongestCommonPrefix {


    /**
     * 14. 最长公共前缀
     *
     * 编写一个函数来查找字符串数组中的最长公共前缀。
     * 如果不存在公共前缀，返回空字符串 ""。
     *
     * 示例 1：
     *
     * 输入：strs = ["flower","flow","flight"]
     * 输出："fl"
     * 示例 2：
     *
     * 输入：strs = ["dog","racecar","car"]
     * 输出：""
     * 解释：输入不存在公共前缀。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/longest-common-prefix
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param strs
     * @return
     */
    public String longestCommonPrefix(String[] strs) {

        if (strs == null || strs.length == 0) {
            return "";
        }

        if (strs.length == 1) {
            return strs[0];
        }
        
        String ans = strs[0];
        

        int i = 0;

        while (i < ans.length()) {

            char c = ans.charAt(i);

            boolean stop = false;

            for (int j = 0; j < strs.length; j++) {

                if (i >= strs[j].length() || c != strs[j].charAt(i)) {

                    stop = true;
                    break;
                }
            }

            if (stop) {

                ans = ans.substring(0, i);

            }

            i++;
        }

        return ans;
    }

    public static void main(String[] args) {


        String sub = "abc".substring(0, 1);

        System.out.println(sub);
    }

}
