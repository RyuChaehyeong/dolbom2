package com.dolbom.service;

import com.dolbom.domain.auth.DlbmUserAuthVO;
import com.dolbom.domain.auth.DlbmUserVO;

public interface DlbmUserService {

    boolean register(DlbmUserVO dlbmUser);

    String checkId(String id);

    String checkEmail(String email);

    DlbmUserVO getUserInfo(String userId);
}
