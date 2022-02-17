package com.dolbom.service;

import com.dolbom.domain.DlbmVO;
import com.dolbom.domain.MailVO;
import com.dolbom.domain.QuoteReqVO;
import com.dolbom.mapper.DlbmMapper;
import com.dolbom.mapper.MailMapper;
import com.dolbom.mapper.QuoteMapper;
import com.dolbom.mapper.auth.DlbmUserMapper;
import com.dolbom.util.MailUtil;
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

    @Setter(onMethod_ = @Autowired)
    private DlbmMapper dlbmMapper;

    @Setter(onMethod_ = @Autowired)
    private MailMapper mailMapper;

    @Setter(onMethod_ = @Autowired)
    private DlbmUserMapper dlbmUserMapper;

    @Override
    public int register(QuoteReqVO quote) {

        String userId = quote.getCustId();
        quote.setCreatedBy(userId);
        quote.setLastModifiedBy(userId);

        //견적 등록 메일 발송
        DlbmVO dlbm = dlbmMapper.get(quote.getSrvcId());
        String dlbmId = dlbm.getDlbmId();
        String srvcNm = dlbm.getSrvcNm();

        Map<String, String> mailMap = new HashMap<String, String>();
        mailMap.put("$dlbmId$", dlbmId);
        mailMap.put("$srvcNm$", srvcNm);

        //양식 불러오기
        String template = mailMapper.getTemplate("100", "10");

        //메일 양식에 있는 중괄호 텍스트를 내용으로 변경하는 메소드 사용
        String mailContent = MailUtil.changeContent(template, mailMap);
        String mailSj = "[돌봄] 견적 등록 안내";
        //메일 주소
        String receiver = dlbmUserMapper.getEmail(dlbm.getDlbmId());
        MailUtil.sendEmail(mailSj, mailContent, receiver);

        MailVO mail = new MailVO("100", "10", mailSj, mailContent, receiver);

        mailMapper.registerHist(mail);
        log.info("QUOTE REGISTRATION NOTICE MAIL SENDING");

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

    @Override
    public int signQuo(QuoteReqVO quote) {
        return quoteMapper.signQuo(quote);
    }

    @Override
    public int upView(String reqId) {
        return quoteMapper.upView(reqId);
    }
}
