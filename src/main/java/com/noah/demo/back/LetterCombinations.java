package com.noah.demo.back;

import java.util.*;

/**
 * Title: LetterCombinations.java <br>
 * Description:             <br>
 * Copyright: Copyright (c) 2015<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author yinzo 2022/7/25
 */
public class LetterCombinations {

    /**
     * 17. 电话号码的字母组合
     * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
     * <p>
     * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
     * <p>
     * 示例 1：
     * 输入：digits = "23"
     * 输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/letter-combinations-of-a-phone-number
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public List<String> letterCombinations(String digits) {

        List<String> combinations = new ArrayList<>();

        if (digits.length() == 0) {
            return combinations;
        }
        Map<Character, String> phoneMap = new HashMap<Character, String>() {{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};


        dfs(combinations, digits, 0, phoneMap, new StringBuilder());

        return combinations;
    }

    private void dfs(List<String> combinations, String digits, int index, Map<Character, String> phoneMap, StringBuilder combination) {


        if (index == digits.length()) {

            combinations.add(combination.toString());
            return;
        }

        char digit = digits.charAt(index);
        String letters = phoneMap.get(digit);


        for (int i = 0; i < letters.length(); i++) {

            combination.append(letters.charAt(i));

            dfs(combinations, digits, index + 1, phoneMap, combination);

            combination.deleteCharAt(index);
        }
    }

    public List<String> letterCombinations2(String digits) {

        List<String> combinations = new ArrayList<>();

        if (digits.length() == 0) {
            return combinations;
        }
        Map<Character, String> phoneMap = new HashMap<Character, String>() {{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};


        Queue<String> queue = new LinkedList<>();
        queue.offer("");

        for (int i = 0; i < digits.length(); i++) {

            int size = queue.size();

            for (int j = 0; j < size; j++) {

                String word = phoneMap.get(digits.charAt(i));

                String pre = queue.poll();

                for (char c : word.toCharArray()) {

                    queue.offer(pre + c);
                }
            }
        }

        return new ArrayList<>(queue);
    }

}
