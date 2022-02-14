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
        String userId = dlbm.getDlbmId();
        dlbm.setCreatedBy(userId);
        dlbm.setLastModifiedBy(userId);
        return dlbmMapper.register(dlbm);
    }

    @Override
    public DlbmVO get(Long srvcId) {

        DlbmVO dlbm =  dlbmMapper.get(srvcId);
        return dlbm;
    }

    @Override
    public int delete(DlbmVO dlbm) {
        return dlbmMapper.delete(dlbm);
    }


    @Override
    public List<DlbmVO> getList() {

        List<DlbmVO> srvcList = dlbmMapper.getList();
        return srvcList;
    }

    @Override
    public int modify(DlbmVO dlbm) {
        return dlbmMapper.modify(dlbm);
    }
}
