package com.noah.demo.encryption;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.noah.demo.http.HttpUtil;
import org.bouncycastle.util.encoders.Base64;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Title: WmsTool2.java <br>
 * Description:             <br>
 * Copyright: Copyright (c) 2015<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author yinzo 2019-07-08
 */
public class WmsTool2 {

    private String publicKeyStr =
            "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAjNwhrVITdzc/lTP7awVkz/sHNmUuZsKq\n" +
                    "Ez9gwkNW+tTIxxR1RpPN5gUPsy7GHanH14EvRc06zMKzxy/zxZ2e4G4NsBYnML3xiUE2mhk/dUob\n" +
                    "sCCsTznuUj1uDFPMzT6T6HaQ+n9jHOajk6KWOwY01o/5pmNwBEvVFPsS/tP7+6Ljdq/AjN1RjjWN\n" +
                    "h7wKqHpm2vVU2hnbCEaJKptpMp6NZXw4nP0SLIfNJ/jzrw9ZC4MRXq4Sl5Lq3nXL0KiqGxImd1dO\n" +
                    "Y6A6IKo1zLsz+R8mekpK/behs4pvUMAfDB/8dN/6YLEltG4OBoqWjkhUkfW3zZmFX8OV4qT1eR4R\n" +
                    "afeFiQIDAQAB";

    private String plaintext = "れゎわゑをザジキギグケ╰卍╘╙㊜㊪㊬╜╝✤✥♫卄卐╯ゲゴサスズセゼソゾ";

    private String urlPublicKey = "https://wms-gateway-bj.yunshanmeicai.com/api_adapt/wmsBoundingPack/com.sprucetec.wms.bounding.pack.service.PackTaskService/queryTaskKey";
    private String urlCode = "https://wms-gateway-bj.yunshanmeicai.com/api_adapt/wmsBoundingPack/com.sprucetec.wms.bounding.pack.service.PackTaskService/queryTaskCode";





    public String getPublicKey() {


        // 公钥加密后的1号密钥
        byte[] a1 = RSAUtils.encryptByPublicKey(plaintext.getBytes(), publicKeyStr);

        System.out.println("加密后文件:" + Base64.toBase64String(a1));

        List paramList = new ArrayList();
        paramList.add(1); // 仓库id
        paramList.add(Base64.toBase64String(a1)); // 秘文

        // 请求加密公钥
        String res = HttpUtil.post(urlPublicKey, JSON.toJSONString(paramList));
        System.out.println("http结果: " + res);

        JSONObject resultObject = JSONObject.parseObject(res);

        String publicKeyCipherTest = resultObject.getString("data");

        System.out.println("----1221-2-1-2--1");
        // 公钥解密过程
        byte[] publicKeyByte = RSAUtils.decryptByPublicKey(Base64.decode(publicKeyCipherTest), publicKeyStr);

        System.out.println("后续加密使用获取的公钥 --------------------- ");
//        System.out.println("解密后公钥文件:" + new String(publicKeyByte));
        System.out.println("后续加密使用获取的公钥 --------------------- ");

        return new String(publicKeyByte);
    }


    public String getCode() {

        // 公钥加密后的1号密钥
        byte[] a1 = RSAUtils.encryptByPublicKey(plaintext.getBytes(), publicKeyStr);

        List paramList = new ArrayList();
        paramList.add(5);
        paramList.add(Base64.toBase64String(a1));

        String codeRes = HttpUtil.post(urlCode, JSON.toJSONString(paramList));
        System.out.println("验证码: " + codeRes);

        JSONObject codeResObject = JSONObject.parseObject(codeRes);

        String codeCipherText = codeResObject.getString("data");

        // 公钥解密过程
        byte[] codeByte = RSAUtils.decryptByPublicKey(Base64.decode(codeCipherText), publicKeyStr);

        String code = new String(codeByte);
        System.out.println("验证码-code: " + code);

        char[] codeList = code.toCharArray();
        int factor = Integer.parseInt(String.valueOf(codeList[codeList.length - 1]));


        StringBuilder redisCodeBuilder = new StringBuilder("");
        for (int i = 0; i < codeList.length - 1; i++) {

            char a = codeList[i];
            int x = Integer.parseInt(String.valueOf(a));
            int y = (x + factor) % factor;
            redisCodeBuilder.append(y);
        }

        String redisCode = redisCodeBuilder.toString();



        return redisCode;
    }



    @Test
    public void testGetPublicKey() {

        System.out.println(getPublicKey());
    }


    @Test
    public void testGetCode() {

        System.out.println(getCode());
    }

}
