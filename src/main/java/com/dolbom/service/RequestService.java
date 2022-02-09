package com.dolbom.service;

import com.dolbom.domain.DlbmSrvcVO;
import com.dolbom.domain.RequestVO;

import java.util.List;

public interface RequestService {

    public int register (RequestVO requestVO);

    public RequestVO retrieveRequest(Long reqId);

}
