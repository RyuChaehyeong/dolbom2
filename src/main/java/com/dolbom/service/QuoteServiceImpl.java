package com.dolbom.service;

import com.dolbom.domain.DlbmVO;
import com.dolbom.domain.MailVO;
import com.dolbom.domain.QuoteReqVO;
import com.dolbom.domain.auth.DlbmUserVO;
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

        //견적에 연결된 돌봄서비스 정보
        DlbmVO dlbm = dlbmMapper.get(quote.getSrvcId());
        String dlbmId = dlbm.getDlbmId();
        String srvcNm = dlbm.getSrvcNm();

        //양식에 들어갈 내용
        Map<String, String> mailMap = new HashMap<String, String>();
        mailMap.put("$dlbmId$", dlbmId);
        mailMap.put("$srvcNm$", srvcNm);

        //template 조회
        MailVO mailTmplInfo = mailMapper.getMailTemplInfo("100", "10");
        String receiver = dlbmUserMapper.getEmail(dlbmId);
        mailTmplInfo.setReceiver(receiver);
        String mailContent = MailUtil.quoPrgrNotiMail(mailMap, mailTmplInfo);
        mailTmplInfo.setMailContent(mailContent);

        //메일 이력 저장
        mailMapper.registerHist(mailTmplInfo);
        log.info("SAVE EMAIL SEND HISTORY");

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

        String custId = quote.getCustId();

        Map<String, String> mailMap = new HashMap<String, String>();
        mailMap.put("$custId$", custId);

        MailVO mailTmplInfo = mailMapper.getMailTemplInfo("100", "30");
        String receiver = dlbmUserMapper.getEmail(custId);
        mailTmplInfo.setReceiver(receiver);
        String mailContent = MailUtil.quoPrgrNotiMail(mailMap, mailTmplInfo);
        mailTmplInfo.setMailContent(mailContent);

        //메일 이력 저장
        mailMapper.registerHist(mailTmplInfo);


        return quoteMapper.addQuoPrice(quote);
    }

    @Override
    public int acceptQuo(QuoteReqVO quote) {

        DlbmVO dlbm = dlbmMapper.get(quote.getSrvcId());
        String dlbmId = dlbm.getDlbmId();
        String reqId = Long.toString(quote.getReqId());

        Map<String, String> mailMap = new HashMap<String, String>();
        mailMap.put("$dlbmId$", dlbmId);
        mailMap.put("$reqId$", reqId);

        MailVO mailTmplInfo = mailMapper.getMailTemplInfo("100", "40");
        String receiver = dlbmUserMapper.getEmail(dlbmId);
        mailTmplInfo.setReceiver(receiver);
        String mailContent = MailUtil.quoPrgrNotiMail(mailMap, mailTmplInfo);
        //메일 이력 저장
        mailTmplInfo.setMailContent(mailContent);

        mailMapper.registerHist(mailTmplInfo);


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
    public int signQuo(QuoteReqVO quoteReqVO) {


        //견적서 정보
        String reqId = Long.toString(quoteReqVO.getReqId());
        QuoteReqVO quote = quoteMapper.get(Long.parseLong(reqId));
        String reqTitle = quote.getReqTitle();
        String startDt = String.format("%1$tY-%1$tm-%1$td",quote.getStartDt());
        String endDt = String.format("%1$tY-%1$tm-%1$td",quote.getEndDt());
        String custLoc = quote.getCustLoc();
        String detailAddress = quote.getDetailAddress();
        String custId = quote.getCustId();

        //돌봄 서비스 정보
        DlbmVO dlbm = dlbmMapper.get(quote.getSrvcId());
        String dlbmId = dlbm.getDlbmId();
        String srvcNm = dlbm.getSrvcNm();

        //돌봄이와 고객 정보
        DlbmUserVO dlbmUser = dlbmUserMapper.getUserInfo(dlbmId);
        DlbmUserVO custUser = dlbmUserMapper.getUserInfo(quote.getCustId());
        String dlbmPhone = dlbmUser.getUserPhone();
        String dlbmEmail = dlbmUser.getUserEmail();
        String custPhone = custUser.getUserPhone();
        String custEmail = custUser.getUserEmail();

        Map<String, String> mailMap = new HashMap<String, String>();
        mailMap.put("$reqId$", reqId);
        mailMap.put("$reqTitle$", reqTitle);
        mailMap.put("$startDt$", startDt);
        mailMap.put("$endDt$", endDt);
        mailMap.put("$custLoc$", custLoc);
        mailMap.put("$detailAddress$", detailAddress);
        mailMap.put("$dlbmId$", dlbmId);
        mailMap.put("$srvcNm$", srvcNm);
        mailMap.put("$dlbmPhone$", dlbmPhone);
        mailMap.put("$dlbmEmail$", dlbmEmail);
        mailMap.put("$custPhone$", custPhone);
        mailMap.put("$custEmail$", custEmail);

        MailVO mailTmplInfo = mailMapper.getMailTemplInfo("100", "50");
        String receiver = "";
        String mailContent = "";

        //돌봄이에게 메일 발송
        receiver = dlbmUserMapper.getEmail(dlbmId);
        mailTmplInfo.setReceiver(receiver);
        mailContent = MailUtil.quoPrgrNotiMail(mailMap, mailTmplInfo);
        //메일 이력 저장
        mailTmplInfo.setMailContent(mailContent);
        mailMapper.registerHist(mailTmplInfo);

        //고객에게 메일 발송
        receiver = dlbmUserMapper.getEmail(custId);
        mailTmplInfo.setReceiver(receiver);
        mailContent = MailUtil.quoPrgrNotiMail(mailMap, mailTmplInfo);
        //메일 이력 저장
        mailTmplInfo.setMailContent(mailContent);
        mailMapper.registerHist(mailTmplInfo);


        return quoteMapper.signQuo(quote);
    }

    @Override
    public int upView(String reqId) {
        return quoteMapper.upView(reqId);
    }
}
