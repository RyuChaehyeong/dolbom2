package com.dolbom.service;

import com.dolbom.domain.DlbmSrvcVO;

import java.util.List;

public interface DlbmSrvcService {

    public int register (DlbmSrvcVO dlbmSrvcVO);

    public DlbmSrvcVO get(Long srvcId);

    public boolean remove(Long srvcId);

    public List<DlbmSrvcVO> getSrvcList();


}
