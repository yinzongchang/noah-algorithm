package com.noah.demo;

import com.google.common.base.Joiner;

import java.util.ArrayList;

/**
 * Title: algorithm.java <br>
 * Description:             <br>
 * Copyright: Copyright (c) 2015<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author yinzo 2019-07-03
 */
public class algorithm {

    public static void main(String[] args) {

        System.out.println(Joiner.on(",").join(new ArrayList<Long>() {{add(1L);add(2L);}}));
    }
}
