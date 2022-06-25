package com.noah.demo.spring.ioc.xml;

/**
 * Title: BeanDefinitionReader.java <br>
 * Description:             <br>
 * Copyright: Copyright (c) 2015<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author yinzo 2019-09-02
 */
public interface BeanDefinitionReader {

    void loadBeanDefinitions(String location) throws Exception;

}
