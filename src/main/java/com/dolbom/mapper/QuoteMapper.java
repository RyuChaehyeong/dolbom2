package com.dolbom.mapper;

import com.dolbom.domain.QuoteReqVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface QuoteMapper {

    int register(QuoteReqVO request);

    QuoteReqVO get(Long reqId);

    int modify(QuoteReqVO request);

    int addQuoPrice(QuoteReqVO request);

    int delete(QuoteReqVO request);

    int acceptQuo(QuoteReqVO request);

    List<QuoteReqVO> getQuoHist(@Param("userId" )String userId,
                                @Param("auth") String auth,
                                @Param("status") String status);

    int signQuo(QuoteReqVO quote);

    int upView(String reqId);
}
