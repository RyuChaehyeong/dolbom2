package com.dolbom.security.auth;

import com.dolbom.domain.auth.DlbmUserAuthVO;
import com.dolbom.domain.auth.DlbmUserVO;
import com.dolbom.service.DlbmUserService;
import lombok.Setter;
import lombok.extern.log4j.Log4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
        {"file:src/main/webapp/WEB-INF/spring/root-context.xml",
                "file:src/main/webapp/WEB-INF/spring/security-context.xml"})
@Log4j
public class DlbmUserServiceTests {

    @Setter(onMethod_ = @Autowired)
    private DlbmUserService dlbmUserService;

    @Setter(onMethod_ = @Autowired)
    private PasswordEncoder pwencoder;

    @Test
    public void testExist() {
        log.info(dlbmUserService);
        assertNotNull(dlbmUserService);
    }

    @Test
    public void testRegister() {
        DlbmUserVO dlbmUser = new DlbmUserVO();
        DlbmUserAuthVO auth = new DlbmUserAuthVO();

        String userId = "chaehyeong55";
        dlbmUser.setUserId(userId);
        dlbmUser.setUserPwd("123");
        dlbmUser.setUserNm("유채형");
        dlbmUser.setUserEmail("fluid15@test.com");
        dlbmUser.setUserPhone("01012345678");
        dlbmUser.setUserTypeCd("10");
        dlbmUser.setCreatedBy(userId);
        dlbmUser.setLastModifiedBy(userId);

        auth.setUserId(userId);
        auth.setAuth("ROLD_DLBM");
        dlbmUserService.register(dlbmUser, auth);
    }


}
