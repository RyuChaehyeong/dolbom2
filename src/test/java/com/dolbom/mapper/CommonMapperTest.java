package com.dolbom.mapper;


import com.dolbom.domain.common.CommonCodeVO;
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
public class CommonMapperTest {

    @Setter(onMethod_ = @Autowired)
    private CommonMapper commonMapper;

    @Test
    public void retrieveCmmnCd() {
        List<CommonCodeVO> cdList = commonMapper.retrieveCode("A01");
        for(CommonCodeVO cd : cdList) {
            System.out.println("***" + cd);
        }
    }

}
