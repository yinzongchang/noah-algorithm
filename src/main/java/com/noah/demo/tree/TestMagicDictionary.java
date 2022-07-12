package com.noah.demo.tree;

/**
 * Title: TestMagicDictionary.java <br>
 * Description:             <br>
 * Copyright: Copyright (c) 2015<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author yinzo 2022/7/11
 */
public class TestMagicDictionary {

    public static void main(String[] args) {


        MagicDictionary magicDictionary = new MagicDictionary();

        String[] arr = {"hello", "leetcode"};
        magicDictionary.buildDict(arr);

        magicDictionary.search("hhllo");


    }

}
