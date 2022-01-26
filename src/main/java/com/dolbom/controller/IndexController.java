package com.dolbom.controller;

import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Log4j
public class IndexController {
    @RequestMapping("/service/registerSrvc")
    public void registerDlbmSrv() {
        log.info("SERVICE REGISTER PAGE LOADED..");
    }

    @RequestMapping("/service/retrieveSrvcList")
    public void retrieveSrvcList() {
        log.info("SERVICE LIST PAGE LOADED..");
    }
}
