package com.dolbom.service;

import com.dolbom.domain.DlbmVO;

import java.util.List;

public interface DlbmService {

    int register (DlbmVO dlbm);

    DlbmVO get(Long srvcId);

    int delete(DlbmVO dlbm);

    List<DlbmVO> getList();

    int modify(DlbmVO dlbm);


}
