package com.noah.demo.spring.ioc.context;

import com.noah.demo.spring.ioc.beans.BeanDefinitionRegistry;
import com.noah.demo.spring.ioc.resource.ResourceLoader;
import com.noah.demo.spring.ioc.xml.XmlBeanDefinitionReader;

/**
 * Title: ClasspathXmlApplicationContext.java <br>
 * Description:             <br>
 * Copyright: Copyright (c) 2015<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author yinzo 2019-09-02
 */
public class ClasspathXmlApplicationContext extends AbstractApplicationContext {

    private String location;

    public ClasspathXmlApplicationContext(String location) {
        this.location = location;
        try {
            refresh();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void loadBeanDefinitions(BeanDefinitionRegistry registry) throws Exception {

        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(registry, new ResourceLoader());
        reader.loadBeanDefinitions(location);
    }


}