package com.noah.demo.spring.ioc.factory;

/**
 * Title: BeanFactory.java <br>
 * Description:             <br>
 * Copyright: Copyright (c) 2015<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author yinzo 2019-09-02
 */
public interface BeanFactory {

    /**
     * DefaultListableBeanFactory实现了ConfigurableListableBeanFactory接口，
     * 而ConfigurableListableBeanFactory继承了BeanFactory接口。BeanFactory是一个顶级接口。
     */
    Object getBean(String beanName);

}
