package com.noah.java.demo;

import java.util.Scanner;

/**
 * Title: TestExit.java <br>
 * Description:             <br>
 * Copyright: Copyright (c) 2015<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author yinzo 2022/8/14
 */
public class TestExit {


    /**
     * System.exit()方法的详解
     *
     * https://blog.csdn.net/qq_40474507/article/details/119116506
     *
     * @param args
     */
    public static void main(String[] args) {



        try {

            int a = 10;
            Scanner read = new Scanner(System.in);

            System.out.println("请输入除数:");
            int b = read.nextInt();

            System.out.println("a / b = " + a / b);

//            System.exit(0);
        } catch (ArithmeticException arithmeticException) {

            System.out.println("除数不能为0");
            arithmeticException.printStackTrace();
            System.exit(1);


        }

    }

}
