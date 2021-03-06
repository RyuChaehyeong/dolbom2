package com.dolbom.domain;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;


@Data
public class QuoteReqVO {

    private Long reqId;

    private Long srvcId;

    private String srvcNm;

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

    private String reqPrgrStatNm;

    private String quoPrice;

    private String useYn;

    private String dltYn;

    private Date createdDt;

    private String createdBy;

    private Date lastModifiedDt;

    private String lastModifiedBy;

    private String animalCtgrCd;

    private String breedCtgrCd;

    private String animalCtgrNm;

    private String breedCtgrNm;

    private String reviewYn;




}
