package com.dolbom.domain.auth;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class DlbmUserVO {

    private String userId;

    private String userSn;

    private String userNm;

    private String userPwd;

    private String userEmail;

    private String userPhone;

    private String userTypeCd;

    private String userYn;

    private String dltYn;

    private Date createdDt;

    private Date lastModifiedDt;

    private String createdBy;

    private String lastModifiedBy;

    private List<AutoVO> authList;

}
