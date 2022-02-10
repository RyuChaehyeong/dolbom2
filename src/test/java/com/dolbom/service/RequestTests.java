package com.dolbom.service;

import com.dolbom.domain.DlbmSrvcVO;
import com.dolbom.domain.RequestVO;
import lombok.Setter;
import lombok.extern.log4j.Log4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class RequestTests {

    @Setter(onMethod_ = @Autowired)
    private  RequestService service;

    @Test
    public void testExist() {
        log.info(service);
        assertNotNull(service);
    }

    @Test
    public void insertRequestTest() throws ParseException {
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
        service.register(requestVO);

    }


    @Test
    public void getRequest() {
        RequestVO req = service.retrieveRequest(7L);
        log.info(req);
    }

    @Test
    public void modifyRequest() {
        RequestVO req = service.retrieveRequest(47L);
        log.info(req.toString());

        req.setReqDtl("수정된 상세!!");
        req.setReqTitle("수정된 제목!!");

        service.modifyRequest(req);
    }
}
