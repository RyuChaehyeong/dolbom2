package com.dolbom.mapper;

import com.dolbom.domain.common.CommonCodeVO;

import java.util.List;

public interface CommonMapper {

    public List<CommonCodeVO> retrieveCode(String cdGroupId);
}
