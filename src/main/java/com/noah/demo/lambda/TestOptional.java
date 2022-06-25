package com.noah.demo.lambda;

import org.junit.Test;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Title: TestOptional.java <br>
 * Description:             <br>
 * Copyright: Copyright (c) 2015<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author yinzo 2019-07-24
 */
public class TestOptional {


    @Test
    public void testNull() {

        List<Object> longList = new ArrayList<>();

        longList.add(1L);
        longList.add(null);

        Optional<Object> optionalLong = longList.stream().findFirst();

        if (optionalLong.isPresent()) {
            System.out.println(optionalLong.get());
        } else {
            System.out.println("没有");
        }



    }
}
