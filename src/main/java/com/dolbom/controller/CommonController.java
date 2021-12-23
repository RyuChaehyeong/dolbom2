package com.dolbom.controller;

import lombok.extern.log4j.Log4j;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
@Log4j
public class CommonController {

    @GetMapping("accessError")
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
            model.addAttribute("error", "로그인에 실패하였습니다. 계정을 다시 확인하세요.");
        }

        if (logout != null) {
            model.addAttribute("logout", "로그아웃 되었습니다.");
        }
    }

    @GetMapping("/logout")
    public void logoutGET(HttpServletRequest request) {
        log.info("Logout");
    }
}
