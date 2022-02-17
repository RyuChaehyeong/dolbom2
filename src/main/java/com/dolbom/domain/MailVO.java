package com.dolbom.domain;

import lombok.Data;

@Data
public class MailVO {

    private String mailGroup;

    private String atrb;

    private String mailSj;

    private String mailContent;

    private String receiver;

    public MailVO(String mailGroup, String atrb, String mailSj, String mailContent, String receiver) {
        this.mailGroup = mailGroup;
        this.atrb = atrb;
        this.mailSj = mailSj;
        this.mailContent = mailContent;
        this.receiver = receiver;
    }

}
