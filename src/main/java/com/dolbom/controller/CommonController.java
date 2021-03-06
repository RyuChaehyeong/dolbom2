package com.dolbom.controller;

import com.dolbom.domain.CodeVO;
import com.dolbom.domain.ReviewVO;
import com.dolbom.service.CommonService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Log4j
@AllArgsConstructor
@Controller
public class CommonController {

    private CommonService commonService;

    @GetMapping("/accessError")
    public void accessDenied(Authentication auth, Model model) {
        log.info("Access Denied: " + auth);
        model.addAttribute("msg: " + "Access Denied");
    }

    @RequestMapping("/login")
    public void loginInput(String error, String logout, Model model, HttpServletRequest request) {

        String referrer = request.getHeader("Referer");
        request.getSession().setAttribute("prevPage", referrer);

        log.info("error: " + error);
        log.info("logout: " + logout);

        if (error != null) {
            model.addAttribute("error", "아이디와 비밀번호를 다시 확인해주세요.");
        }

        if (logout != null) {
            model.addAttribute("logout", "로그아웃 되었습니다.");
        }
    }

    @GetMapping("/logout")
    public void logoutGET(HttpServletRequest request) {
        log.info("Logout");
    }

    @GetMapping("/getCode")
    public @ResponseBody
    List<CodeVO> getCode(@RequestParam String cdGroupId) {
        log.info("CODE GETLIST - cdGroupId : " + cdGroupId);
        List<CodeVO> codeList = commonService.getCode(cdGroupId);
        return codeList;
    }

}
