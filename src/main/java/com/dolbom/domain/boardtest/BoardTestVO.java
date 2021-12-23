package com.dolbom.domain.boardtest;

import lombok.Data;

import java.util.Date;

@Data
public class BoardTestVO {

    private Long boardNum;
    private String title;
    private String content;
    private String writer;
    private Date boardTestRgsnDttm;
    private Date boardTestModiDttm;

}
