package com.dolbom.domain;

import lombok.Data;

import java.util.Date;

@Data
public class ReviewVO {

    private Long reqId;

    private Long srvcId;

    private String custId;

    private String rate;

    private String reviewComment;

    private String useYn;

    private String dltYn;

    private Date createdDt;

    private String createdBy;

    private Date lastModifiedDt;

    private String lastModifiedBy;
}
