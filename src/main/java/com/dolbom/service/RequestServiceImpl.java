package com.dolbom.service;

import com.dolbom.domain.DlbmSrvcVO;
import com.dolbom.domain.RequestVO;
import com.dolbom.mapper.DlbmSrvcMapper;
import com.dolbom.mapper.RequestMapper;
import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Log4j
@Service
@AllArgsConstructor
public class RequestServiceImpl implements RequestService {

    @Setter(onMethod_ = @Autowired)
    private RequestMapper requestMapper;

    @Override
    public int register(RequestVO requestVO) {
        String userId = requestVO.getCustId();
        requestVO.setCreatedBy(userId);
        requestVO.setLastModifiedBy(userId);
        return requestMapper.insertRequest(requestVO);
    }

    @Override
    public RequestVO retrieveRequest(Long reqId) {
        RequestVO request = requestMapper.retrieveRequest(reqId);
        return request;
    }

    @Override
    public int modifyRequest(RequestVO request) {
        request.setLastModifiedBy(request.getCustId());
        return requestMapper.modifyRequest(request);
    }

    @Override
    public int insertQuoPrice(RequestVO request) {
        return requestMapper.insertQuoPrice(request);
    }
}
