package com.noah.demo.nums;

/**
 * Title: Palindrome.java <br>
 * Description:             <br>
 * Copyright: Copyright (c) 2015<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author yinzo 2022/5/10
 */
public class Palindrome {



    public boolean isPalindrome(int x) {


        int result = 0;
        int temp = x;

        while (temp != 0) {

            result = result * 10 + temp % 10;
            temp = temp / 10;
        }

        return result == x;
    }

    public static void main(String[] args) {
        System.out.println(new Palindrome().isPalindrome(102));
    }

}
