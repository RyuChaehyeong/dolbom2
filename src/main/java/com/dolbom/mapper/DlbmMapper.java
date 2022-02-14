package com.dolbom.mapper;

import com.dolbom.domain.DlbmVO;

import java.util.List;

public interface DlbmMapper {

    List<DlbmVO> getList();

    int register(DlbmVO dlbm);

    DlbmVO get(Long srvcId);

    int delete(DlbmVO dlbm);

    int modify(DlbmVO dlbm);
}
