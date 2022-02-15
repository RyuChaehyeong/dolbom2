package com.dolbom.security.auth;

import com.dolbom.domain.auth.AdminUserVO;
import com.dolbom.domain.auth.DlbmUserAuthVO;
import com.dolbom.domain.auth.DlbmUserVO;
import com.dolbom.mapper.auth.AdminUserMapper;
import com.dolbom.mapper.auth.DlbmUserMapper;
import lombok.Setter;
import lombok.extern.log4j.Log4j;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
        {"file:src/main/webapp/WEB-INF/spring/root-context.xml",
                "file:src/main/webapp/WEB-INF/spring/security-context.xml"})
@Log4j
public class DlbmUserMapperTests {

    @Setter(onMethod_ = @Autowired)
    private PasswordEncoder pwencoder;

    @Setter(onMethod_ = @Autowired)
    private DataSource ds;

    @Setter(onMethod_ = @Autowired)
    private DlbmUserMapper dlbmUserMapper;

    @Setter(onMethod_ = @Autowired)
    private AdminUserMapper adminUserMapper;

    @Test
    public void testInsertMember() {
        String sql = "INSERT INTO DLBM_USER (" +
                "USER_ID, USER_SN, USER_NM, USER_PWD, USER_EMAIL, USER_TYPE_CD, CREATED_DT, CREATED_BY, LAST_MODIFIED_DT, LAST_MODIFIED_BY) VALUES " +
                "( ?, USER_SN_SEQ.nextval, ?, ?, ?, ?, sysdate, ?, sysdate, ?)";

        for (int i = 1; i <= 20; i++) {
            Connection con = null;
            PreparedStatement pstmt = null;

            try {
                con = ds.getConnection();
                pstmt = con.prepareStatement(sql);

                pstmt.setString(3, pwencoder.encode("pw" + i));
                pstmt.setString(6, "fluid21");
                pstmt.setString(7, "fluid21");

                if (i < 11) {
                    pstmt.setString(1, "cust" + i);
                    pstmt.setString(2, "고객" + i);
                    pstmt.setString(4, "custemail" + i + "email.com");
                    pstmt.setString(5, "10");


                } else {
                    pstmt.setString(1, "dlbm" + i);
                    pstmt.setString(2, "돌봄씨" + i);
                    pstmt.setString(4, "dlbmemail" + i + "email.com");
                    pstmt.setString(5, "20");
                }

                pstmt.executeUpdate();

            } catch (Exception e) {
                e.printStackTrace();

            } finally {
                if (pstmt != null) {
                    try {
                        pstmt.close();
                    } catch (Exception e) {

                    }
                }

                if (con != null) {
                    try {
                        con.close();
                    } catch (Exception e) {

                    }
                }
            }

        }
    }


    @Test
    public void testInsertAuth() {
        String sql = "INSERT INTO DLBM_USER_AUTH (USER_ID, AUTH) values (?, ?)";

        for (int i = 1; i <= 20; i++) {
            Connection con = null;
            PreparedStatement pstmt = null;

            try {
                con = ds.getConnection();
                pstmt = con.prepareStatement(sql);


                if (i < 11) {
                    pstmt.setString(1, "cust" + i);
                    pstmt.setString(2, "ROLE_CUSTOMER");


                } else {
                    pstmt.setString(1, "dlbm" + i);
                    pstmt.setNString(2, "ROLE_DLBM");
                }
                pstmt.executeUpdate();

            } catch (Exception e) {
                e.printStackTrace();

            } finally {
                if (pstmt != null) {
                    try {
                        pstmt.close();
                    } catch (Exception e) {

                    }
                }

                if (con != null) {
                    try {
                        con.close();
                    } catch (Exception e) {

                    }
                }
            }

        }
    }

    @Test
    public void testReadDolbomUserInfo() {
        DlbmUserVO dlbmUserVO = dlbmUserMapper.readDlbmUserInfo("dlbm11");
        log.info(dlbmUserVO);
        dlbmUserVO.getAuthList().forEach(autoVO -> log.info(autoVO));
    }


