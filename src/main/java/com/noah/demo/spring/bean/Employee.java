package com.noah.demo.spring.bean;

/**
 * Title: Employee.java <br>
 * Description:             <br>
 * Copyright: Copyright (c) 2015<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author yinzo 2019-09-02
 */
public class Employee {

    private String name;

    public void work() {
        System.out.println("Employee " + name + " is working");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
