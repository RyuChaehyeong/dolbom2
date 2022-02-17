package com.dolbom.service;

import com.dolbom.domain.QuoteReqVO;

import java.util.List;
import java.util.Map;

public interface QuoteService {

    int register(QuoteReqVO quote);

    QuoteReqVO get(Long reqId);

    int modify(QuoteReqVO quote);

    int addQuoPrice(QuoteReqVO quote);

    int acceptQuo(QuoteReqVO quote);

    int delete(QuoteReqVO quote);

    Map<String, List<QuoteReqVO>> getQuoHist(String userId, String auth);

    int signQuo(QuoteReqVO quote);

    int upView(String reqId);
}