    @Test
    public void testInsertAdmin() {
        String sql = "INSERT INTO ADMIN_USER (" +
                "ADMIN_ID, ADMIN_SN, ADMIN_NM, ADMIN_PWD, ADMIN_EMAIL, DEPARTMENT_CD, CREATED_DT, CREATED_BY, LAST_MODIFIED_DT, LAST_MODIFIED_BY) VALUES " +
                "( ?, ADMIN_SN_SEQ.nextval, ?, ?, ?, ?, sysdate, ?, sysdate, ?)";

        for (int i = 1; i <= 20; i++) {
            Connection con = null;
            PreparedStatement pstmt = null;

            try {
                con = ds.getConnection();
                pstmt = con.prepareStatement(sql);

                pstmt.setString(3, pwencoder.encode("pw" + i));
                pstmt.setString(6, "fluid21");
                pstmt.setString(7, "fluid21");

                if (i < 11) {
                    pstmt.setString(1, "#sysadmin" + i);
                    pstmt.setString(2, "시스템관리인" + i);
                    pstmt.setString(4, "sysadminemail" + i + "email.com");
                    pstmt.setString(5, "10");


                } else {
                    pstmt.setString(1, "#manager" + i);
                    pstmt.setString(2, "매니저" + i);
                    pstmt.setString(4, "dlbmmanager" + i + "email.com");
                    pstmt.setString(5, "20");
                }

                pstmt.executeUpdate();

            } catch (Exception e) {
                e.printStackTrace();

            } finally {
                if (pstmt != null) {
                    try {
                        pstmt.close();
                    } catch (Exception e) {

                    }
                }

                if (con != null) {
                    try {
                        con.close();
                    } catch (Exception e) {

                    }
                }
            }

        }
    }


    @Test
    public void testInsertAuth2() {
        String sql = "INSERT INTO ADMIN_USER_AUTH (ADMIN_ID, AUTH) values (?, ?)";

        for (int i = 1; i <= 20; i++) {
            Connection con = null;
            PreparedStatement pstmt = null;

            try {
                con = ds.getConnection();
                pstmt = con.prepareStatement(sql);


                if (i < 11) {
                    pstmt.setString(1, "#sysadmin" + i);
                    pstmt.setString(2, "ROLE_SYSADMIN");


                } else {
                    pstmt.setString(1, "#manager" + i);
                    pstmt.setNString(2, "ROLE_MANAGER");
                }
                pstmt.executeUpdate();

            } catch (Exception e) {
                e.printStackTrace();

            } finally {
                if (pstmt != null) {
                    try {
                        pstmt.close();
                    } catch (Exception e) {

                    }
                }

                if (con != null) {
                    try {
                        con.close();
                    } catch (Exception e) {

                    }
                }
            }

        }
    }

    @Test
    public void testReadAdminUserInfo() {
        AdminUserVO adminUserVO = adminUserMapper.readAdminUserInfo("#sysadmin3");
        log.info(adminUserVO);
        adminUserVO.getAuthList().forEach(authVO -> log.info(authVO));
    }

    @Test
    @DisplayName("돌봄 사용자 등록 테스트")
    public void testRegisterUser() {
        DlbmUserVO dlbmUser = new DlbmUserVO();
        dlbmUser.setUserId("chaehyeong14");
        dlbmUser.setUserPwd(pwencoder.encode("123"));
        dlbmUser.setUserNm("유채형");
        dlbmUser.setUserEmail("fluid15@test.com");
        dlbmUser.setUserPhone("01012345678");
        dlbmUser.setUserTypeCd("10");
        dlbmUser.setCreatedBy("chaehyeong1");
        dlbmUser.setLastModifiedBy("chaehyeong1");
        dlbmUserMapper.registerMemberInfo(dlbmUser);

    }

    @Test
    @DisplayName("돌봄 사용자 권한 등록 테스트")
    public void testRegisterUserAuth() {
        DlbmUserAuthVO authVO = new DlbmUserAuthVO();
        authVO.setUserId("chaehyeong14");
        authVO.setAuth("ROLE_DLBM");
        dlbmUserMapper.registerAuthInfo(authVO);

    }

}