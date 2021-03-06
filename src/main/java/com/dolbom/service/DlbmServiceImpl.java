package com.dolbom.service;

import com.dolbom.domain.Criteria;
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
    public List<DlbmVO> getList(Criteria cri) {

        log.info("GET DLBM LIST WITH PAGING" + cri);
        List<DlbmVO> srvcList = dlbmMapper.getListWithPaging(cri);
        return srvcList;
    }

    @Override
    public int modify(DlbmVO dlbm) {
        return dlbmMapper.modify(dlbm);
    }

    @Override
    public int getTotalCnt(Criteria cri) {
        return dlbmMapper.getTotalCnt(cri);
    }

    /*돌봄이가 등록한 서비스 조회*/
    @Override
    public List<DlbmVO> getmyDlbmHist(String userId) {
        List<DlbmVO> myHist = dlbmMapper.getmyDlbmHist(userId);
        return myHist;
    }

    /*고객이 이용한 서비스 조회*/
    @Override
    public List<DlbmVO> getCmplDlbmHist(String userId) {
        List<DlbmVO> cmplHist = dlbmMapper.getCmplDlbmHist(userId);
        return cmplHist;
    }

    @Override
    public int upCnt(Long srvcId) {
        return dlbmMapper.upCnt(srvcId) ;
    }
}
