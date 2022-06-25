package com.noah.demo.encryption;

import org.bouncycastle.util.encoders.Base64;

import java.util.Map;

/**
 * Title: RSAUtilTest.java <br>
 * Description:             <br>
 * Copyright: Copyright (c) 2015<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author yinzo 2019-07-05
 */
public class RSAUtilTest {

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


    private static String privateKey2Str = "TUlJRXZnSUJBREFOQmdrcWhraUc5dzBCQVFFRkFBU0NCS2d3Z2dTa0FnRUFBb0lCQVFDSllhcWRCNDU5YzZweThqYXUvVkFLMGRJQm84YlhsTjdlRWJtdkpiMDU3eHFyWVRWVThoNzdKQUtUb21KeUtLM05SUlBHZjdaUmhTaGhuMU5vWEd6UkQ0Q0toaU9kZkFBbXNHNHpJK1FWTmplQzhaTEEyRm9TRkpMblg2eGVlU2EyeFhTQ3QvaXo1aHdnOUZjRXkwc2pydFp6cXg5WXZNcHpza2VUWkV1ak9BRmo1VGlMbWNVdzFHdEE2cmRvb3ZBUm5ReUdxS1ROK1o0dmJiSy9pTFo5cFoycCs1TFordmVPbmtjWmJpakNveW5UbGdXM1B1dW0wN2kvaUVaME1ZNU5YSDcvN2UyTVN2VDVsYS8reEx6TGhMTmx6U0JDeUhFVkJJeGVrcjZKNjdGTzJXS1JNK3liWUdVdUNDZTFsQzBHbUJrRjg2cnFBTi9xaDBBeUN4MlRBZ01CQUFFQ2dnRUFaNVBXTVl4WDl1ZTA4L01BSFpEb3Z5K1FtU0hrc2ZjUXpQY3FPdzVHQzU3bFNaOEJ1YWpPaU9TT2VNYXVXSW1vK0NHRGxsNEZsSkxEYms3VWNOTjJTMnpYcWhrV1V3OEJnaW4wKytPc2UvMmpmcnNwdlBHaGZ3NDU3KzNuSkZkTlEvRzlOUzBGZW9VY1loQTJaMnZxbTkyZTNCaUJpc0xVRk1TdVNFY082K0FiMTl1UGkyYkxkVTM1SlVlL1JUUDAzMERGM2gyQW9WZUNZOXo1OURQaVdwWXU2RFJGQUxCT05WY1haNGdvUlpvZVdCWVNDR0ZINFBMRnZMV3h5Vmlaa2tTWk5BS2IzbjJ1cXJGbnRlTzlGczc0VWdRdjFCUFg3b2JDN2VWY2lzSUJTenRMTm0xMW5ETWxCUDJiSmJKTGxLTGxEWTY2YUtXcHliQ3NYWEZQS1FLQmdRREN1RVVjNHk3dWMzVy9wMmhMYmxGUGRQa21lOWhWY1RoUmNPTExzNTdaOUEva011V0xLZzd6R1NxcjVSYWtTRm1JdFBVcTVna0JFVnA3TWpWY1UzRU80aTg2aC8yQTRhMmRpTUJ4c1A5KzhEVWRwRXE3cDd1L05VTGFNb2Z0NnFsYXpSbGYzUVZYMnNOcnpmSWUyZ0h0VE95ZmJ2Ni8vNi92cUVZQzZldDhwd0tCZ1FDMG5lWVdEckJ0RG5kZHI1dHNMM0JWd1ZiZHkydi9CVmNJYzRENHIrRGxPVDFqOXp6c1I1MmsvQXhPNDhvWTE4MmdkenpGcW5uQUVUQW5Pc3NBemh0M2UyU0FBQ2VYdmJXRDlFa29FZ2s0MlZZclhsOXlublhkVTFEakVvaldDblVBd20vM2E4WUhFdHBjOEVRS25NMEFHa0NPTzliS1JJWFRBVDc4UDdJWk5RS0JnR3JURVFlQ0UxTTZBSlUrVUZkaGxEWVZKRUxhbXBwMVhNSkJQZ3NtNWJVSTBsY05IU1UxMDdIR1VzU3ZEN2JkQWxHZmhRa2QzajY1dUh2eDFaaHJKcEZWd1RkSk4rZ201MHFQcFpRNTJGRlprcXBLWWIyRmpkaWViYWlySkN1QUc1ejIvRDY5VUpzY0p5M1RkRXM4cXVYMjE3RzRBUVp3VGFNYkhCMnBHMG50QW9HQkFKZ04yamMxbEplck54aDdEMGlMdzNHZWU4ZnJTbmIrZ3QvTmhZVlhZK2oyUUZXWlBnUFk0c0dUbzdVQ2xoQkdGWW1DK0htY1pEVXJBelB6amhXV2JvOHZKVk9SVGNPMFpVeTZhcUErVnQ4eU1SWC90REVsY0Nxc3lvcnYvcHpiWHRjTjJmOGREekREVVd3dXBjbWRhZ1F0RmEzb2VKSCtELytzcTk3bXJNUUZBb0dCQUlJOHlYQm8vVkNDSE51YlJmc1FRc0JYR1NQemRyUCszTVdyTFZkTGRkdllLRko4MXo5OGNadGVETFpqaEk2azlyNi82OHJlZ3pQQmdoT2x6cXErTjVCVTFURUlibUdBcVNQeDZqeXhzbkZ2YmtrcTQxT3l4WUhEMG9XMnp6QjZBOHN1UUpNbDJXL2JVUnlSVUtVaGlGdDUrV0NxY3NrcHg1ZmRqSU9STHhYRg==";


