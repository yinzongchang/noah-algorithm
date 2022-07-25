package com.noah.demo.map;

import java.util.HashMap;

/**
 * Title: TestSonMap.java <br>
 * Description:             <br>
 * Copyright: Copyright (c) 2015<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author yinzo 2022/7/23
 */
public class TestSonMap {


    public static void main(String[] args) {

        Son son1 = new Son("小1");
        Son son2 = new Son("小2");
        Son son3 = new Son("小3");
        Son son4 = new Son("小4");
        Son son5 = new Son("小5");
        Son son6 = new Son("小6");
        Son son7 = new Son("小7");
        Son son8 = new Son("小8");
        Son son9 = new Son("小9");

        HashMap<Son, String> sonStringMap = new HashMap<>(64);
        sonStringMap.put(son1, "1");
        sonStringMap.put(son2, "2");
        sonStringMap.put(son3, "3");
        sonStringMap.put(son4, "4");
        sonStringMap.put(son5, "5");
        sonStringMap.put(son6, "6");
        sonStringMap.put(son7, "7");
        sonStringMap.put(son8, "8");
        sonStringMap.put(son9, "9");

        sonStringMap.remove(son9);
        sonStringMap.remove(son8);
        sonStringMap.remove(son7);
        sonStringMap.remove(son6);
        sonStringMap.remove(son5);
        sonStringMap.remove(son4);
        sonStringMap.remove(son3);
        sonStringMap.remove(son2);



    }

}
