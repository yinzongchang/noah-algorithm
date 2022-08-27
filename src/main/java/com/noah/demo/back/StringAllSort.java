package com.noah.demo.back;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Title: StringAllSort.java <br>
 * Description:             <br>
 * Copyright: Copyright (c) 2015<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author yinzo 2022/8/19
 */
public class StringAllSort {


    public static void main(String[] args) {

        System.out.println(JSONObject.toJSONString(new StringAllSort().allSort("abc")));


    }

    public List<String> allSort(String word) {

        char[] wordArray = word.toCharArray();

        boolean[] used = new boolean[wordArray.length];

        List<String> ansList = new ArrayList<>();

        dfs(word, wordArray, used, "", ansList);


        return ansList;
    }

    public void dfs(String word, char[] wordArray, boolean[] used, String newWord, List<String> ansList) {

        if (word.length() == newWord.length()) {
            ansList.add(newWord);
        }

        for (int i = 0; i < wordArray.length; i++) {

            if (used[i]) {
                continue;
            }

            used[i] = true;
            dfs(word, wordArray, used, newWord + wordArray[i], ansList);
            used[i] = false;

        }

    }


}
