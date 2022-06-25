package com.noah.demo.spring.ioc.context;

import com.noah.demo.spring.ioc.beans.BeanDefinitionRegistry;
import com.noah.demo.spring.ioc.factory.ConfigurableListableBeanFactory;
import com.noah.demo.spring.ioc.factory.DefaultListableBeanFactory;

/**
 * Title: AbstractApplicationContext.java <br>
 * Description:             <br>
 * Copyright: Copyright (c) 2015<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author yinzo 2019-09-02
 */
public abstract class AbstractApplicationContext implements ApplicationContext {

    private ConfigurableListableBeanFactory beanFactory;

    @Override
    public Object getBean(String beanName) {
        return beanFactory.getBean(beanName);
    }

    // refresh方法先创建一个DefaultListableBeanFactory，然后通过loadBeanDefinitions解析并注册bean，真正的实现在ClasspathXmlApplicationContext中。
    public void refresh() throws Exception {

        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        loadBeanDefinitions(beanFactory);
        this.beanFactory = beanFactory;
        onRefresh();
    }

    protected void onRefresh() throws Exception {
        beanFactory.preInstantiateSingletons();
    }

    protected abstract void loadBeanDefinitions(BeanDefinitionRegistry registry) throws Exception;

}
