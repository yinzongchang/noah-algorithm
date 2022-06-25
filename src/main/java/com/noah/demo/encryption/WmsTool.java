package com.noah.demo.encryption;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.noah.demo.http.HttpUtil;
import org.bouncycastle.util.encoders.Base64;

import java.util.ArrayList;
import java.util.List;

/**
 * Title: WmsTool.java <br>
 * Description:             <br>
 * Copyright: Copyright (c) 2015<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author yinzo 2019-07-05
 */
public class WmsTool {

    private static String publicKeyStr =
            "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAjNwhrVITdzc/lTP7awVkz/sHNmUuZsKq\n" +
                    "Ez9gwkNW+tTIxxR1RpPN5gUPsy7GHanH14EvRc06zMKzxy/zxZ2e4G4NsBYnML3xiUE2mhk/dUob\n" +
                    "sCCsTznuUj1uDFPMzT6T6HaQ+n9jHOajk6KWOwY01o/5pmNwBEvVFPsS/tP7+6Ljdq/AjN1RjjWN\n" +
                    "h7wKqHpm2vVU2hnbCEaJKptpMp6NZXw4nP0SLIfNJ/jzrw9ZC4MRXq4Sl5Lq3nXL0KiqGxImd1dO\n" +
                    "Y6A6IKo1zLsz+R8mekpK/behs4pvUMAfDB/8dN/6YLEltG4OBoqWjkhUkfW3zZmFX8OV4qT1eR4R\n" +
                    "afeFiQIDAQAB";


    private static String privateKeyStr =
            "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQCM3CGtUhN3Nz+VM/trBWTP+wc2\n" +
                    "ZS5mwqoTP2DCQ1b61MjHFHVGk83mBQ+zLsYdqcfXgS9FzTrMwrPHL/PFnZ7gbg2wFicwvfGJQTaa\n" +
                    "GT91ShuwIKxPOe5SPW4MU8zNPpPodpD6f2Mc5qOTopY7BjTWj/mmY3AES9UU+xL+0/v7ouN2r8CM\n" +
                    "3VGONY2HvAqoemba9VTaGdsIRokqm2kyno1lfDic/RIsh80n+POvD1kLgxFerhKXkuredcvQqKob\n" +
                    "EiZ3V05joDogqjXMuzP5HyZ6Skr9t6Gzim9QwB8MH/x03/pgsSW0bg4GipaOSFSR9bfNmYVfw5Xi\n" +
                    "pPV5HhFp94WJAgMBAAECggEAQqpYgfgLYGvUet/8SN1npgtPkY33lQjih3OCbs6CFvqn/5iOHJYN\n" +
                    "Z6TTlmE3wIg/HZ51ahrEjm5DuazXOZrsu5k6fzEs4SO0cdpcZjg20WL+kbAU/PYU9fU+5TSwBB9u\n" +
                    "zyF2YifyF5aMqm3TniHE1huT8wyy0kW1llVx2wsnAiOMz7vnDh/PHlWC9MrzGS1jXXlIISZnjXNk\n" +
                    "+IeMhY+8/Q+NE9dGyenTrntveJkVIiV7H791xAEQhhu9QrRmQGgd3JgXovQjmDqyfwBh97Sb/MUp\n" +
                    "0Fcv7Fd9RH3c3ncFTFLjz8zu0yysr52NIHphj0O7Cmhv49mYStADv4wSgDB8gQKBgQD/Kgn+nHcD\n" +
                    "+JXPTpxGpFzitgc+bPEWwFRyiWA6CgDYpgILv50cldHgLovzpxX/0N262rQXjJ4Oe0zbNbJzygfj\n" +
                    "LpIovESNFe7LX6dFCffefChQv6yr4G5bS42uElFYVB0qFuQ65YfAm59kCyMcw4Xc5fc/hXsVXDwv\n" +
                    "vTZ7EziIMQKBgQCNUj7pdwyJG5k2TSXfy+NfsIRMCa7lvfjA94ra7i3IlTb1EU2dYa9RZH967RI3\n" +
                    "+2Cd4+cNEI/h+1hBHWuFI7NLB0lzC/qVxawdrc2Y0OhgEspDKIBGHFcFGzdmEfdZeumvydTaGia4\n" +
                    "8T49AJYzS20Wb7sUnjGF5QzQqlFdPRxU2QKBgQC78asK7xR6yE8QM0bIgagpFQqg4H1z1JZfBvDp\n" +
                    "zxRwf1ZicPC4bWH5Tk+nWBrMInwvdYfRELIa2Jbzn8mhn93PaC4f8wxLHyyUgBAkugLozWqkj4oP\n" +
                    "z295r1zcKoHgHZSdu96/wvEK3ZW5irqCJUIkQv6quxa91QI/546JeM7bAQKBgAwcMCfxe7GEG+z7\n" +
                    "T3OOFT3t8mhRrBsj3F0s2UlJf8LghoUZpn0GEe/3nLT7+8OwVucw0GveL3Y+A6IQ01XlaUfUqAaj\n" +
                    "0CVlewpQCn496KvS8GIw5k0bwJk/a8/jWj7guYXG1eaatxbCFYNEuZpLrF1v1ag+ph/DMQXwkmhb\n" +
                    "BEKBAoGBANxTMQj9r5EOwOn3zojwv7bekg27+so4qR4eshjAFVMOYsRqKDoeJXmErm6qoRRziFRP\n" +
                    "Mvb2juEt2QYTSNICZj2k+vOMdCH6FuX85Fbkm23EzYTz9gcoFDfhMpm1MLPI9pDeB12VIveUogwX\n" +
                    "Fy9lyoVQu9IpJ7VW3jq5FAhgb2hv";


