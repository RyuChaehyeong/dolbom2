package com.dolbom.controller;

import com.dolbom.domain.DlbmVO;
import com.dolbom.service.DlbmService;
import lombok.Setter;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@Log4j
@RequestMapping("/dlbm/*")
public class DlbmController {

    @Setter(onMethod_ = @Autowired)
    private DlbmService dlbmService;

    @GetMapping("/registerForm")
    public String registerPage() {
        log.info("SERVICE REGISTER PAGE LOADED..");
        return "/dlbm/registerForm";
    }

    @PostMapping("/register")
    public String register(DlbmVO dlbmVO) {
        log.info("SERVICE REGISTER");
        dlbmService.register(dlbmVO);
        return "redirect:/dlbm/getList";
    }

    @RequestMapping("/getList")
    public String getList() {
        log.info("SERVICE LIST PAGE LOADED..");
        return "/dlbm/getDlbmList";
    }

    @GetMapping("/get")
    public String get(@RequestParam("srvcId") Long srvcId, Model model) {
        DlbmVO vo = dlbmService.get(srvcId);
        model.addAttribute("srvc", vo);
        return "/dlbm/getDlbm";
    }
}
