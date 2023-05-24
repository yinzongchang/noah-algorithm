package com.noah.http;

import okhttp3.Headers;
import okhttp3.Response;
import org.junit.Test;

import java.io.IOException;

/**
 * TestHttp.java
 *
 * @author yinzongchang
 * 创建时间 2022/11/17
 * @since 1.0
 */
public class TestHttp {

    @Test
    public void testGet() throws IOException {

        String url = "https://kapi.sre.gotokeep.com/mock/2110/internal/third/v1/hr/staff/getCommonInfo";
        Response get = HttpClient.get(url);
        System.out.println(get.body().string());
    }

    @Test
    public void testGet2() throws IOException {

        String url = "https://proxy.cms.pre.gotokeep.com/api/polaris/internal/v1/purchaseorder/contractChangeLog/list?code=PO20221107113238156060&pageNo=1&pageSize=10";

        Headers.Builder headersBuilder = new Headers.Builder();
        headersBuilder
                .add("Authorization", "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJuYW1lIjoieWluem9uZ2NoYW5nIiwiZ2l2ZW5OYW1lIjoiJUU1JUIwJUI5JUU1JUFFJTk3JUU2JTk4JThDIiwibWFpbCI6InlpbnpvbmdjaGFuZyU0MGtlZXAuY29tIiwibWVtYmVyT2YiOiJjbj1LZWVwLU9wLG91PWdyb3VwLGRjPWdvdG9rZWVwLGRjPWNvbSIsImlhdCI6MTY2NzgxMTIwNCwiZXhwIjoxNjcwNDAzMjA0fQ._sdsreIEdoH4B4UNh6MTN3XfJn7w0RO92mW9n-CIxYU")
//                .add("Origin", "https://ark.pre.gotokeep.com")
//                .add("Referer", "https://ark.pre.gotokeep.com/polaris-web/purchase/order")
                .add("x-route-key", "yin");
        Response get = HttpClient.get(url, headersBuilder.build());
        System.out.println(get);
        System.out.println(get.body().string());
    }


    @Test
    public void testGetHr() throws IOException {

        String url = "http://keep-mdm-webapp.http.svc.ali.keep/internal/third/v1/hr/staff/getCommonInfo";

        Headers.Builder headersBuilder = new Headers.Builder();
        headersBuilder
                .add("Authorization", "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJuYW1lIjoieWluem9uZ2NoYW5nIiwiZ2l2ZW5OYW1lIjoiJUU1JUIwJUI5JUU1JUFFJTk3JUU2JTk4JThDIiwibWFpbCI6InlpbnpvbmdjaGFuZyU0MGtlZXAuY29tIiwibWVtYmVyT2YiOiJjbj1LZWVwLU9wLG91PWdyb3VwLGRjPWdvdG9rZWVwLGRjPWNvbSIsImlhdCI6MTY2NzgxMTIwNCwiZXhwIjoxNjcwNDAzMjA0fQ._sdsreIEdoH4B4UNh6MTN3XfJn7w0RO92mW9n-CIxYU")
//                .add("Origin", "https://ark.pre.gotokeep.com")
                .add("eeAuthCode", "pZzzLnrrZzkdFdRzSChHlUNqK8Giz9tj")
//                .add("Referer", "https://ark.pre.gotokeep.com/polaris-web/purchase/order")
                .add("x-route-key", "yin");
        Response get = HttpClient.get(url, headersBuilder.build());
        System.out.println(get);
        System.out.println(get.body().string());
    }

    @Test
    public void testPost() throws IOException {

        String url = "https://proxy.cms.pre.gotokeep.com/api/polaris/internal/v1/inbound/order/operation/batch";

        Headers headers = new Headers.Builder()
                .add("Content-Type", "application/json;charset=UTF-8")
                .add("Authorization", "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJuYW1lIjoieWluem9uZ2NoYW5nIiwiZ2l2ZW5OYW1lIjoiJUU1JUIwJUI5JUU1JUFFJTk3JUU2JTk4JThDIiwibWFpbCI6InlpbnpvbmdjaGFuZyU0MGtlZXAuY29tIiwibWVtYmVyT2YiOiJjbj1LZWVwLU9wLG91PWdyb3VwLGRjPWdvdG9rZWVwLGRjPWNvbSIsImlhdCI6MTY2NzgxMTIwNCwiZXhwIjoxNjcwNDAzMjA0fQ._sdsreIEdoH4B4UNh6MTN3XfJn7w0RO92mW9n-CIxYU")
                .add("Origin", "https://ark.pre.gotokeep.com")
                .add("Referer", "https://ark.pre.gotokeep.com/polaris-web/stock/entry/new")
                .add("x-route-key", "yin")
                .build();

        String json = "[{\"isCheck\":true,\"outerCode\":\"\",\"businessType\":10,\"businessCode\":\"1111\",\"warehouseCode\":\"BEST-113\",\"warehouseProvider\":\"BEST\",\"stockType\":0,\"selectedSku\":0,\"expectCompleteTime\":\"2022-11-16 00:00:00\",\"description\":\"\",\"logistics\":{\"senderName\":\"111\",\"senderMobileNumber\":\"15555555555\",\"senderAddress\":[\"河北省\",\"秦皇岛市\",\"北戴河区\"],\"senderProvince\":\"河北省\",\"senderCity\":\"秦皇岛市\",\"senderDistinct\":\"北戴河区\",\"senderShippingAddress\":\"222\",\"outLogisticsNo\":\"\",\"sendTime\":\"\",\"logisticsProviderCode\":\"\"},\"items\":[{\"extValues\":{},\"inWarehouseQuantity\":0,\"inTransitQuantity\":1,\"lockedQuantity\":0,\"goodAvailableQuantity\":0,\"skuCode\":20019889,\"skuId\":51004697,\"productId\":11117,\"skuName\":\"哈哈哈1\",\"imageUrl\":\"http://static2.keepcdn.com/2021/09/17/1631848271471.jpg\",\"goodQualityQuantity\":0,\"defectiveQuantity\":0,\"goodQualityLockedQuantity\":0,\"defectiveLockedQuantity\":0,\"availableQuantity\":0,\"expectQuantity\":1,\"stockType\":0}]}]";


        Response get = HttpClient.post(url, json, headers);
        System.out.println(get);
        System.out.println(get.body().string());
    }







}
