package com.dolbom.mapper;

import com.dolbom.domain.CodeVO;
import com.dolbom.domain.ReviewVO;

import java.util.List;

public interface CommonMapper {

    List<CodeVO> getCode(String cdGroupId);
}
