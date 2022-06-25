package com.noah.demo.encryption;

import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.*;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashMap;
import java.util.Map;

/**
 * Title: RSAUtils.java <br>
 * Description:             <br>
 * Copyright: Copyright (c) 2015<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author yinzo 2019-07-05
 */
public class RSAUtils {


    /**
     * 加密算法RSA
     */
    private static final String KEY_ALGORITHM = "RSA";
    /**
     * 获取公钥的key
     */
    private static final String PUBLIC_KEY = "RSAPublicKey";
    /**
     * 获取私钥的key
     */
    private static final String PRIVATE_KEY = "RSAPrivateKey";
    /**
     * 签名算法
     */
    private static final String SIGNATURE_ALGORITHM = "MD5withRSA";
    /**
     * 常量0
     */
    private static final int ZERO = 0;
    /**
     * RSA最大加密明文最大大小
     */
    private static final int MAX_ENCRYPT_BLOCK = 245;
    /**
     * RSA最大解密密文最大大小
     * 当密钥位数为1024时,解密密文最大是 128
     * 当密钥位数为2048时需要改为 256 不然会报错（Decryption error）
     */
    private static final int MAX_DECRYPT_BLOCK = 256;
    /**
     * 默认key大小
     */
    private static final int DEFAULT_KEY_SIZE = 2048;

    /**
     * 生成密钥对(公钥和私钥)
     *
     * @return
     */
    public static Map<String, Object> initKey() {
        return initKey(DEFAULT_KEY_SIZE);
    }

