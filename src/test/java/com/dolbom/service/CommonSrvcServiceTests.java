package com.dolbom.service;

import com.dolbom.domain.common.CommonCodeVO;
import com.dolbom.service.common.CommonService;
import lombok.Setter;
import lombok.extern.log4j.Log4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class CommonSrvcServiceTests {

    @Setter(onMethod_ = @Autowired)
    private CommonService service;

    @Test
    public void testExist() {
        log.info(service);
        assertNotNull(service);
    }

    @Test
    public void retrieveCmmnCd() {
        List<CommonCodeVO> cdList = service.retrieveCode("A01");
        for(CommonCodeVO cd : cdList) {
            System.out.println("***" + cd);
        }
    }

}
