package com.noah.demo.http;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Title: HttpUtil.java <br>
 * Description:             <br>
 * Copyright: Copyright (c) 2015<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author yinzo 2019-07-06
 */
public class HttpUtil {


//    private static Logger logger = Logger.getLogger(HttpUtil.class);

    /**
     * CloseableHttpClient
     *
     * @return
     */
    public static CloseableHttpClient createDefault() {
        return HttpClientBuilder.create().build();
    }

    /**
     * get请求
     *
     * @param url
     * @return
     */
    public static String get(String url) {
        try {
            CloseableHttpClient client = HttpUtil.createDefault();
            HttpGet request = new HttpGet(url);
            HttpResponse response = client.execute(request);
            int code = response.getStatusLine().getStatusCode();
//            logger.info("请求URL：" + url + ";code："+ code);
            if (code == HttpStatus.SC_OK) {
                String result = EntityUtils.toString(response.getEntity());
                return result;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * key-value格式的参数
     *
     * @param url
     * @param params
     * @return
     */
    public static String post(String url, Map<String, Object> params) {
        BufferedReader in = null;
        try {
            CloseableHttpClient client = HttpUtil.createDefault();
            HttpPost request = new HttpPost(url);
            List<NameValuePair> nvps = new ArrayList<>();
            for (Iterator<String> iter = params.keySet().iterator(); iter.hasNext(); ) {
                String key = (String) iter.next();
                String value = String.valueOf(params.get(key));
                nvps.add(new BasicNameValuePair(key, value));
            }
            request.setEntity(new UrlEncodedFormEntity(nvps, StandardCharsets.UTF_8));
            HttpResponse response = client.execute(request);
            int code = response.getStatusLine().getStatusCode();
//            logger.info("请求URL：" + url + ";code："+ code);
            if (code == HttpStatus.SC_OK) {
                in = new BufferedReader(new InputStreamReader(response.getEntity().getContent(), StandardCharsets.UTF_8));
                StringBuffer sb = new StringBuffer("");
                String line = "";
                String NL = System.getProperty("line.separator");
                while ((line = in.readLine()) != null) {
                    sb.append(line + NL);
                }
                in.close();
                return sb.toString();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 请求json格式的参数
     *
     * @param url
     * @param params
     * @return
     */
    public static String post(String url, String params) {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(url);
        httpPost.setHeader("Accept", "application/json");
        httpPost.setHeader("Content-Type", "application/json");
        StringEntity entity = new StringEntity(params, StandardCharsets.UTF_8);
        httpPost.setEntity(entity);
        CloseableHttpResponse response = null;
        try {
            response = httpclient.execute(httpPost);
            int code = response.getStatusLine().getStatusCode();
//            logger.info("请求URL：" + url + ";code：" + code);
            if (code == HttpStatus.SC_OK) {
                HttpEntity responseEntity = response.getEntity();
                String jsonString = EntityUtils.toString(responseEntity);
                return jsonString;
            }
            if (response != null) {
                response.close();
            }
            httpclient.close();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return null;

    }

}
