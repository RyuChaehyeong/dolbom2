package com.dolbom.service;

import com.dolbom.domain.CodeVO;

import java.util.List;

public interface CommonService {
    List<CodeVO> getCode(String cdGroupId);
}
