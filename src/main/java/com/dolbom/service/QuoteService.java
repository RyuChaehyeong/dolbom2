package com.dolbom.service;

import com.dolbom.domain.QuoteReqVO;

public interface QuoteService {

    int register(QuoteReqVO quote);

    QuoteReqVO get(Long reqId);

    int modify(QuoteReqVO quote);

    int addQuoPrice(QuoteReqVO quote);

    int delete(QuoteReqVO quote);
}
