package com.noah.utils;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * MD5Util.java
 *
 * @author yinzongchang
 * 创建时间 2023/3/10
 * @since 1.0
 */
public class MD5Util {


    public MD5Util() {
    }

    public static String md5(String input) {
        try {
            MessageDigest mdInst = MessageDigest.getInstance("MD5");
            mdInst.update(input.getBytes());
            byte[] md = mdInst.digest();
            StringBuffer hexString = new StringBuffer();

            for(int i = 0; i < md.length; ++i) {
                String shaHex = Integer.toHexString(md[i] & 255);
                if (shaHex.length() < 2) {
                    hexString.append(0);
                }

                hexString.append(shaHex);
            }

            return hexString.toString();
        } catch (NoSuchAlgorithmException var6) {
//            logger.error("MD5 exception,trace:{}", var6);
            throw new RuntimeException(var6);
        }
    }

}
