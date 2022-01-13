package com.dolbom.mapper;

import com.dolbom.domain.DlbmSrvceVO;

public interface DlbmSrvceMapper {

    public int insertSrvc(DlbmSrvceVO serviceVO);

    public DlbmSrvceVO readSrvc(Long srvcId);

    public int deleteSrvc(Long srvcId);
}
