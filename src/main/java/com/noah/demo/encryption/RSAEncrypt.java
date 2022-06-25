package com.noah.demo.encryption;

import org.bouncycastle.util.encoders.Base64;
import sun.misc.BASE64Encoder;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.UnsupportedEncodingException;
import java.security.*;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

/**
 * Title: RSAEncrypt.java <br>
 * Description:             <br>
 * Copyright: Copyright (c) 2015<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author yinzo 2019-07-03
 */
public class RSAEncrypt {


    public static void main(String[] args) {


        KeyPairGenerator keyPairGenerator = null;
        try {
            keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        keyPairGenerator.initialize(2048);

        KeyPair keyPair = keyPairGenerator.generateKeyPair();

        RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();

        RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();

        System.out.println("公钥：" + new BASE64Encoder().encodeBuffer(publicKey.getEncoded()));

        System.out.println("私钥：" + new BASE64Encoder().encodeBuffer(privateKey.getEncoded()));


        String publicKeyStr = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAx6trj80ey+REqqe1P6wXip7dZ8GFD8feWTSL3uaJnSMYUk+qCvy5EVVYFsN8txFF5BY3+7p/+8cdEeMN5aHjP7VZp4nRa3qqS8+4pDju4n9lnGWT5R7IsThMFyiyZzQg0CrGyxqgZYYi8kqy6Rl2p01lMXjWGe92ox8fxO7n+nmYd8wWNpFtvF3az6G/fvZaySuKmq/aTgvnEK+QVwSnXK2ZewJw68F7LNOaPLIGw+8mkjBdD1qA+U4+MbcHKpjJInM3rEXTOkW8xFf2JTjyYrIRw6gXCSsZ8nmgmG6uQgVLji1BbuGmpKnAp3V8INKFICr9uUpvD89pkzcVPhJARwIDAQAB";

        String privateKeyStr = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQDHq2uPzR7L5ESqp7U/rBeKnt1nwYUPx95ZNIve5omdIxhST6oK/LkRVVgWw3y3EUXkFjf7un/7xx0R4w3loeM/tVmnidFreqpLz7ikOO7if2WcZZPlHsixOEwXKLJnNCDQKsbLGqBlhiLySrLpGXanTWUxeNYZ73ajHx/E7uf6eZh3zBY2kW28XdrPob9+9lrJK4qar9pOC+cQr5BXBKdcrZl7AnDrwXss05o8sgbD7yaSMF0PWoD5Tj4xtwcqmMkiczesRdM6RbzEV/YlOPJishHDqBcJKxnyeaCYbq5CBUuOLUFu4aakqcCndXwg0oUgKv25Sm8Pz2mTNxU+EkBHAgMBAAECggEAYBniaFEKjInuftC/TMkQf5ic6c5bs8+39elzlLIS8/2rPBq5thYTIQOZpUMrqJT4taH4CgGmjdE07aIB009KqCQp5ZhQolFk2547uVbpqzwz9MVzHGjnoVx+Svs8eq29SVP9YE4Ney/HbCSF3elykW2P0fLd4Ze+2x4k1U1De+rlMJYUudVS6C2hTa6uGlGC3hmrqg5zbbEluAu4w3vf1TXSmG+8jZHsXRs7LvIsTdz12vzZcZn31l1LX6HzlQXvTi7vzGYaivzKoMWTOp4SUTk4qSKoi8wKXtElvllo95zL3TNymilg6hiKN3+OXQYzy/pZja7z14rk4fYSXTKVMQKBgQD/k3pQn3RrwUNlyFFnt6fe7oLFenBgBX7mm1mIb7yHEN35a9BG/0tcLCmeYwKCvvsBuAZThuGmlceEZV2w09Rfroczlglj5h8xjlVguoY6T6DOq9yHFLjCYiVvWKOkMFg7J134wpWlnYeMeDPVoescnFbiCSwoQnhf+LrQHX5tWQKBgQDIADQW5Wg0JjoWytFpcFLMygJY4NRPsrXUXwWYfqeIv0VMoDEoUHIMJiu/JFUzKxzOkosyhdr8rxN/jyDIrQ84v5F9xiYsZWb6pVm9iDq9/RO68hxE/Avm19ePW3FZD5u/vNX07Z0lbpVXdtD0O7dEI1RJVOAKH6Mtb7T0/RZGnwKBgQDxUpX6LrZFUPWM0/tZzeaq79d3FEerw0SyBxohZDBF8L1IWG8PutuzqteZgK/MOPzWAKeokwHaxC7iarxuzXYI6skrAo7XT2FA777aWQWJZcrXmxveSMi0cuwaGT5bOHL3WBK5YzLecMKe9pkrLXrNRyoawMJ7OVhkdn4fKNpJ8QKBgFOHWjnxx8p36KzaOgmqQrqK594M0D8U6UHwCZs90mSXVa8B/GXU6zzNuFmVKAw9xkM0CvSn2OTNjfwpX8zQElpmD7KSziCenRqzcj5pJfdxOgtK0KmzBpl7reiOjVFf5nF2wXkQwCABBlhIJE7MnebURoB19TflLLZuQApNpT8LAoGATs5OKXmFXudG1fRRP40VnNx7at1rtCPU5ue90LfplunXBJid9sgXG3K1o2JEUrHHuznAAUpZaLrBYT52Eq5vK/sEer8fJ82VeTUxT01tre+6urLFY5uk+3GO+l/F1rW5FEZZJOq/RkCbasN6MhIhOmGR28LhTH9PSgdtDZnNWuU=";




    }


    /**
     * 公钥加密过程
     *
     * @param publicKey
     * @param plainTextData
     * @return
     * @throws Exception
     */
    public static byte[] encrypt(RSAPublicKey publicKey, byte[] plainTextData)
            throws Exception {
        if (publicKey == null) {
            throw new Exception("加密公钥为空, 请设置");
        }
        Cipher cipher = null;
        try {
            // 使用默认RSA
            cipher = Cipher.getInstance("RSA");
            // cipher= Cipher.getInstance("RSA", new BouncyCastleProvider());
            cipher.init(Cipher.ENCRYPT_MODE, publicKey);
            byte[] output = cipher.doFinal(plainTextData);
            return output;
        } catch (NoSuchAlgorithmException e) {
            throw new Exception("无此加密算法");
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
            return null;
        } catch (InvalidKeyException e) {
            throw new Exception("加密公钥非法,请检查");
        } catch (IllegalBlockSizeException e) {
            throw new Exception("明文长度非法");
        } catch (BadPaddingException e) {
            throw new Exception("明文数据已损坏");
        }
    }


    public static byte[] decrypt(RSAPrivateKey privateKey, byte[] cipherData)
            throws Exception {
        if (privateKey == null) {
            throw new Exception("解密私钥为空, 请设置");
        }
        Cipher cipher = null;
        try {
            // 使用默认RSA
            cipher = Cipher.getInstance("RSA");
            // cipher= Cipher.getInstance("RSA", new BouncyCastleProvider());
            cipher.init(Cipher.DECRYPT_MODE, privateKey);
            byte[] output = cipher.doFinal(cipherData);
            return output;
        } catch (NoSuchAlgorithmException e) {
            throw new Exception("无此解密算法");
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
            return null;
        } catch (InvalidKeyException e) {
            throw new Exception("解密私钥非法,请检查");
        } catch (IllegalBlockSizeException e) {
            throw new Exception("密文长度非法");
        } catch (BadPaddingException e) {
            throw new Exception("密文数据已损坏");
        }
    }


    public static RSAPrivateKey loadPrivateKeyByStr(String privateKeyStr)
            throws Exception {
        try {
            Base64 base64 = new Base64();
            byte[] buffer = base64.decode(privateKeyStr);
            PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(buffer);
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            return (RSAPrivateKey) keyFactory.generatePrivate(keySpec);
        } catch (NoSuchAlgorithmException e) {
            throw new Exception("无此算法");
        } catch (InvalidKeySpecException e) {
            throw new Exception("私钥非法");
        } catch (NullPointerException e) {
            throw new Exception("私钥数据为空");
        }
    }


    /**
     * 从字符串中加载公钥
     *
     * @param publicKeyStr 公钥数据字符串
     * @throws Exception 加载公钥时产生的异常
     */
    public static RSAPublicKey loadPublicKeyByStr(String publicKeyStr)
            throws Exception {
        try {
            Base64 base64 = new Base64();
            byte[] buffer = base64.decode(publicKeyStr);
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            X509EncodedKeySpec keySpec = new X509EncodedKeySpec(buffer);
            return (RSAPublicKey) keyFactory.generatePublic(keySpec);
        } catch (NoSuchAlgorithmException e) {
            throw new Exception("无此算法");
        } catch (InvalidKeySpecException e) {
            throw new Exception("公钥非法");
        } catch (NullPointerException e) {
            throw new Exception("公钥数据为空");
        }
    }


    /**
     * 私钥加密过程
     *
     * @param privateKey    私钥
     * @param plainTextData 明文数据
     * @return
     * @throws Exception 加密过程中的异常信息
     */
    public static byte[] encrypt(RSAPrivateKey privateKey, byte[] plainTextData)
            throws Exception {
        if (privateKey == null) {
            throw new Exception("加密私钥为空, 请设置");
        }
        Cipher cipher = null;
        try {
            // 使用默认RSA
            cipher = Cipher.getInstance("RSA");
            cipher.init(Cipher.ENCRYPT_MODE, privateKey);
            byte[] output = cipher.doFinal(plainTextData);
            return output;
        } catch (NoSuchAlgorithmException e) {
            throw new Exception("无此加密算法");
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
            return null;
        } catch (InvalidKeyException e) {
            throw new Exception("加密私钥非法,请检查");
        } catch (IllegalBlockSizeException e) {
            throw new Exception("明文长度非法");
        } catch (BadPaddingException e) {
            throw new Exception("明文数据已损坏");
        }
    }


    /**
     * 公钥解密过程
     *
     * @param publicKey  公钥
     * @param cipherData 密文数据
     * @return 明文
     * @throws Exception 解密过程中的异常信息
     */
    public static byte[] decrypt(RSAPublicKey publicKey, byte[] cipherData)
            throws Exception {
        if (publicKey == null) {
            throw new Exception("解密公钥为空, 请设置");
        }
        Cipher cipher = null;
        try {
            // 使用默认RSA
            cipher = Cipher.getInstance("RSA");
            // cipher= Cipher.getInstance("RSA", new BouncyCastleProvider());
            cipher.init(Cipher.DECRYPT_MODE, publicKey);
            byte[] output = cipher.doFinal(cipherData);
            return output;
        } catch (NoSuchAlgorithmException e) {
            throw new Exception("无此解密算法");
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
            return null;
        } catch (InvalidKeyException e) {
            throw new Exception("解密公钥非法,请检查");
        } catch (IllegalBlockSizeException e) {
            throw new Exception("密文长度非法");
        } catch (BadPaddingException e) {
            throw new Exception("密文数据已损坏");
        }
    }


}
