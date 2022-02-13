package com.dolbom.service;

import com.dolbom.domain.DlbmVO;

import java.util.List;

public interface DlbmService {

    int register (DlbmVO dlbm);

    DlbmVO get(Long srvcId);

    boolean delete(Long srvcId);

    List<DlbmVO> getList();


}
