package com.noah.demo.spring.bean;

import com.noah.demo.spring.ioc.context.ApplicationContext;
import com.noah.demo.spring.ioc.context.ClasspathXmlApplicationContext;

import java.io.InputStream;

/**
 * Title: CompanyApplicationContext.java <br>
 * Description:             <br>
 * Copyright: Copyright (c) 2015<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author yinzo 2019-09-02
 */
public class CompanyApplicationContext {

    public static void main(String[] args) {

        ApplicationContext context = new ClasspathXmlApplicationContext("spring/company-ioc.xml");
        Company company = (Company) context.getBean("company");
        company.open();


        InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("spring/company-ioc.xml");
        InputStream inputStream2 = Class.class.getResourceAsStream("/spring/company-ioc.xml");

        System.out.println(inputStream);
        System.out.println(inputStream2);

    }



}
