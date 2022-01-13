package com.dolbom.mapper;


import com.dolbom.domain.DlbmSrvceVO;
import lombok.Setter;
import lombok.extern.log4j.Log4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
        {"file:src/main/webapp/WEB-INF/spring/root-context.xml",
                "file:src/main/webapp/WEB-INF/spring/security-context.xml"})
@Log4j
public class DlbmSrvcMapperTest {

    @Setter(onMethod_ = @Autowired)
    private DlbmSrvceMapper serviceMapper;

    @Test
    public void insertSrvcTest() {

        for (int i = 11 ; i <= 20 ; i++) {

            String srvcNm = "돌봄 대표서비스" + i;
            String categoryCd = "1010";
            String srvcDtl = i + " 돌봄 대표서비스돌봄 대표서비스돌봄 대표서비스돌봄 대표서비스돌봄 대표서비스돌봄 대표서비스돌봄 대표서비스 " + i;
            String dlbmLoc = "제주특별시";
            String loginUser = "dlbm" + i;

            DlbmSrvceVO srvcVo = new DlbmSrvceVO();

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

        DlbmSrvceVO dlbmSrvceVO = serviceMapper.readSrvc(53L);
        log.info(dlbmSrvceVO);
    }

    @Test
    public void testDeleteSrvc() {
        int res = serviceMapper.deleteSrvc(53L);
        log.info("******" + res +"");
    }
}
