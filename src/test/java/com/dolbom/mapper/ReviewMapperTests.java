package com.dolbom.mapper;

import com.dolbom.domain.DlbmVO;
import com.dolbom.domain.ReviewVO;
import lombok.Setter;
import lombok.extern.log4j.Log4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
        {"file:src/main/webapp/WEB-INF/spring/root-context.xml",
                "file:src/main/webapp/WEB-INF/spring/security-context.xml"})
@Log4j
public class ReviewMapperTests {

    @Setter(onMethod_ = @Autowired)
    private ReviewMapper reviewMapper;

    @Test
    public void testGetReviewList() {
        List<ReviewVO> list = reviewMapper.getList(77L);
        list.forEach(review -> log.info(review));
    }
}
