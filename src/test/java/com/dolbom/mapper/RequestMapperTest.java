package com.dolbom.mapper;


import com.dolbom.domain.DlbmSrvcVO;
import com.dolbom.domain.RequestVO;
import com.dolbom.mapper.DlbmSrvcMapper;
import com.dolbom.mapper.RequestMapper;
import lombok.Setter;
import lombok.extern.log4j.Log4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import java.sql.Date;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
        {"file:src/main/webapp/WEB-INF/spring/root-context.xml",
                "file:src/main/webapp/WEB-INF/spring/security-context.xml"})
@Log4j
public class RequestMapperTest {

    @Setter(onMethod_ = @Autowired)
    private RequestMapper requestMapper;

    @Test
    public void insertSrvcTest() throws ParseException {

        RequestVO requestVO = new RequestVO();


        String strStartDt = "2022-01-05";
        String strEndDt = "2022-01-31";
        Date strDt = Date.valueOf(strStartDt);
        Date endDt = Date.valueOf(strEndDt);

        requestVO.setSrvcId(77L);
        requestVO.setCustId("cust9");
        requestVO.setReqTitle("testest");
        requestVO.setPostcode("1234");
        requestVO.setCustLoc("testadd");
        requestVO.setDetailAddress("asdfgh");
        requestVO.setStartDt(strDt);
        requestVO.setEndDt(endDt);
        requestVO.setReqDtl("aaaaa");
        requestVO.setCreatedBy("cust9");
        requestVO.setLastModifiedBy("cust9");
        requestMapper.insertRequest(requestVO);

    }

    @Test
    public void getRequest() {

        RequestVO req = requestMapper.retrieveRequest(7L);
        log.info(req.toString());
    }

    @Test
    public void modifyRequest() {
        RequestVO req = requestMapper.retrieveRequest(47L);
        log.info(req.toString());

        req.setReqDtl("수정된 상세");
        req.setReqTitle("수정된 제목");

        requestMapper.modifyRequest(req);

    }

    @Test
    public void insertQuoPrice() {
        RequestVO req = requestMapper.retrieveRequest(47L);
        req.setQuoPrice("10000");
        req.setLastModifiedBy("dlbm20");
        req.setReqPrgrStatCd("30");
        requestMapper.insertQuoPrice(req);
    }
}
