package com.noah.demo.hash;

/**
 * Title: TestHash.java <br>
 * Description:             <br>
 * Copyright: Copyright (c) 2015<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author yinzo 2019-08-09
 */
public class TestHash {


    public static void main(String[] args) {

        String a = "asdfasdfa";

        System.out.println(Integer.toBinaryString(a.hashCode()));

        System.out.println(Integer.toBinaryString(a.hashCode() >>> 0));

        System.out.println(Integer.toBinaryString(a.hashCode() ^ (a.hashCode() >>> 0)));

        Integer num = 1;

        switch (num) {
            case 1:
                System.out.println("11111");
                break;
            case 2:
                System.out.println("22222");
                break;
            default:
                System.out.println("hehe");
                break;
        }


    }


}
