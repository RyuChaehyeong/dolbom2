package com.dolbom.security.domain;

import com.dolbom.domain.auth.AdminUserVO;
import com.dolbom.domain.auth.DlbmUserVO;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import lombok.Getter;

import java.util.Collection;
import java.util.stream.Collectors;

@Getter
public class CustomUser extends User {

    private static final long serialVersionUID = 1L;

    private DlbmUserVO dlbmUserVO;
    private AdminUserVO adminUserVO;

    public CustomUser(String username, String password, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
    }

    public CustomUser(DlbmUserVO vo) {
        super(vo.getUserId(), vo.getUserPwd(), vo.getAuthList().stream().map(auth -> new SimpleGrantedAuthority(auth.getAuth())).collect(Collectors.toList()));
        this.dlbmUserVO = vo;
    }

    public CustomUser(AdminUserVO vo) {
        super(vo.getAdminId(), vo.getAdminPwd(), vo.getAuthList().stream().map(auth -> new SimpleGrantedAuthority(auth.getAuth())).collect(Collectors.toList()));
        this.adminUserVO = vo;
    }
}
