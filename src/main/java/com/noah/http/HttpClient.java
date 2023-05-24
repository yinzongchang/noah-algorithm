package com.noah.http;

import okhttp3.*;

import java.io.IOException;

/**
 * HttpClient.java
 *
 * @author yinzongchang
 * 创建时间 2022/11/17
 * @since 1.0
 */
public class HttpClient {


    private static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");
    private static OkHttpClient client = new OkHttpClient();

    public static Response post(String url, String json) throws IOException {
        RequestBody body = RequestBody.create(JSON, json);
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();
        Response response = client.newCall(request).execute();
        return response;
    }

    public static Response post(String url, String json, Headers headers) throws IOException {
        RequestBody body = RequestBody.create(JSON, json);
        Request request = new Request.Builder()
                .headers(headers)
                .url(url)
                .post(body)
                .build();
        System.out.println(request.headers().toString());
        Response response = client.newCall(request).execute();
        return response;
    }

    public static Response get(String url) throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .get()
                .build();
        Response response = client.newCall(request).execute();
        return response;
    }

    public static Response get(String url, Headers headers) throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .headers(headers)
                .get()
                .build();
        Response response = client.newCall(request).execute();
        return response;
    }

}