    /**
     * 生成密钥对(公钥和私钥)
     *
     * @return
     */
    public static Map<String, Object> initKey(int keySize) {
        KeyPairGenerator keyPairGen = null;
        try {
            keyPairGen = KeyPairGenerator.getInstance(KEY_ALGORITHM);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        keyPairGen.initialize(keySize);
        KeyPair keyPair = keyPairGen.generateKeyPair();
        RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();
        RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();
        Map<String, Object> keyMap = new HashMap<>(2);
        keyMap.put(PUBLIC_KEY, publicKey);
        keyMap.put(PRIVATE_KEY, privateKey);
        return keyMap;
    }


    /**
     * 公钥加密
     *
     * @param data      源数据
     * @param publicKey 公钥(BASE64编码)
     * @return
     */
    public static byte[] encryptByPublicKey(byte[] data, String publicKey) {

        byte[] keyBytes = Base64.decode(publicKey);
        X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(keyBytes);

        byte[] result;
        try {

            KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
            result = encrypt(data, KeyFactory.getInstance(KEY_ALGORITHM), keyFactory.generatePublic(x509KeySpec));
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("无此算法", e);
        } catch (InvalidKeySpecException e) {
            throw new RuntimeException("公钥非法", e);
        }
        return result;
    }


    /**
     * 私钥加密
     *
     * @param data       源数据
     * @param privateKey 私钥(BASE64编码)
     * @return
     */
    public static byte[] encryptByPrivateKey(byte[] data, String privateKey) {

        byte[] keyBytes = Base64.decode(privateKey);
        PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(keyBytes);
        KeyFactory keyFactory;
        Key privateK;
        try {
            keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
            privateK = keyFactory.generatePrivate(pkcs8KeySpec);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("无此算法", e);
        } catch (InvalidKeySpecException e) {
            throw new RuntimeException("私钥非法", e);
        }

        return encrypt(data, keyFactory, privateK);
    }


    /**
     * 私钥解密
     *
     * @param encryptedData 已加密数据
     * @param privateKey    私钥(BASE64编码)
     * @return
     */
    public static byte[] decryptByPrivateKey(byte[] encryptedData, String privateKey) {

        byte[] keyBytes = Base64.decode(privateKey);
        PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(keyBytes);

        byte[] res;
        try {
            KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
            res = decrypt(encryptedData, keyFactory, keyFactory.generatePrivate(pkcs8KeySpec));
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("无此算法", e);
        } catch (InvalidKeySpecException e) {
            throw new RuntimeException("私钥非法", e);
        }
        return res;
    }


    /**
     * 公钥解密
     *
     * @param encryptedData 已加密数据
     * @param publicKey     公钥(BASE64编码)
     * @return
     * @throws Exception
     */
    public static byte[] decryptByPublicKey(byte[] encryptedData, String publicKey) {

        byte[] keyBytes = Base64.decode(publicKey);
        X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(keyBytes);

        KeyFactory keyFactory;
        Key publicK;

        try {
            keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
            publicK = keyFactory.generatePublic(x509KeySpec);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("无此算法", e);
        } catch (InvalidKeySpecException e) {
            throw new RuntimeException("公钥非法", e);
        }
        return decrypt(encryptedData, keyFactory, publicK);

    }


    /**
     * 用私钥对信息生成数字签名
     *
     * @param data       已加密数据
     * @param privateKey 私钥(BASE64编码)
     * @return
     */
    public static String sign(byte[] data, String privateKey) {

        byte[] keyBytes = Base64.decode(privateKey);
        PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(keyBytes);

        String sign;
        try {
            KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
            PrivateKey privateK = keyFactory.generatePrivate(pkcs8KeySpec);
            Signature signature = Signature.getInstance(SIGNATURE_ALGORITHM);
            signature.initSign(privateK);
            signature.update(data);
            sign = Base64.encode(signature.sign());
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("无此算法", e);
        } catch (InvalidKeySpecException e) {
            throw new RuntimeException("公钥非法", e);
        } catch (SignatureException e) {
            throw new RuntimeException("签名异常,请检查", e);
        } catch (InvalidKeyException e) {
            throw new RuntimeException("签名私钥非法,请检查", e);
        }

        return sign;
    }


    /**
     * 校验数字签名
     *
     * @param data      已加密数据
     * @param publicKey 公钥(BASE64编码)
     * @param sign      数字签名
     * @return
     */
    public static boolean verify(byte[] data, String publicKey, String sign) {

        byte[] keyBytes = Base64.decode(publicKey);
        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(keyBytes);

        boolean result;
        try {
            KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
            PublicKey publicK = keyFactory.generatePublic(keySpec);
            Signature signature = Signature.getInstance(SIGNATURE_ALGORITHM);
            signature.initVerify(publicK);
            signature.update(data);
            result = signature.verify(Base64.decode(sign));
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("无此算法", e);
        } catch (InvalidKeySpecException e) {
            throw new RuntimeException("公钥非法", e);
        } catch (SignatureException e) {
            throw new RuntimeException("签名异常,请检查", e);
        } catch (InvalidKeyException e) {
            throw new RuntimeException("签名私钥非法,请检查", e);
        }

        return result;
    }


    /**
     * 获取私钥
     *
     * @param keyMap 密钥对
     * @return
     * @throws Exception
     */
    public static String getPrivateKey(Map<String, Object> keyMap) {
        Key key = (Key) keyMap.get(PRIVATE_KEY);
        return Base64.encode(key.getEncoded());
    }


    /**
     * 获取公钥
     *
     * @param keyMap 密钥对
     * @return
     */
    public static String getPublicKey(Map<String, Object> keyMap) {

        Key key = (Key) keyMap.get(PUBLIC_KEY);
        return Base64.encode(key.getEncoded());
    }

    /**
     * 解密公共方法
     */
    private static byte[] decrypt(byte[] data, KeyFactory keyFactory, Key key) {

        Cipher cipher = null;

        try {
            cipher = Cipher.getInstance(keyFactory.getAlgorithm());
            cipher.init(Cipher.DECRYPT_MODE, key);
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("无此算法", e);
        } catch (InvalidKeyException e) {
            throw new RuntimeException("解密公钥/私钥非法,请检查");
        }
        return encryptAndDecrypt(data, cipher, MAX_DECRYPT_BLOCK);
    }

    /**
     * 加密公共方法
     */
    private static byte[] encrypt(byte[] data, KeyFactory keyFactory, Key key) {
        // 对数据加密

        Cipher cipher = null;

        try {

            cipher = Cipher.getInstance(keyFactory.getAlgorithm());
            cipher.init(Cipher.ENCRYPT_MODE, key);
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("无此算法", e);
        } catch (InvalidKeyException e) {
            throw new RuntimeException("加密公钥/私钥非法,请检查");
        }

        return encryptAndDecrypt(data, cipher, MAX_ENCRYPT_BLOCK);
    }


    /**
     * 加密解密分段处理公共方法
     */
    private static byte[] encryptAndDecrypt(byte[] data, Cipher cipher, int maxSize) {
        int inputLen = data.length;

        int offSet = ZERO;
        byte[] cache;
        int i = ZERO;
        // 对数据分段加密

        byte[] encryptedData = new byte[0];

        try (ByteArrayOutputStream out = new ByteArrayOutputStream()) {

            while (inputLen - offSet > ZERO) {

                if (inputLen - offSet > maxSize) {
                    cache = cipher.doFinal(data, offSet, maxSize);
                } else {
                    cache = cipher.doFinal(data, offSet, inputLen - offSet);
                }
                out.write(cache, ZERO, cache.length);
                i++;
                offSet = i * maxSize;
            }

            encryptedData = out.toByteArray();

        } catch (IOException e) {
            throw new RuntimeException("io异常", e);
        } catch (IllegalBlockSizeException e) {
            throw new RuntimeException("明文长度非法", e);
        } catch (BadPaddingException e) {
            throw new RuntimeException("明文数据已损坏", e);
        }


        return encryptedData;
    }


    /**
     * 加载私钥
     *
     * @param privateKeyStr
     * @return
     */
    public static RSAPrivateKey loadPrivateKeyByStr(String privateKeyStr) {

        try {
            byte[] buffer = Base64.decode(privateKeyStr);
            PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(buffer);
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            return (RSAPrivateKey) keyFactory.generatePrivate(keySpec);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("无此算法");
        } catch (InvalidKeySpecException e) {
            throw new RuntimeException("私钥非法");
        } catch (NullPointerException e) {
            throw new RuntimeException("私钥数据为空");
        }
    }

}
