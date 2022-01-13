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
    public void register(DlbmSrvceVO dlbmSrvceVO) {

    }

    @Override
    public DlbmSrvceVO get(Long srvcId) {
        return null;
    }

    @Override
    public boolean remove(Long srvcId) {
        return false;
    }
}
