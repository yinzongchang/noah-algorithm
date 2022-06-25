package com.noah.demo.spring.ioc.beans;

/**
 * Title: BeanDefinitionRegistry.java <br>
 * Description:             <br>
 * Copyright: Copyright (c) 2015<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author yinzo 2019-09-02
 */
public interface BeanDefinitionRegistry {

    // 它只定义了一个方法，就是注册BeanDefinition。
    // 它的实现类就是要实现这个方法并将BeanDefinition注册到Map<String,BeanDefinition>中。
    // 在这里这个实现类是DefaultListableBeanFactory。
    void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);

}
