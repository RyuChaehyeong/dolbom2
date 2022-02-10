package com.dolbom.mapper;

import com.dolbom.domain.RequestVO;

public interface RequestMapper {

    public int insertRequest(RequestVO requestVO);

    public RequestVO retrieveRequest(Long reqId);

    public int modifyRequest(RequestVO requestVO);
}
