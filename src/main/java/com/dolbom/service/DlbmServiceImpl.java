package com.dolbom.service;

import com.dolbom.domain.DlbmVO;
import com.dolbom.mapper.DlbmMapper;
import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Log4j
@Service
@AllArgsConstructor
public class DlbmServiceImpl implements DlbmService {

    @Setter(onMethod_ = @Autowired)
    private DlbmMapper dlbmMapper;

    @Override
    public int register(DlbmVO dlbm) {
        return dlbmMapper.register(dlbm);
    }

    @Override
    public DlbmVO get(Long srvcId) {

        DlbmVO dlbm =  dlbmMapper.get(srvcId);
        return dlbm;
    }

    @Override
    public boolean delete(Long srvcId) {

        int delCnt = dlbmMapper.delete(srvcId);
        log.info("DELETE RESULT:" + delCnt);
        return delCnt == 1;
    }

    @Override
    public List<DlbmVO> getList() {

        List<DlbmVO> srvcList = dlbmMapper.getList();
        return srvcList;
    }
}
