package com.dolbom.domain;

import lombok.Data;

import java.util.Date;

@Data
public class DlbmRequestVO {

    private Long reqId;

    private Long srvcId;

    private String custId;

    private String reqTitle;

    private String postcode;

    private String custLoc;

    private String detailAddress;

    private Date startDt;

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
