package com.dolbom.mapper;


import com.dolbom.domain.DlbmSrvcVO;
import lombok.Setter;
import lombok.extern.log4j.Log4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
        {"file:src/main/webapp/WEB-INF/spring/root-context.xml",
                "file:src/main/webapp/WEB-INF/spring/security-context.xml"})
@Log4j
public class DlbmSrvcMapperTest {

    @Setter(onMethod_ = @Autowired)
    private DlbmSrvcMapper serviceMapper;

    @Test
    public void insertSrvcTest() {

        for (int i = 11 ; i <= 20 ; i++) {

            String srvcNm = "!돌봄 대표서비스" + i;
            String categoryCd = "1010";
            String srvcDtl = i + " 돌봄 대표서비스돌봄 대표서비스돌봄 대표서비스돌봄 대표서비스돌봄 대표서비스돌봄 대표서비스돌봄 대표서비스 " + i;
            String dlbmLoc = "제주특별시";
            String loginUser = "dlbm" + i;

            DlbmSrvcVO srvcVo = new DlbmSrvcVO();

            srvcVo.setSrvcNm(srvcNm);
            srvcVo.setCategoryCd(categoryCd);
            srvcVo.setSrvcDtl(srvcDtl);
            srvcVo.setDlbmLoc(dlbmLoc);
            srvcVo.setDlbmId(loginUser);
            srvcVo.setCreatedBy(loginUser);
            srvcVo.setLastModifiedBy(loginUser);

            serviceMapper.insertSrvc(srvcVo);
        }


    }

    @Test
    public void testReadSrvc() {

        DlbmSrvcVO dlbmSrvcVO = serviceMapper.readSrvc(53L);
        log.info(dlbmSrvcVO);
    }

    @Test
    public void testDeleteSrvc() {
        int res = serviceMapper.deleteSrvc(53L);
        log.info("******" + res +"");
    }


    @Test
    public void testGetSrvcList() {
        List<DlbmSrvcVO> list = new ArrayList<>();
        serviceMapper.getSrvcList().forEach(srvc -> log.info(srvc));
    }
}
