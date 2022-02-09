package com.dolbom.mapper.boardtest;


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
import java.util.Date;
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
        Date startDt = new SimpleDateFormat("yyyy-MM-dd").parse(strStartDt);
        Date endDt = new SimpleDateFormat("yyyy-MM-dd").parse(strEndDt);

        requestVO.setSrvcId(77L);
        requestVO.setCustId("cust9");
        requestVO.setReqTitle("testest");
        requestVO.setPostcode("1234");
        requestVO.setCustLoc("testadd");
        requestVO.setDetailAddress("asdfgh");
        requestVO.setStartDt(startDt);
        requestVO.setEndDt(endDt);
        requestVO.setReqDtl("aaaaa");
        requestVO.setCreatedBy("cust9");
        requestVO.setLastModifiedBy("cust9");
        requestMapper.insertRequest(requestVO);

    }

    @Test
    public void getRequest() {

        RequestVO req = requestMapper.retrieveRequest(7L);
        log.info(req);
    }


}
