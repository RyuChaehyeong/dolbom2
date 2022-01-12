package com.dolbom.domain.auth;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class AdminUserVO {

    private String adminId;

    private String adminSn;

    private String adminNm;

    private String adminPwd;

    private String adminEmail;

    private String adminPhone;

    private String departmentCd;

    private String userYn;

    private String dltYn;

    private Date createdDt;

    private Date lastModifiedDt;

    private String createdBy;

    private String lastModifiedBy;

    private List<AdminAuthVO> authList;

}
