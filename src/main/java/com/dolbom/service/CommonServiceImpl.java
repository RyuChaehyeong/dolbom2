package com.dolbom.service;

import com.dolbom.domain.CodeVO;
import com.dolbom.mapper.CommonMapper;
import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Log4j
@Service
@AllArgsConstructor
public class CommonServiceImpl implements CommonService {

    @Setter(onMethod_ = @Autowired)
    private CommonMapper commonMapper;

    @Override
    public List<CodeVO> getCode(String cdGroupId) {
        return commonMapper.getCode(cdGroupId);
    }
}
