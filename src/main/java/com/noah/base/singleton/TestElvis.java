package com.noah.base.singleton;

import com.alibaba.fastjson.JSONObject;

import java.io.*;

/**
 * TestElvis.java
 *
 * @author yinzongchang
 * 创建时间 2023/5/29
 * @since 1.0
 */
public class TestElvis {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Elvis elvis1 = Elvis.getInstance();
        Elvis elvis2 = Elvis.getInstance();

        Elvis elvis3 = JSONObject.parseObject(JSONObject.toJSONString(elvis1), Elvis.class);
        getSerial(elvis1);
        Elvis elvis4 = backSerial();

        System.out.println("elvis1 hashcode: " + elvis1.hashCode());
        System.out.println("elvis2 hashcode: " + elvis2.hashCode());
        System.out.println("elvis3 hashcode: " + elvis3.hashCode());
        System.out.println("elvis4 hashcode: " + elvis4.hashCode());

        System.out.println("elvis1 == elvis2: " + (elvis1 == elvis2));
        System.out.println("elvis1 == elvis3: " + (elvis1 == elvis3));





    }


    //序列化
    static void getSerial(Elvis u1) throws IOException {
        FileOutputStream fos = new FileOutputStream("obj.out");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(u1);
        oos.flush();
        oos.close();
    }

    //反序列化
    static Elvis backSerial() throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream("obj.out");
        ObjectInputStream ois = new ObjectInputStream(fis);
        Elvis u1 = (Elvis) ois.readObject();
        return u1;
    }
}
