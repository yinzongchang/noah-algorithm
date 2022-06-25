package com.noah.demo.encryption;

import org.bouncycastle.util.encoders.Base64;

/**
 * Title: MainTest.java <br>
 * Description:             <br>
 * Copyright: Copyright (c) 2015<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author yinzo 2019-07-04
 */
public class MainTest {

    public static void main(String[] args) throws Exception {

//        // RSAEncrypt.genKeyPair(filepath);
//
//        String publicKeyStr =
//                "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAjNwhrVITdzc/lTP7awVkz/sHNmUuZsKq\n" +
//                "Ez9gwkNW+tTIxxR1RpPN5gUPsy7GHanH14EvRc06zMKzxy/zxZ2e4G4NsBYnML3xiUE2mhk/dUob\n" +
//                "sCCsTznuUj1uDFPMzT6T6HaQ+n9jHOajk6KWOwY01o/5pmNwBEvVFPsS/tP7+6Ljdq/AjN1RjjWN\n" +
//                "h7wKqHpm2vVU2hnbCEaJKptpMp6NZXw4nP0SLIfNJ/jzrw9ZC4MRXq4Sl5Lq3nXL0KiqGxImd1dO\n" +
//                "Y6A6IKo1zLsz+R8mekpK/behs4pvUMAfDB/8dN/6YLEltG4OBoqWjkhUkfW3zZmFX8OV4qT1eR4R\n" +
//                "afeFiQIDAQAB";
//        String privateKeyStr =
//                "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQCM3CGtUhN3Nz+VM/trBWTP+wc2\n" +
//                "ZS5mwqoTP2DCQ1b61MjHFHVGk83mBQ+zLsYdqcfXgS9FzTrMwrPHL/PFnZ7gbg2wFicwvfGJQTaa\n" +
//                "GT91ShuwIKxPOe5SPW4MU8zNPpPodpD6f2Mc5qOTopY7BjTWj/mmY3AES9UU+xL+0/v7ouN2r8CM\n" +
//                "3VGONY2HvAqoemba9VTaGdsIRokqm2kyno1lfDic/RIsh80n+POvD1kLgxFerhKXkuredcvQqKob\n" +
//                "EiZ3V05joDogqjXMuzP5HyZ6Skr9t6Gzim9QwB8MH/x03/pgsSW0bg4GipaOSFSR9bfNmYVfw5Xi\n" +
//                "pPV5HhFp94WJAgMBAAECggEAQqpYgfgLYGvUet/8SN1npgtPkY33lQjih3OCbs6CFvqn/5iOHJYN\n" +
//                "Z6TTlmE3wIg/HZ51ahrEjm5DuazXOZrsu5k6fzEs4SO0cdpcZjg20WL+kbAU/PYU9fU+5TSwBB9u\n" +
//                "zyF2YifyF5aMqm3TniHE1huT8wyy0kW1llVx2wsnAiOMz7vnDh/PHlWC9MrzGS1jXXlIISZnjXNk\n" +
//                "+IeMhY+8/Q+NE9dGyenTrntveJkVIiV7H791xAEQhhu9QrRmQGgd3JgXovQjmDqyfwBh97Sb/MUp\n" +
//                "0Fcv7Fd9RH3c3ncFTFLjz8zu0yysr52NIHphj0O7Cmhv49mYStADv4wSgDB8gQKBgQD/Kgn+nHcD\n" +
//                "+JXPTpxGpFzitgc+bPEWwFRyiWA6CgDYpgILv50cldHgLovzpxX/0N262rQXjJ4Oe0zbNbJzygfj\n" +
//                "LpIovESNFe7LX6dFCffefChQv6yr4G5bS42uElFYVB0qFuQ65YfAm59kCyMcw4Xc5fc/hXsVXDwv\n" +
//                "vTZ7EziIMQKBgQCNUj7pdwyJG5k2TSXfy+NfsIRMCa7lvfjA94ra7i3IlTb1EU2dYa9RZH967RI3\n" +
//                "+2Cd4+cNEI/h+1hBHWuFI7NLB0lzC/qVxawdrc2Y0OhgEspDKIBGHFcFGzdmEfdZeumvydTaGia4\n" +
//                "8T49AJYzS20Wb7sUnjGF5QzQqlFdPRxU2QKBgQC78asK7xR6yE8QM0bIgagpFQqg4H1z1JZfBvDp\n" +
//                "zxRwf1ZicPC4bWH5Tk+nWBrMInwvdYfRELIa2Jbzn8mhn93PaC4f8wxLHyyUgBAkugLozWqkj4oP\n" +
//                "z295r1zcKoHgHZSdu96/wvEK3ZW5irqCJUIkQv6quxa91QI/546JeM7bAQKBgAwcMCfxe7GEG+z7\n" +
//                "T3OOFT3t8mhRrBsj3F0s2UlJf8LghoUZpn0GEe/3nLT7+8OwVucw0GveL3Y+A6IQ01XlaUfUqAaj\n" +
//                "0CVlewpQCn496KvS8GIw5k0bwJk/a8/jWj7guYXG1eaatxbCFYNEuZpLrF1v1ag+ph/DMQXwkmhb\n" +
//                "BEKBAoGBANxTMQj9r5EOwOn3zojwv7bekg27+so4qR4eshjAFVMOYsRqKDoeJXmErm6qoRRziFRP\n" +
//                "Mvb2juEt2QYTSNICZj2k+vOMdCH6FuX85Fbkm23EzYTz9gcoFDfhMpm1MLPI9pDeB12VIveUogwX\n" +
//                "Fy9lyoVQu9IpJ7VW3jq5FAhgb2hv";
//
//        Base64 base64 = new Base64();
//
//        System.out.println("--------------公钥加密私钥解密过程-------------------");
//        String plainText = "ihep_公钥加密私钥解密 れゎわゑをオカキギグケ╰卍╘╙㊜㊪㊬╜╝✤✥♫卄卐╯ゲゴサザジスズセゼソゾ";
//        // 公钥加密过程
//        byte[] cipherData = RSAEncrypt.encrypt(RSAEncrypt.loadPublicKeyByStr(publicKeyStr),
//                plainText.getBytes());
//        String cipher = new String(base64.encode(cipherData));
//        // 私钥解密过程
//        byte[] res = RSAEncrypt.decrypt(RSAEncrypt.loadPrivateKeyByStr(privateKeyStr),
//                base64.decode(cipher));
//        String restr = new String(res);
//        System.out.println("原文：" + plainText);
//        System.out.println("加密：" + cipher);
//        System.out.println("解密：" + restr);
//        System.out.println();
//
//        System.out.println("--------------私钥加密公钥解密过程-------------------");
//        plainText = "ihep_私钥加密公钥解密";
//        // 私钥加密过程
//        cipherData = RSAEncrypt.encrypt(RSAEncrypt.loadPrivateKeyByStr(privateKeyStr),
//                plainText.getBytes());
//        cipher = new String(base64.encode(cipherData));
//        // 公钥解密过程
//        res = RSAEncrypt.decrypt(RSAEncrypt.loadPublicKeyByStr(publicKeyStr),
//                base64.decode(cipher));
//        restr = new String(res);
//        System.out.println("原文：" + plainText);
//        System.out.println("加密：" + cipher);
//        System.out.println("解密：" + restr);
//        System.out.println();
//
//        System.out.println("---------------私钥签名过程------------------");
//        String content = "ihep_这是用于签名的原始数据";
//        String signstr = RSASignature.sign(content, privateKeyStr);
//        System.out.println("签名原串：" + content);
//        System.out.println("签名串：" + signstr);
//        System.out.println();
//
//        System.out.println("---------------公钥校验签名------------------");
//        System.out.println("签名原串：" + content);
//        System.out.println("签名串：" + signstr);
//
//        System.out.println("验签结果：" + RSASignature.doCheck(content, signstr, publicKeyStr));
//        System.out.println();
//
//
//        System.out.println(a(8));
//
//
//        System.out.println((int) (Math.random() * 10));
//
//
//        String str = "9090902";
//
//        System.out.println("90".equals(str.substring(0, 2)));
//
//        System.out.println("れゎザジ☃☂✄¢€£キギグケ╰╙㊜㊪㊬╜✤✥♫卄卐╯ゲとどゴサスセゼソ7857888884".length());
//
//
//        System.out.println("れゎザジ☃☂✄¢€£キギグケ╰╙㊜㊪㊬╜✤✥♫卄卐╯ゲとどゴサスセゼソ7857888884".substring(39));


        System.out.println("れゎザジ☃☂✄¢ギグケ╰╙㊜㊪㊬╜✤✥♫卄卐╯€£キゲゴサスとどセゼソ".length());
        System.out.println("れザジゎ☃✄¢キギグケ☂╰╙㊜㊪㊬╜✤✥♫卄卐╯ゲとどゴ€£サスセゼソ".length());
        System.out.println("れゎザジ✄¢€£グキギケ╰╙㊜㊪㊬╜✤✥♫卐╯ゲと卄どゴ☃スセ☂サゼソ".length());
        System.out.println("れゎ☃☂✄¢€£ザジキギ╰╙㊜㊪㊬╜✤✥♫卐卄╯ゲとどゴサグケスセゼソ".length());


    }


    public static String a(int length) {

        StringBuilder s = new StringBuilder("");

        for (int i = 0; i < length; i++) {

            s.append(getRandomDigitLetter());
        }

        return s.toString();
    }

    public static char getRandomCharacter(char ch1, char ch2) {
        return (char) (ch1 + Math.random() * (ch2 - ch1 + 1));//因为random<1.0，所以需要+1，才能取到ch2
    }

    public static char getRandomDigitLetter() {
        return getRandomCharacter('0', '9');
    }

}