    public static void main(String[] args) throws Exception {

//        //生成公钥与私钥
//        Map<String, Object> initKeyMap = RSAUtils.initKey(2048);
//        //公钥
//        String publicKey = RSAUtils.getPublicKey(initKeyMap);
//        //私钥
//        String privateKey = RSAUtils.getPrivateKey(initKeyMap);
//        System.out.println("公钥 长度: " + publicKey.length() + " 值: " + publicKey);
//        System.out.println("私钥 长度: " + privateKey.length() + " 值: " + privateKey);
////
//        StringBuilder str = new StringBuilder();
//        for (int i = 0; i < 2000; i++) {
//            str.append("我爱祖国|");
//        }


        StringBuilder str = new StringBuilder("れゎわゑをザジキギグケ╰卍╘╙㊜㊪㊬╜╝✤✥♫卄卐╯ゲゴサスズセゼソゾ");

//        String str = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAjNwhrVITdzc/lTP7awVkz/sHNmUuZsKq\n" +
//                "Ez9gwkNW+tTIxxR1RpPN5gUPsy7GHanH14EvRc06zMKzxy/zxZ2e4G4NsBYnML3xiUE2mhk/dUob\n" +
//                "sCCsTznuUj1uDFPMzT6T6HaQ+n9jHOajk6KWOwY01o/5pmNwBEvVFPsS/tP7+6Ljdq/AjN1RjjWN\n" +
//                "h7wKqHpm2vVU2hnbCEaJKptpMp6NZXw4nP0SLIfNJ/jzrw9ZC4MRXq4Sl5Lq3nXL0KiqGxImd1dO\n" +
//                "Y6A6IKo1zLsz+R8mekpK/behs4pvUMAfDB/8dN/6YLEltG4OBoqWjkhUkfW3zZmFX8OV4qT1eR4R\n" +
//                "afeFiQIDAQAB";


        byte[] bytes1 = RSAUtils.encryptByPublicKey(str.toString().getBytes(), publicKeyStr);

        String base = Base64.toBase64String(bytes1);

        byte[] bytes2 = RSAUtils.decryptByPrivateKey(Base64.decode(base), privateKeyStr);

        System.out.println();
        System.out.println("****** 公钥加密 私钥解密 start ******");
        System.out.println("加密前长度 ：" + str.toString().length());
        System.out.println("加密后 ：" + Base64.toBase64String(bytes1));
        System.out.println("解密后 ：" + Base64.toBase64String(bytes2));
        System.out.println("解密后长度 ：" + new String(bytes2).length());
        System.out.println("****** 公钥加密 私钥解密 end ******");

//        System.out.println();
//        byte[] bytes3 = RSAUtils.encryptByPrivateKey(str.toString().getBytes(), privateKeyStr);
//        byte[] bytes4 = RSAUtils.decryptByPublicKey(bytes3, publicKeyStr);
//
//        System.out.println("****** 私钥加密 公钥解密 start ******");
//        System.out.println("加密前长度 ：" + str.length());
//        System.out.println("加密后 ：" + Base64.toBase64String(bytes3));
//        System.out.println("解密后 ：" + new String(bytes4));
//        System.out.println("解密后长度 ：" + new String(bytes4).length());
//        System.out.println("****** 私钥加密 公钥解密 end ******");
//

        String b2 = "RLTI7PNpqpLzqh870eadkqgQrXIDw7YvS8LVYVf79dR3pXGwsoeZAS9MYH3xue+evWV/beywNgN68PeU9xcPfu/uzQv+T3+ApAbiR19vIB9zr8Gw8CK3S0pUZxUN9V4/+xjseadc3OYjhmUveTBQw4XJIRSRAE/9MdoB9I+j8an+jph57aDP3KXIbr3VVDvmWCMYRcC6AXSMx1L39MIcHAJ8SqpTDwSTavSDWNnhKSZnLPSZbmTrUHu1hxfdw0BST53ej4OZxcb/ZwEdWxaUw8crFdKk4lrvv8tOeW0ULhdMuBqLnmy9zfaFfUsvkPswb3wJ9nN4yf7Q8NgshyyUwA==";

        byte[] res2 = RSAUtils.decryptByPrivateKey(Base64.decode(b2), Base64.toBase64String(privateKey2Str.getBytes()));

        System.out.println(new String(res2));


    }
}
