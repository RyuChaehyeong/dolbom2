package com.dolbom.service;

import com.dolbom.domain.DlbmSrvcVO;
import lombok.Setter;
import lombok.extern.log4j.Log4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class DlbmSrvcServiceTests {

    @Setter(onMethod_ = @Autowired)
    private DlbmSrvcService service;

    @Test
    public void testExist() {
        log.info(service);
        assertNotNull(service);
    }

    @Test
    public void testRegister() {
        for (int i = 11 ; i <= 20 ; i++) {

            int j = i + 5;

            String srvcNm = "대표서비스 돌봄" + j;
            String categoryCd = "1010";
            String srvcDtl = j + " 돌봄 대표서비스돌봄 대표서비스돌봄 대표서비스돌봄 대표서비스돌봄 대표서비스돌봄 대표서비스돌봄 대표서비스 " + j;
            String dlbmLoc = "강원도 강릉시";
            String loginUser = "dlbm" + i;

            DlbmSrvcVO srvcVo = new DlbmSrvcVO();

            srvcVo.setSrvcNm(srvcNm);
            srvcVo.setSrvcDtl(srvcDtl);
            srvcVo.setDlbmLoc(dlbmLoc);
            srvcVo.setDlbmId(loginUser);
            srvcVo.setCreatedBy(loginUser);
            srvcVo.setLastModifiedBy(loginUser);

            service.register(srvcVo);

            log.info("생성된 서비스 ID : " + srvcVo.getSrvcNm());
        }
    }

    @Test
    public void testReadSrvc() {
        DlbmSrvcVO srvceVO = service.get(82L);
        log.info("****" + srvceVO);
        assertNotNull(srvceVO);
    }

    @Test
    public void testRemoveSrvc() {
        service.remove(82L);

        DlbmSrvcVO srvceVO = service.get(82L);
        assertEquals(srvceVO.getDltYn(), "Y");
    }


    @Test
    public void testGetSrvcList() {
        service.getSrvcList().forEach(srvc -> log.info(srvc));
    }


}
