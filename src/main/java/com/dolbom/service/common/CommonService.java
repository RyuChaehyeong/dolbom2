package com.dolbom.service.common;

import com.dolbom.domain.common.CommonCodeVO;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CommonService {

    public List<CommonCodeVO> retrieveCode (String cdGroupId);
}
