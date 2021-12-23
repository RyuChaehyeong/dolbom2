package com.dolbom.security.auth;

import com.dolbom.domain.auth.DolbomUserVO;
import com.dolbom.mapper.auth.DolbomUserMapper;
import lombok.Setter;
import lombok.extern.log4j.Log4j;
import org.junit.Test;
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
public class DolbomUserTests {

    @Setter(onMethod_ = @Autowired)
    private PasswordEncoder pwencoder;

    @Setter(onMethod_ = @Autowired)
    private DataSource ds;

    @Setter(onMethod_ = @Autowired)
    private DolbomUserMapper mapper;

    @Test
    public void testInsertMember() {
        String sql = "INSERT INTO DOLBOM_USER (USER_ID, USER_PW, USER_NM) VALUES (?, ?, ?)";

        for (int i = 1; i <= 100; i++) {
            Connection con = null;
            PreparedStatement pstmt = null;

            try {
                con = ds.getConnection();
                pstmt = con.prepareStatement(sql);

                pstmt.setString(2, pwencoder.encode("pw" + i));

                if (i < 26) {
                    pstmt.setString(1, "user" + i);
                    pstmt.setString(3, "일반사용자" + i);

                } else if (i < 51) {
                    pstmt.setString(1, "customer" + i);
                    pstmt.setNString(3, "고객" + i);

                } else if (i < 76) {
                    pstmt.setString(1, "member" + i);
                    pstmt.setNString(3, "운영자" + i);

                } else {
                    pstmt.setString(1, "admin" + i);
                    pstmt.setNString(3, "관리자" + i);
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
        String sql = "INSERT INTO DOLBOM_USER_AUTH (USER_ID, AUTH) values (?, ?)";

        for (int i = 1; i <= 100; i++) {
            Connection con = null;
            PreparedStatement pstmt = null;

            try {
                con = ds.getConnection();
                pstmt = con.prepareStatement(sql);


                if (i < 26) {
                    pstmt.setString(1, "user" + i);
                    pstmt.setString(2, "ROLE_USER");

                } else if (i < 51) {
                    pstmt.setString(1, "customer" + i);
                    pstmt.setNString(2, "ROLE_CUSTOMER");

                } else if (i < 76) {
                    pstmt.setString(1, "member" + i);
                    pstmt.setNString(2, "ROLE_MEMBER");

                } else {
                    pstmt.setString(1, "admin" + i);
                    pstmt.setNString(2, "ROLE_ADMIN");
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
        DolbomUserVO dolbomUserVO = mapper.readDolbomUserInfo("admin90");
        log.info(dolbomUserVO);
        dolbomUserVO.getAuthList().forEach(autoVO -> log.info(autoVO));
    }
}