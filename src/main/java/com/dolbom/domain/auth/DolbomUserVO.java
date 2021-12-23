package com.dolbom.domain.auth;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class DolbomUserVO {

    private String userId;
    private String userPw;
    private String userNm;
    private boolean enabled;

    private Date userRgsnDttm;
    private Date userModiDttm;
    private List<AutoVO> authList;
}
