package com.dolbom.service;

import com.dolbom.domain.DlbmSrvcVO;
import com.dolbom.domain.RequestVO;

import java.util.List;

public interface RequestService {

    public int register(RequestVO request);

    public RequestVO retrieveRequest(Long reqId);

    public int modifyRequest(RequestVO request);

    public int insertQuoPrice(RequestVO request);
}