    private static String plaintext = "れゎわゑをザジキギグケ╰卍╘╙㊜㊪㊬╜╝✤✥♫卄卐╯ゲゴサスズセゼソゾ";
    private static String plaintext2 = "れゎザジ☃☂✄¢€£キギグケ╰╙㊜㊪㊬╜✤✥♫卄卐╯ゲとどゴサスセゼソ";


    private static String urlPublicKey = "https://wms-gateway.test.yunshanmeicai.com/api_adapt/wmsBoundingPack/com.sprucetec.wms.bounding.pack.service.PackTaskService/queryTaskKey";
    private static String urlCode = "https://wms-gateway.test.yunshanmeicai.com/api_adapt/wmsBoundingPack/com.sprucetec.wms.bounding.pack.service.PackTaskService/queryTaskCode";
    private static String urlSQL = "https://wms-gateway.test.yunshanmeicai.com/api_adapt/wmsBoundingPack/com.sprucetec.wms.bounding.pack.service.PackService/submitTask";



    public static void main(String[] args) throws Exception {

        // 加密后的1号密钥
        byte[] a1 = RSAUtils.encryptByPublicKey(plaintext.getBytes(), publicKeyStr);

        System.out.println("加密后文件:" + Base64.toBase64String(a1));

        List paramList = new ArrayList();
        paramList.add(1);
        paramList.add(Base64.toBase64String(a1));

        // 请求加密公钥
        String res = HttpUtil.post(urlPublicKey, JSON.toJSONString(paramList));
        System.out.println("http结果: " + res);

        JSONObject resultObject = JSONObject.parseObject(res);

        String publicKeyCipherTest = resultObject.getString("data");

        System.out.println("----1221-2-1-2--1");
        // 公钥解密过程
        byte[] publicKeyByte = RSAUtils.decryptByPublicKey(Base64.decode(publicKeyCipherTest), publicKeyStr);

        System.out.println("后续加密使用获取的公钥 --------------------- ");
        System.out.println("解密后公钥文件:" + Base64.toBase64String(publicKeyByte));
        System.out.println("后续加密使用获取的公钥 --------------------- ");

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

        char[] redisCodeList = redisCode.toCharArray();

        int last = Integer.parseInt(String.valueOf(redisCodeList[redisCodeList.length - 1]));


        StringBuilder padding = new StringBuilder("");
        for (int i = 0; i < last; i++) {

            int random = (int) (Math.random() * 10);
            padding.append(random);
        }

        String plaintextSql = new StringBuilder(plaintext2).append(padding).append(redisCode).toString();

        System.out.println("SQL加密内容: " + plaintextSql);

        // 二次加密code
        byte[] encryptPublicKey2 = RSAUtils.encryptByPublicKey(plaintextSql.getBytes(), new String(publicKeyByte));

        String encryptPublicKey2Base = Base64.toBase64String(encryptPublicKey2);

        List sqlParam = new ArrayList();
        sqlParam.add(1);
        sqlParam.add(encryptPublicKey2Base);
        sqlParam.add("update wms_master.t_wms_class1 set u_t = unix_timestamp();");


        System.out.println("参数: " + JSON.toJSONString(sqlParam));

        String sqlResult = HttpUtil.post(urlSQL, JSON.toJSONString(sqlParam));

        System.out.println("SQL result: " + sqlResult);




        // https://www.cnblogs.com/mengq0815/p/10596071.html


    }

}
