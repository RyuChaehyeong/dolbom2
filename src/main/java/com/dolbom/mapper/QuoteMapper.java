package com.dolbom.mapper;

import com.dolbom.domain.QuoteReqVO;

public interface QuoteMapper {

    int register(QuoteReqVO request);

    QuoteReqVO get(Long reqId);

    int modify(QuoteReqVO request);

    int addQuoPrice(QuoteReqVO request);

    int delete(QuoteReqVO request);

    int acceptQuo(QuoteReqVO request);
}
