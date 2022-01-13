package com.dolbom.service;

import com.dolbom.domain.DlbmSrvceVO;
import org.springframework.stereotype.Service;

public interface DlbmSrvcService {

    public void register (DlbmSrvceVO dlbmSrvceVO);

    public DlbmSrvceVO get(Long srvcId);

    public boolean remove(Long srvcId);

}
