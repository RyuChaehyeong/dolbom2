package com.dolbom.domain.auth;

import com.dolbom.domain.auth.DlbmUserAuthVO;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class DlbmUserVO {

    private Long userSn;

    private String userId;

    private String userNm;

    private String userPwd;

    private String userEmail;

    private String userPhone;

    private String userTypeCd;

    private String useYn;

    private String dltYn;

    private Date createdDt;

    private String createdBy;

    private Date lastModifiedDt;

    private String lastModifiedBy;

    private List<DlbmUserAuthVO> authList;
}
