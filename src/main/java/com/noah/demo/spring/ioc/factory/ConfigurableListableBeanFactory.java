package com.noah.demo.spring.ioc.factory;

/**
 * Title: ConfigurableListableBeanFactory.java <br>
 * Description:             <br>
 * Copyright: Copyright (c) 2015<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author yinzo 2019-09-02
 */
public interface ConfigurableListableBeanFactory extends BeanFactory {

    void preInstantiateSingletons() throws Exception;
}
