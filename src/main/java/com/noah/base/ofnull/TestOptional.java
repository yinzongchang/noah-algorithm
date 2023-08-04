package com.noah.base.ofnull;

import org.bouncycastle.asn1.ASN1GeneralizedTime;
import org.bouncycastle.asn1.x509.sigi.PersonalData;

import java.util.Optional;

/**
 * TestOptional.java
 *
 * @author yinzongchang
 * 创建时间 2023/5/30
 * @since 1.0
 */
public class TestOptional {


    public static void main(String[] args) {

        PersonalData personalData = null;


//        boolean name = Optional.ofNullable(personalData.getDateOfBirth().getTime()).isPresent();


        String name2 = Optional.ofNullable(personalData).map(PersonalData::getDateOfBirth).map(ASN1GeneralizedTime::getTime).orElse("hh");

        System.out.println(name2);
    }


}
