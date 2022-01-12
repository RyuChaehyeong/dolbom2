package com.dolbom.security;

import com.dolbom.domain.auth.AdminUserVO;
import com.dolbom.domain.auth.DlbmUserVO;
import com.dolbom.mapper.auth.AdminUserMapper;
import com.dolbom.mapper.auth.DlbmUserMapper;
import com.dolbom.security.domain.CustomUser;
import lombok.Setter;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@Log4j
public class CustomUserDetailsService implements UserDetailsService {


    @Setter(onMethod_ = {@Autowired})
    private DlbmUserMapper dlbmUserMapper;

    @Setter(onMethod_ = {@Autowired})
    private AdminUserMapper admimUserMapper;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        log.warn("Load User by Username: " + userName);
        if (userName.startsWith("#")) {

            AdminUserVO adminUserVO = admimUserMapper.readAdminUserInfo(userName);

            log.warn("queried by Dolbom User mapper: " + adminUserVO);

            return adminUserVO == null ? null : new CustomUser(adminUserVO);

        } else {

            DlbmUserVO dlbmUserVO = dlbmUserMapper.readDlbmUserInfo(userName);

            log.warn("queried by Dolbom User mapper: " + dlbmUserVO);

            return dlbmUserVO == null ? null : new CustomUser(dlbmUserVO);
        }
    }
}
