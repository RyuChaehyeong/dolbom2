package com.dolbom.service;

import com.dolbom.domain.Criteria;
import com.dolbom.domain.DlbmVO;

import java.util.List;

public interface DlbmService {

    int register (DlbmVO dlbm);

    DlbmVO get(Long srvcId);

    int delete(DlbmVO dlbm);

    List<DlbmVO> getList(Criteria cri);

    int modify(DlbmVO dlbm);

    int getTotalCnt(Criteria cri);

    List<DlbmVO> getmyDlbmHist(String userId);

    List<DlbmVO> getCmplDlbmHist(String userId);
}
