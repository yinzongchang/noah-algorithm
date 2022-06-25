package com.noah.demo.encryption;

import com.alibaba.fastjson.JSON;
import com.noah.demo.http.HttpUtil;
import org.bouncycastle.util.encoders.Base64;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Title: WmsTool3.java <br>
 * Description:             <br>
 * Copyright: Copyright (c) 2015<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author yinzo 2019-07-08
 */
public class WmsTool3 {

    private String publicKey2Str = "TUlJQklqQU5CZ2txaGtpRzl3MEJBUUVGQUFPQ0FROEFNSUlCQ2dLQ0FRRUFuVGdZMENsQVZ2czdYUC84dEVqQ1g3R2dFcVZkcUN6TkJ4RjZ0NUN1c1crZ1MvZWdVNFZJcENlcVptWTVyWVErV0lWNzQzbTNKRit1NzNRVXNBeE5zbHl4SSswdEkzNDZUYkp5QnZVdXI2RSs1bDNoNFVPeVZQZlpoK01BTUZjNmlkcVVGc3AxcnlURkFEaS9WTzVlVSttV0lVQUxGRXFtSWljakNFTkQxN3h0a1RsSEZYVFBYOVBHbjB3Q3U5WnAyNkYzcDhpcXd5Q1VxYXFFeFF2UnJ3YXAzQUtCTEtZVktxbUJ0NEoxbm1vNVMzZzZiK1p1Y24vSDczajFaQi9xTDc1c1JSU1RZR3hMTCtQTjhhR1pXS3ZRMjdsdWlFa1FycWphUFlXM1VxL0o5ckZzMHlIbU1VTjRnSFNmVjU1NHM4VXhoYmpKUmRHSkVRVVR3amJteVFJREFRQUI=";

    private String p2String = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAjvD71USdg/kI4eN+2R5eGIq6Qp+DJesTSMWQ2T8V9ooOalGx1NqgqZlmbmSze2Q8IK86+fI8O+Xg+jlQLeE29dhcvaEH1d5IzVweuXzTEQwx+iiSZR7yOpdyyrGivdW/Tx+JlOiA38EPm1KQJGgAUxunNoawSg37Eoj0IWtAuJY/4sSq2d5py7dZMxWeDorK86rQUu0KOdQxJlR4x3jOYlb19OL1n5EPno7dE1km4ffx/cqDgg4xn0wGxqIIIdnU2GBYEHOIWXXEGvwzu7UgJUvHYF7GqmxGo+GDuCeZCVkuACdUXNBqBr8FPlglgVAtVZ8fmXe+KeLMjy9ShPU0lwIDAQAB";
    private String code = "237607";

    private static String plaintext2 = "れゎザジ☃☂✄¢€£キギグケ╰╙㊜㊪㊬╜✤✥♫卄卐╯ゲとどゴサスセゼソ";

    private static String urlSQL = "https://wms-gateway.test.yunshanmeicai.com/api_adapt/wmsBoundingPack/com.sprucetec.wms.bounding.pack.service.PackService/submitTask";


    public void testExecuteSQL() {


        String redisCode = code;

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
        byte[] encryptPublicKey2 = RSAUtils.encryptByPublicKey(plaintextSql.getBytes(), p2String);

        String encryptPublicKey2Base = Base64.toBase64String(encryptPublicKey2);

        List sqlParam = new ArrayList();
        sqlParam.add(1);
        sqlParam.add(encryptPublicKey2Base);
        sqlParam.add("update wms_master.t_wms_class1 set u_t = unix_timestamp();");


        System.out.println("参数: " + JSON.toJSONString(sqlParam));

        String sqlResult = HttpUtil.post(urlSQL, JSON.toJSONString(sqlParam));

        System.out.println("SQL result: " + sqlResult);

    }

    @Test
    public void testSQL() {

        testExecuteSQL();
    }



}
