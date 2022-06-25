package com.noah.demo.spring.ioc.resource;

/**
 * Title: ResourceLoader.java <br>
 * Description:             <br>
 * Copyright: Copyright (c) 2015<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author yinzo 2019-09-02
 */
public class ResourceLoader {

    final String CLASSPATH_URL_PREFIX = "classpath:";

    public Resource getResource(String location) {

//        return new ClassPathResource(location);

        if (location.startsWith(CLASSPATH_URL_PREFIX)) {
            return new ClassPathResource(location.substring(CLASSPATH_URL_PREFIX.length()));
        } else {
            return new ClassPathResource(location);
        }
    }

}
