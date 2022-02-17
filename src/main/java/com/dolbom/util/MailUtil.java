package com.dolbom.util;

import org.apache.log4j.Logger;
import org.springframework.ui.Model;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Map;
import java.util.Properties;
import java.util.Random;

public class MailUtil {


    public static void sendEmail(String mailSj, String content, String email) {

        final String host = "smtp.naver.com";
        final String user = "doodoo89@naver.com";
        final String password = "ChaeYoo0)";

        String toMail = email;

        Properties props = new Properties();
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", 465);
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.ssl.enable", "true");


        Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(user, password);
            }
        });

        // email 전송
        try {
            MimeMessage msg = new MimeMessage(session);
            msg.setFrom(new InternetAddress(user, "대한민국돌봄"));
            msg.addRecipient(Message.RecipientType.TO, new InternetAddress(toMail));

            // 메일 제목
            msg.setSubject(mailSj);
            // 메일 내용
            msg.setText(content);

            Transport.send(msg);
            System.out.println("이메일 전송");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static String changeContent(String temp, Map<String, String> map) {

        for (String key : map.keySet()) {
            String templStr = key;
            String realStr = map.get(key);
            temp = temp.replace(templStr, realStr);
        }
        return temp;
    }


}
