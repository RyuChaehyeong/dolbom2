package com.dolbom.mapper;

import com.dolbom.domain.RequestVO;

public interface RequestMapper {

    public int insertRequest(RequestVO serviceVO);

    public RequestVO retrieveRequest(Long reqId);
}
