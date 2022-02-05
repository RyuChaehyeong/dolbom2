package com.dolbom.controller;

import com.dolbom.domain.DlbmSrvcVO;
import com.dolbom.service.DlbmSrvcService;
import com.dolbom.service.DlbmSrvcServiceImpl;
import lombok.Setter;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@Log4j
@RequestMapping("/service/*")
public class SrvcIndexController {

    @Setter(onMethod_ = @Autowired)
    private DlbmSrvcService service;

    @RequestMapping("/registerSrvc")
    public void registerDlbmSrv() {
        log.info("SERVICE REGISTER PAGE LOADED..");
    }

    @RequestMapping("/retrieveSrvcList")
    public void retrieveSrvcList() {
        log.info("SERVICE LIST PAGE LOADED..");
    }

    @GetMapping("/retrieveSrvcDetail")
    public void retrieveSrvcDetail(@RequestParam("srvcId") Long srvcId, Model model) {
        DlbmSrvcVO vo = service.get(srvcId);
        model.addAttribute("srvc", vo);
    }

    @RequestMapping("/registerRequestPopup")
    public void registerRequestPopup() {
        log.info("SERVICE REGISTER PAGE LOADED..");
    }
}
