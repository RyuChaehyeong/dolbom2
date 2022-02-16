package com.dolbom.service;

import com.dolbom.domain.ReviewVO;
import lombok.Setter;
import lombok.extern.log4j.Log4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
        {"file:src/main/webapp/WEB-INF/spring/root-context.xml",
                "file:src/main/webapp/WEB-INF/spring/security-context.xml"})
@Log4j
public class ReviewServiceTests {

    @Setter(onMethod_ = @Autowired)
    private ReviewService service;

    @Test
    public void testExist() {
        log.info(service);
        assertNotNull(service);
    }


    @Test
    public void testGetList() {
        List<ReviewVO> list = service.getList(77L);
        list.forEach(review -> log.info(review));
    }

}
