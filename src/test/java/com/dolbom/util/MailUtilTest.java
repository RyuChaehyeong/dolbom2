package com.dolbom.util;

import java.util.HashMap;
import java.util.Map;

public class MailUtilTest {

    public static void main(String[] args) {
        //MailUtil.sendEmail("[알림] 견적 요청 단계 안내 메일", "test입니다.", "fluid15@naver.com");

        String temp = "안녕하세요. 저는 $name$입니다. 제 id는 $custId$입니다.";
        Map<String, String> map = new HashMap<>();
        map.put("$name$", "채형");
        map.put("$custId$", "동도");

        MailUtilTest.changeContent(temp, map);

/*        String a = "안녕하세요.";
        String b = "히가세요";
        a = a.replace("하세요", b);
        System.out.println(a);*/
    }


    public static void changeContent(String temp, Map<String, String> map) {

        for (String key : map.keySet()) {
            String tempStr = key;
            String realStr = map.get(key);
            System.out.println(tempStr);
            System.out.println(realStr);
            temp = temp.replace(tempStr, realStr);
            //temp = temp.replaceAll(tempStr, realStr);
        }

        System.out.println(temp);
    }



}
