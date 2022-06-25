package com.noah.demo.spring.bean;

/**
 * Title: Company.java <br>
 * Description:             <br>
 * Copyright: Copyright (c) 2015<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author yinzo 2019-09-02
 */
public class Company {

//    private Long id;

    private String name;

    private Employee employee;

    public void open() {
//        System.out.println("CompanyId " + id);
        System.out.println("Company " + name + " is open.");
        employee.work();
    }

//    public Long getId() {
//        return id;
//    }

//    public void setId(Long id) {
//        this.id = id;
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
