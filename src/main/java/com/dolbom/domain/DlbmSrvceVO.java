package com.dolbom.domain;

import lombok.Data;

import java.util.Date;

@Data
public class DlbmSrvceVO {

    private Long srvcId;

    private String dlbmId;

    private String srvcNm;

    private String srvcRgsnStatCd;

    private String categoryCd;

    private String srvcDtl;

    private String dlbmLoc;

    private String useYn;

    private String dltYn;

    private String createdBy;

    private String lastModifiedBy;

    private Date createdDt;

    private Date lastModifiedDt;

}
