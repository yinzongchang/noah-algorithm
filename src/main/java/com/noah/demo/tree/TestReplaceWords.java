package com.noah.demo.tree;

import com.google.common.collect.Lists;

/**
 * Title: TestReplaceWords.java <br>
 * Description:             <br>
 * Copyright: Copyright (c) 2015<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author yinzo 2022/7/7
 */
public class TestReplaceWords {


    public static void main(String[] args) {

        String[] arr = {"cat", "bat", "rat"};

        String s = "the cattle was rattled by the battery";

        String words = new ReplaceWords().replaceWords(Lists.newArrayList(arr), s);

        System.out.println(words);

    }
}
