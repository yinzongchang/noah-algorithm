package com.noah.demo.spring.ioc.factory;

import com.noah.demo.spring.ioc.beans.BeanDefinition;
import com.noah.demo.spring.ioc.beans.BeanReference;
import com.noah.demo.spring.ioc.beans.PropertyValue;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Title: AbstractBeanFactory.java <br>
 * Description:             <br>
 * Copyright: Copyright (c) 2015<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author yinzo 2019-09-02
 */
public abstract class AbstractBeanFactory implements ConfigurableListableBeanFactory {

    /**
     * AbstractBeanFactory中定义了单实例(Demo默认都是单实例的bean)的beanName和bean对象关系的singleObjects的Map。
     * getBean方法传入beanName，先查询singleObjects有没有beanName的缓存，如果存在，直接返回；
     * 如果不存在则调用getBeanDefinitionByName获取BeanDefinition，getBeanDefinitionByName由AbstractBeanFactory的子类实现，
     * 也就是DefaultListableBeanFactory。
     */

    private Map<String, Object> singleObjects = new ConcurrentHashMap<>();

    @Override
    public Object getBean(String beanName) {
        Object singleBean = this.singleObjects.get(beanName);
        if (singleBean != null) {
            return singleBean;
        }

        BeanDefinition beanDefinition = getBeanDefinitionByName(beanName);
        if (beanDefinition == null) {
            throw new RuntimeException("bean for name '" + beanName + "' not register.");
        }

        singleBean = doCreateBean(beanDefinition);
        this.singleObjects.put(beanName, singleBean);
        return singleBean;
    }

    protected abstract BeanDefinition getBeanDefinitionByName(String beanName);


    /**
     * 拿到BeanDefinition后，进入真正创建bean的方法doCreateBean。
     * 它做了两个操作，一个是创建bean对象，另一个是注入依赖属性。
     *
     * @param beanDefinition
     * @return
     */
    protected Object doCreateBean(BeanDefinition beanDefinition) {
        Object bean = createInstance(beanDefinition);
        applyPropertyValues(bean, beanDefinition);
        return bean;
    }


    /**
     * 创建bean对象
     *
     * @param beanDefinition
     * @return
     */
    protected Object createInstance(BeanDefinition beanDefinition) {
        try {
            if (beanDefinition.getBeanClass() != null) {
                return beanDefinition.getBeanClass().newInstance();
            } else if (beanDefinition.getBeanClassName() != null) {
                try {
                    Class clazz = Class.forName(beanDefinition.getBeanClassName());
                    beanDefinition.setBeanClass(clazz);
                    return clazz.newInstance();
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException("bean Class " + beanDefinition.getBeanClassName() + " not found");
                }
            }
        } catch (Exception e) {
            throw new RuntimeException("create bean " + beanDefinition.getBeanName() + " failed");
        }
        throw new RuntimeException("bean name for " + beanDefinition.getBeanName() + " not define bean class");
    }


    /**
     * 注入依赖属性
     *
     * @param bean
     * @param beanDefinition
     */
    protected void applyPropertyValues(Object bean, BeanDefinition beanDefinition) {

        for (PropertyValue propertyValue : beanDefinition.getPropertyValues().getPropertyValues()) {
            String name = propertyValue.getName();
            Object value = propertyValue.getValue();
            if (value instanceof BeanReference) {
                BeanReference reference = (BeanReference) value;
                value = getBean(reference.getRef());
            }
            try {
                Method method = bean.getClass().getDeclaredMethod("set" + name.substring(0, 1).toUpperCase() +
                        name.substring(1), value.getClass());
                method.setAccessible(true);
                method.invoke(bean, value);
            } catch (Exception e) {
                try {
                    Field field = bean.getClass().getDeclaredField(name);
                    field.setAccessible(true);
                    field.set(bean, value);
                } catch (Exception e1) {
                    throw new RuntimeException("inject bean property " + name + " failed");
                }
            }
        }
    }

}
