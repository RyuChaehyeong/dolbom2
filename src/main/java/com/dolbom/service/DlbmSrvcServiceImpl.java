package com.dolbom.service;

import com.dolbom.domain.DlbmSrvceVO;
import com.dolbom.mapper.DlbmSrvceMapper;
import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Log4j
@Service
@AllArgsConstructor
public class DlbmSrvcServiceImpl implements DlbmSrvcService {

    @Setter(onMethod_ = @Autowired)
    private DlbmSrvceMapper dlbmSrvceMapper;

    @Override
    public int register(DlbmSrvceVO dlbmSrvceVO) {
        return dlbmSrvceMapper.insertSrvc(dlbmSrvceVO);
    }

    @Override
    public DlbmSrvceVO get(Long srvcId) {

        DlbmSrvceVO dlbmSrvceVO =  dlbmSrvceMapper.readSrvc(srvcId);

        return dlbmSrvceVO;
    }

    @Override
    public boolean remove(Long srvcId) {

        int removeRes = dlbmSrvceMapper.deleteSrvc(srvcId);
        log.info("삭제 결과:" + removeRes);

        return removeRes == 1;
    }
}
