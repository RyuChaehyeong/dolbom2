package com.dolbom.service;

import com.dolbom.domain.Criteria;
import com.dolbom.domain.DlbmVO;
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
@ContextConfiguration(
        {"file:src/main/webapp/WEB-INF/spring/root-context.xml",
                "file:src/main/webapp/WEB-INF/spring/security-context.xml"})
@Log4j
public class DlbmServiceTests {

    @Setter(onMethod_ = @Autowired)
    private DlbmService service;

    @Test
    public void testExist() {
        log.info(service);
        assertNotNull(service);
    }

    @Test
    public void testRegisterDlbm() {
        for (int i = 11 ; i <= 20 ; i++) {

            int j = i + 5;

            String srvcNm = "코리아대표서비스 돌봄" + j;
            String srvcDtl = j + " 돌봄 대표서비스돌봄 대표서비스돌봄 대표서비스돌봄 대표서비스돌봄 대표서비스돌봄 대표서비스돌봄 대표서비스 " + j;
            String dlbmLoc = "서울 남산";
            String loginUser = "dlbm" + i;

            DlbmVO srvcVo = new DlbmVO();

            srvcVo.setSrvcNm(srvcNm);
            srvcVo.setAnimalCtgrCd("10");
            srvcVo.setBreedCtgrCd("10");
            srvcVo.setSrvcDtl(srvcDtl);
            srvcVo.setDlbmLoc(dlbmLoc);
            srvcVo.setDlbmId(loginUser);
            srvcVo.setCreatedBy(loginUser);
            srvcVo.setLastModifiedBy(loginUser);

            service.register(srvcVo);

            log.info("생성된 서비스 ID : " + srvcVo.getSrvcId());
        }
    }

    @Test
    public void testGetDlbm() {
        DlbmVO srvceVO = service.get(146L);
        log.info("****" + srvceVO);
        assertNotNull(srvceVO);
    }


    @Test
    public void testGetList() {
        service.getList(new Criteria(2,10)).forEach(srvc -> log.info(srvc));
    }

    @Test
    public void testModifyDlbm() {
        DlbmVO dlbm = service.get(166L);
        dlbm.setSrvcNm("modified dlbm service 제목!!");
        dlbm.setAnimalCtgrCd("A01");
        dlbm.setBreedCtgrCd("01");
        dlbm.setPostcode("111");
        dlbm.setDlbmLoc("test Loc");
        dlbm.setDetailAddress("test detail addr");
        dlbm.setSrvcDtl("test srvc Dtl");
        dlbm.setLastModifiedBy("dlbm20");
        int res = service.modify(dlbm);
        log.info("*****" + dlbm);
    }

    @Test
    public void testDeleteDlbm() {
        DlbmVO dlbm = service.get(166L);
        dlbm.setLastModifiedBy("dlbm20");
        service.delete(dlbm);
    }


}
