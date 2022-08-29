package com.noah.demo.back;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * Title: GetPermutation.java <br>
 * Description:             <br>
 * Copyright: Copyright (c) 2015<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author yinzo 2022/8/28
 */
public class GetPermutation {

    /**
     * 60. 排列序列
     * <p>
     * 给出集合 [1,2,3,...,n]，其所有元素共有 n! 种排列。
     * <p>
     * 按大小顺序列出所有排列情况，并一一标记，当 n = 3 时, 所有排列如下：
     * <p>
     * "123"
     * "132"
     * "213"
     * "231"
     * "312"
     * "321"
     * 给定 n 和 k，返回第 k 个排列。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/permutation-sequence
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param n
     * @param k
     * @return
     */
    public String getPermutation(int n, int k) {

        List<List<Character>> ansList = new ArrayList<>();

        char[] charArray = new char[n];

        for (int i = 1; i <= n; i++) {

            charArray[i - 1] = (char) ('0' + i);
        }

        boolean[] used = new boolean[n];

        Deque<Character> deque = new ArrayDeque<>();

        dfs(charArray, used, deque, ansList, k);

        List<Character> characterList = ansList.get(k - 1);

        StringBuilder stringBuilder = new StringBuilder();
        for (Character character : characterList) {
            stringBuilder.append(character);
        }

        return stringBuilder.toString();
    }

    public void dfs(char[] charArray, boolean[] used, Deque<Character> deque, List<List<Character>> ansList, int k) {

        // 返回条件
        if (deque.size() == charArray.length) {

            ansList.add(new ArrayList<>(deque));
            return;
        }

        for (int i = 0; i < charArray.length; i++) {

            if (used[i]) {
                continue;
            }

            used[i] = true;
            deque.offerLast(charArray[i]);

            dfs(charArray, used, deque, ansList, k);

            deque.pollLast();
            used[i] = false;

            if (ansList.size() >= k) {
                return;
            }
        }
    }

}
