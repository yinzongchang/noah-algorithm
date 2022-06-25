package com.noah.demo.classloading;

/**
 * Title: SubClass.java <br>
 * Description:             <br>
 * Copyright: Copyright (c) 2015<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author yinzo 2019-07-30
 */
public class SubClass extends SuperClass {

    static {
        System.out.println("SubClass init!");
    }
}

