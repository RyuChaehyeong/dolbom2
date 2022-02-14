package com.dolbom.domain;

import lombok.Data;

import java.util.Date;

@Data
public class DlbmVO {

    private Long srvcId;

    private String dlbmId;

    private String srvcNm;

    private String srvcRgsnStatCd;

    private String animalCtgrCd;

    private String breedCtgrCd;

    private String srvcDtl;

    private String postcode;

    private String detailAddress;

    private String dlbmLoc;

    private String rate;

    private String useYn;

    private String dltYn;

    private String createdBy;

    private String lastModifiedBy;

    private Date createdDt;

    private Date lastModifiedDt;

}
