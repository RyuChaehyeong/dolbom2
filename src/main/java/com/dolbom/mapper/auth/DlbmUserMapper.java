package com.dolbom.mapper.auth;


import com.dolbom.domain.auth.DlbmUserAuthVO;
import com.dolbom.domain.auth.DlbmUserVO;

public interface DlbmUserMapper {

    DlbmUserVO readDlbmUserInfo(String userId);

    boolean registerMemberInfo(DlbmUserVO dlbmUser);

    boolean registerAuthInfo(DlbmUserAuthVO autoVO);

    String checkId(String id);

    String checkEmail(String email);

    DlbmUserVO getUserInfo(String userId);
}
