package com.dolbom.service;

import com.dolbom.domain.QuoteReqVO;
import com.dolbom.mapper.QuoteMapper;
import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Log4j
@Service
@AllArgsConstructor
public class QuoteServiceImpl implements QuoteService {

    @Setter(onMethod_ = @Autowired)
    private QuoteMapper quoteMapper;

    @Override
    public int register(QuoteReqVO quote) {
        String userId = quote.getCustId();
        quote.setCreatedBy(userId);
        quote.setLastModifiedBy(userId);
        return quoteMapper.register(quote);
    }

    @Override
    public QuoteReqVO get(Long reqId) {
        QuoteReqVO request = quoteMapper.get(reqId);
        return request;
    }

    @Override
    public int modify(QuoteReqVO quote) {
        return quoteMapper.modify(quote);
    }

    @Override
    public int addQuoPrice(QuoteReqVO quote) {
        return quoteMapper.addQuoPrice(quote);
    }

    @Override
    public int acceptQuo(QuoteReqVO quote) {
        return quoteMapper.acceptQuo(quote);
    }

    @Override
    public int delete(QuoteReqVO quote) {
        return quoteMapper.delete(quote);
    }

    @Override
    public Map<String, List<QuoteReqVO>> getQuoHist(String userId, String auth) {
        Map<String, List<QuoteReqVO>> map = new HashMap<>();
        List<QuoteReqVO> cmpl = quoteMapper.getQuoHist(userId, auth, "cmpl");
        List<QuoteReqVO> prgr =quoteMapper.getQuoHist(userId, auth, "prgr");

        map.put("cmplList", cmpl);
        map.put("prgrList", prgr);

        return map;

    }
}
