package com.dolbom.mapper.auth;


import com.dolbom.domain.auth.DolbomUserVO;

public interface DolbomUserMapper {

    public DolbomUserVO readDolbomUserInfo(String userId);
}
