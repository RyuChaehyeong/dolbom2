package com.dolbom.mapper;

import com.dolbom.domain.DlbmVO;

import java.util.List;

public interface DlbmMapper {

    List<DlbmVO> getList();

    int register(DlbmVO serviceVO);

    DlbmVO get(Long srvcId);

    int delete(Long srvcId);
}
