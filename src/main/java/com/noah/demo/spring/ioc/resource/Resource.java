package com.noah.demo.spring.ioc.resource;

import java.io.IOException;
import java.io.InputStream;

/**
 * Title: Resource.java <br>
 * Description:             <br>
 * Copyright: Copyright (c) 2015<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author yinzo 2019-09-02
 */
public interface Resource {

    InputStream getInputStream() throws IOException;

}
