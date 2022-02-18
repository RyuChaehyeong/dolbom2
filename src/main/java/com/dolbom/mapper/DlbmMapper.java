package com.dolbom.mapper;

import com.dolbom.domain.Criteria;
import com.dolbom.domain.DlbmVO;

import java.util.List;

public interface DlbmMapper {

    List<DlbmVO> getList();

    List<DlbmVO> getListWithPaging(Criteria cri);

    int register(DlbmVO dlbm);

    DlbmVO get(Long srvcId);

    int delete(DlbmVO dlbm);

    int modify(DlbmVO dlbm);

    int getTotalCnt(Criteria cri);

    List<DlbmVO> getmyDlbmHist(String userId);

    List<DlbmVO> getCmplDlbmHist(String userId);

    int upCnt(Long srvcId);

    int updateRate(Long srvcId);
}

