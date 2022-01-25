package com.dolbom.mapper;

import com.dolbom.domain.DlbmSrvcVO;

import java.util.List;

public interface DlbmSrvcMapper {

    public List<DlbmSrvcVO> getSrvcList();

    public int insertSrvc(DlbmSrvcVO serviceVO);

    public DlbmSrvcVO readSrvc(Long srvcId);

    public int deleteSrvc(Long srvcId);
}
