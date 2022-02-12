package com.dolbom.mapper;

import com.dolbom.domain.RequestVO;

public interface RequestMapper {

    public int insertRequest(RequestVO request);

    public RequestVO retrieveRequest(Long reqId);

    public int modifyRequest(RequestVO request);

    public int insertQuoPrice(RequestVO request);

    public int deleteRequest(RequestVO request);
}
