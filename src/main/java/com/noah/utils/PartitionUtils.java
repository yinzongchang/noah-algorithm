package com.noah.utils;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;

import java.util.List;

/**
 * PartitionUtils.java
 *
 * @author yinzongchang
 * 创建时间 2023/6/19
 * @since 1.0
 */
public class PartitionUtils {


    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};

        List<Integer> list = Lists.newArrayList(1);

        int batchSize = 3;
        for (int i = 0; i < list.size(); i += batchSize) {

            System.out.println(i);
            System.out.println(JSONObject.toJSONString(list.subList(i, Math.min(i + batchSize, list.size()))));
        }

        System.out.println(JSONObject.toJSONString(Lists.partition(list, batchSize)));

    }

}
