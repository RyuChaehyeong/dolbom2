package com.dolbom.mapper.auth;


import com.dolbom.domain.auth.DlbmUserVO;

public interface DlbmUserMapper {

    public DlbmUserVO readDlbmUserInfo(String userId);
}
