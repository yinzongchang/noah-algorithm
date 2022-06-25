package com.noah.demo.classloading;

/**
 * 初始化阶段，则根据程序员通过程序制定的主观计划去初始化变量和其他资源，或者可以从另外一个角度来表达：初始化阶段是执行类构造器<clinit>()方法的过程。
 * <clinit>()方法是由编译器自动收集类中的所有类变量的赋值动作和静态语句块（static{}）中的语句合并产生的，编译器收集的顺序是由语句在源文件中出现的顺序所决定的。
 * 静态语句块中只能访问到定义在静态语句块之前的变量，定义在它之后的变量，在前面的静态语句块可以赋值，但是不能访问。
 */
public class Test {


    static {
        i = 0; // 给变量赋值可以正常编译通过
//        System.out.println(i); // 编译器会提示"非法向前引用"
    }

    static int i = 1;

    public static void main(String[] args) {
        System.out.println(i);
    }
}
