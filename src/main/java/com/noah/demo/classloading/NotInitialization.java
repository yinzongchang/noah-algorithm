package com.noah.demo.classloading;

/**
 * Title: NotInitialization.java <br>
 * Description:             <br>
 * Copyright: Copyright (c) 2015<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author yinzo 2019-07-30
 */
public class NotInitialization {


    public static void main(String[] args) {

        /**
         * 对于静态字段，只有直接定义这个字段的类才会被初始化，
         * 因此通过其子类来引用父类中定义的静态字段，只会触发父类的初始化而不会触发子类的初始化。
         * 至于是否要触发子类的加载和验证，在虚拟机规范中并未明确规定，这点取决于虚拟机的具体实现。
         * SuperClass init!
         * 123
         */
//        System.out.println(SubClass.value);

        /**
         * 被动使用类字段演示二：
         * 通过数组定义引用类，不会触发子类的初始化
         * 并没有触发com.noah.demo.classloading.SuperClass的初始化阶段。
         * 但是触发了另一名为"[Lcom.noah.demo.classloading.SuperClass"的类的初始化阶段，
         * 它是一个由虚拟机自动生成的、直接继承于java.lang.Object的子类，创建动作由字节码指令newarray触发。
         */
//        SuperClass[] sca = new SuperClass[10];

        /**
         * 被动使用类字段演示三：
         * 常量在编译阶段会存入调用类的常量池中，本质上并没有直接引用到定义常量的类，因此不会触发定义常量的类的初始化。
         * 在编译阶段通过常量传播优化，已经将此常量的值"hello world!"存储到了NotInitialization类的常量池中。
         * decompile System.out.println("hello world!");
         */
        System.out.println(ConstClass.HELLO_WORLD);


    }


}
