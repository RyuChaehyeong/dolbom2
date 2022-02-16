package com.dolbom.service;

import com.dolbom.domain.auth.DlbmUserAuthVO;
import com.dolbom.domain.auth.DlbmUserVO;
import com.dolbom.mapper.auth.DlbmUserMapper;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Log4j
@Service
@AllArgsConstructor
public class DlbmUserServiceImpl implements DlbmUserService{

    private DlbmUserMapper dlbmUserMapper;
    private PasswordEncoder pwencoder;

    @Override
    public boolean register(DlbmUserVO dlbmUser, DlbmUserAuthVO auth) {
        dlbmUser.setUserPwd(pwencoder.encode(dlbmUser.getUserPwd()));
        boolean infoRes = dlbmUserMapper.registerMemberInfo(dlbmUser);
        boolean authRes = dlbmUserMapper.registerAuthInfo(auth);
        return infoRes&&authRes ? true : false;
    }

    @Override
    public String checkId(String id) {
        return dlbmUserMapper.checkId(id);
    }

    @Override
    public String checkEmail(String email) {
        return dlbmUserMapper.checkEmail(email);
    }

    @Override
    public DlbmUserVO getUserInfo(String userId) {
        DlbmUserVO userInfo = dlbmUserMapper.getUserInfo(userId);
        return userInfo;
    }

}
