package com.dolbom.mapper;


import com.dolbom.domain.Criteria;
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
public class DlbmMapperTests {

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
        DlbmVO dlbm = mapper.get(166L);
        dlbm.setLastModifiedBy("dlbm20");
        mapper.delete(dlbm);
    }


    @Test
    public void testGetList() {
        mapper.getList().forEach(srvc -> log.info(srvc));
    }

    @Test
    public void testModifyDlbm() {
        DlbmVO dlbm = mapper.get(166L);
        dlbm.setSrvcNm("modified dlbm service 제목");
        dlbm.setDetailAddress("modified detailed 상세주소");
        int res = mapper.modify(dlbm);
        log.info("*****" + dlbm);
    }

    @Test
    public void testPaging() {

        Criteria cri = new Criteria();
        cri.setPageNum(3);
        cri.setAmount(10);
        List<DlbmVO> list = mapper.getListWithPaging(cri);
        list.forEach(dlbm -> log.info(dlbm));
    }

    @Test
    public void testGetmyDlbmHist() {
        mapper.getmyDlbmHist("dlbm20").forEach(srvc -> log.info(srvc));
    }

    @Test
    public void testGetCmplDlbmHist() {
        mapper.getCmplDlbmHist("cust9").forEach(srvc -> log.info(srvc));
    }
}
