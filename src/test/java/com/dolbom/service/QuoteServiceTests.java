package com.dolbom.service;

import com.dolbom.domain.QuoteReqVO;
import lombok.Setter;
import lombok.extern.log4j.Log4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.text.ParseException;
import java.sql.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class QuoteServiceTests {

    @Setter(onMethod_ = @Autowired)
    private QuoteService service;

    @Test
    public void testExist() {
        log.info(service);
        assertNotNull(service);
    }

    @Test
    public void testRegisterQuoTest() throws ParseException {
        QuoteReqVO quote = new QuoteReqVO();


        String strStartDt = "2022-01-05";
        String strEndDt = "2022-01-31";
        Date strDt = Date.valueOf(strStartDt);
        Date endDt = Date.valueOf(strEndDt);

        quote.setSrvcId(77L);
        quote.setCustId("cust9");
        quote.setReqTitle("test quo title");
        quote.setPostcode("1234");
        quote.setCustLoc("test cust loc");
        quote.setDetailAddress("test detail address");
        quote.setStartDt(strDt);
        quote.setEndDt(endDt);
        quote.setReqDtl("test req dtl");
        quote.setCreatedBy("cust9");
        quote.setLastModifiedBy("cust9");
        service.register(quote);

    }


    @Test
    public void testGetQuote() {
        QuoteReqVO req = service.get(7L);
        log.info(req);
    }

    @Test
    public void testModifyQuo() {
        QuoteReqVO req = service.get(47L);
        log.info(req.toString());

        req.setReqDtl("modified detail");
        req.setReqTitle("modified title");

        service.modify(req);
    }

    @Test
    public void testAddQuoPrice() {
        QuoteReqVO req = service.get(11L);
        req.setQuoPrice("10000");
        req.setLastModifiedBy("dlbm20");
        req.setReqPrgrStatCd("30");
        service.addQuoPrice(req);
    }

    @Test
    public void testAcceptQuo() {
        QuoteReqVO req = service.get(72L);
        req.setLastModifiedBy("cust9");
        service.addQuoPrice(req);
    }


    @Test
    public void deleteQuo() {
        QuoteReqVO req = service.get(11L);
        req.setLastModifiedBy("cust9");
        service.delete(req);
    }
}
