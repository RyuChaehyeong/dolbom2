package com.dolbom.service;

import com.dolbom.domain.DlbmSrvcVO;
import com.dolbom.mapper.DlbmSrvcMapper;
import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Log4j
@Service
@AllArgsConstructor
public class DlbmSrvcServiceImpl implements DlbmSrvcService {

    @Setter(onMethod_ = @Autowired)
    private DlbmSrvcMapper dlbmSrvcMapper;

    @Override
    public int register(DlbmSrvcVO dlbmSrvcVO) {
        return dlbmSrvcMapper.insertSrvc(dlbmSrvcVO);
    }

    @Override
    public DlbmSrvcVO get(Long srvcId) {

        DlbmSrvcVO dlbmSrvcVO =  dlbmSrvcMapper.readSrvc(srvcId);

        return dlbmSrvcVO;
    }

    @Override
    public boolean remove(Long srvcId) {

        int removeRes = dlbmSrvcMapper.deleteSrvc(srvcId);
        log.info("삭제 결과:" + removeRes);

        return removeRes == 1;
    }

    @Override
    public List<DlbmSrvcVO> getSrvcList() {
        List<DlbmSrvcVO> srvcList = dlbmSrvcMapper.getSrvcList();
        return srvcList;
    }
}
