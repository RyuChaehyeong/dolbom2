package com.dolbom.domain;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class RequestVO {

    private Long reqId;

    private Long srvcId;

    private String custId;

    private String reqTitle;

    private String postcode;

    private String custLoc;

    private String detailAddress;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date startDt;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endDt;

    private String reqDtl;

    private String reqPrgrStatCd;

    private String quoPrice;

    private String useYn;

    private String dltYn;

    private Date createdDt;

    private String createdBy;

    private Date lastModifiedDt;

    private String lastModifiedBy;




}
