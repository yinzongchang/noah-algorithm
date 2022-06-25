package com.noah.demo.spring.ioc.factory;

import com.noah.demo.spring.ioc.beans.BeanDefinition;
import com.noah.demo.spring.ioc.beans.BeanDefinitionRegistry;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Title: DefaultListableBeanFactory.java <br>
 * Description:             <br>
 * Copyright: Copyright (c) 2015<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author yinzo 2019-09-02
 */
public class DefaultListableBeanFactory extends AbstractBeanFactory implements ConfigurableListableBeanFactory, BeanDefinitionRegistry {

    /**
     * 可以看出它包含一个beanDefinitionMap 和 beanDefinitionNames，
     * 一个记录beanName和BeanDefinition的关系，一个记录所有BeanName。
     * 而registerBeanDefinition方法就是将BeanDefinition添加到beanDefinitionMap和beanDefinitionNames。
     */
    private Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<>();
    private List<String> beanDefinitionNames = new ArrayList<>();

    public void registerBeanDefinition(String beanName, BeanDefinition beanDefinition) {
        beanDefinitionMap.put(beanName, beanDefinition);
        beanDefinitionNames.add(beanName);
    }

    @Override
    protected BeanDefinition getBeanDefinitionByName(String beanName) {
        return beanDefinitionMap.get(beanName);
    }

    @Override
    public void preInstantiateSingletons() throws Exception {
        for (String beanName : beanDefinitionNames) {
            getBean(beanName);
        }
    }
}
