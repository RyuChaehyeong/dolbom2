package com.dolbom.mapper.auth;


import com.dolbom.domain.auth.AdminUserVO;
import com.dolbom.domain.auth.DlbmUserVO;

public interface AdminUserMapper {

    public AdminUserVO readAdminUserInfo(String adminId);
}
