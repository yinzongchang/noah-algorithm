package com.noah.demo.lambda;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.List;

/**
 * TestForeach.java
 *
 * @author yinzongchang
 * 创建时间 2023/6/12
 * @since 1.0
 */
public class TestFor {


    @Test
    public void test() {

        List<Integer> list1 = Lists.newArrayList(1, 2, 3);
        List<Integer> list2 = Lists.newArrayList(11, 12, 13);

        list2.forEach(a -> {

            list1.forEach(b -> {

                if (b == 2) {
                    return;
                }
                System.out.println("===" + b);
            });

            System.out.println("======" + a);
        });

    }

}
