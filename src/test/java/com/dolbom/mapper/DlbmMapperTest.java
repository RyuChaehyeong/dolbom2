package com.dolbom.mapper;


import com.dolbom.domain.DlbmVO;
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
public class DlbmMapperTest {

    @Setter(onMethod_ = @Autowired)
    private DlbmMapper mapper;

    @Test
    public void testRegisterDlbm() {

        for (int i = 11 ; i <= 13 ; i++) {

            String srvcNm = "!돌봄 대표서비스~!!" + i;
            String srvcDtl = i + " 돌봄 대표서비스돌봄 대표서비스돌봄 대표서비스돌봄 대표서비스돌봄 대표서비스돌봄 대표서비스돌봄 대표서비스 " + i;
            String dlbmLoc = "제주특별시";
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

            mapper.register(srvcVo);
        }


    }

    @Test
    public void testGetDlbm() {

        DlbmVO dlbm = mapper.get(148L);
        log.info(dlbm);
    }

    @Test
    public void testDeleteDlbm() {
        int res = mapper.delete(53L);
        log.info("******" + res +"");
    }


    @Test
    public void testGetList() {
        mapper.getList().forEach(srvc -> log.info(srvc));
    }
}
