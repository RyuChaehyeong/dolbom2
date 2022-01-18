package com.dolbom.domain.common;

import lombok.Data;

import java.util.Date;

@Data
public class CommonCodeVO {
    private String cdGroupId;
    private String cdId;
    private String cdNm;
    private String useYn;
    private String dltYn;
    private Date createdDt;
    private String createdBy;
    private String lastModifiedDt;
    private String lastModifiedBy;

}
