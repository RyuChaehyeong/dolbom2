package com.dolbom.service.common;

import com.dolbom.domain.common.CommonCodeVO;
import com.dolbom.mapper.CommonMapper;
import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Log4j
@Service
@AllArgsConstructor
public class CommonServiceImpl implements CommonService {

    @Setter(onMethod_ = @Autowired)
    private CommonMapper commonMapper;

    @Override
    public List<CommonCodeVO> retrieveCode(String cdGroupId) {

        List<CommonCodeVO> codeVOList = new ArrayList<>();
        codeVOList = commonMapper.retrieveCode(cdGroupId);

        return codeVOList;
    }


}
