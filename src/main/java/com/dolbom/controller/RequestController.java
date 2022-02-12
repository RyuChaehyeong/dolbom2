package com.dolbom.controller;

import com.dolbom.domain.RequestVO;
import com.dolbom.service.DlbmSrvcService;
import com.dolbom.service.RequestService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Date;

@RequestMapping("/request")
@Log4j
@AllArgsConstructor
@Controller
public class RequestController {

    private RequestService requestService;
    private DlbmSrvcService srvcService;

    @PostMapping("/registerRequest")
    public String register(RequestVO request, RedirectAttributes rttr) {
        log.info("REGISTER REQUEST: " + request);

        int cnt = requestService.register(request);

        if (cnt == 1) {
            rttr.addFlashAttribute("regiResult", "success");
        } else {
            rttr.addFlashAttribute("regiResult", "fail");
        }

        rttr.addAttribute("reqId", request.getReqId());
        return "redirect:/request/retrieveRequest";
    }


    @GetMapping("/retrieveRequest")
    public void retrieveRequest(@RequestParam("reqId") Long reqId, Model model) {
        log.info("RETRIEVE REQUEST - REQID: " + reqId );
        RequestVO req = requestService.retrieveRequest(reqId);
        Date strDt = req.getStartDt();
        Date endDt = req.getEndDt();
        log.info("*******controller:" + strDt);
        log.info("*******controller:" + endDt);
        String srvcNm = srvcService.get(req.getSrvcId()).getSrvcNm();
        model.addAttribute("req", req);
        model.addAttribute("srvcNm", srvcNm);

    }

    @PostMapping("/modifyRequest")
    public String modifyRequest(RequestVO request, RedirectAttributes rttr) {
        log.info("MODIFY REQUEST - REQID: " + request.getReqId());
        int cnt = requestService.modifyRequest(request);
        if (cnt == 1) {
            rttr.addFlashAttribute("modiResult", "success");
        } else {
            rttr.addFlashAttribute("modiResult", "fail");
        }
        rttr.addAttribute("reqId", request.getReqId());
        return "redirect:/request/retrieveRequest";
    }

    @PreAuthorize("hasRole('ROLE_CUSTOMER')")
    @GetMapping("/registerRequestPopup")
    public void registerRequestPopup(@RequestParam("srvcId") Long srvcId, Model model) {
        log.info("REQUEST REGISTER POPUP LOADED..");
        String srvcNm = srvcService.get(srvcId).getSrvcNm();
        model.addAttribute("srvcNm", srvcNm);
    }


    @PostMapping("/insertQuoPrice")
    public String insertQuoPrice(RequestVO request, RedirectAttributes rttr) {
        log.info("UPDATE QUOTE PRICE - REQID: " + request.getReqId());
        int cnt = requestService.insertQuoPrice(request);
        if (cnt == 1) {
            rttr.addFlashAttribute("insertPriceResult", "success");
        } else {
            rttr.addFlashAttribute("insertPriceResult", "fail");
        }
        rttr.addAttribute("reqId", request.getReqId());
        return "redirect:/request/retrieveRequest";
    }

    @PostMapping("/deleteRequest")
    public String deleteRequest(RequestVO request, RedirectAttributes rttr) {
        log.info("DELETE REQUEST - REQID: " + request.getReqId());
        int cnt = requestService.deleteRequest(request);
        if (cnt == 1) {
            rttr.addFlashAttribute("delReqResult", "success");
        } else {
            rttr.addFlashAttribute("delReqResult", "fail");
        }
        rttr.addAttribute("reqId", request.getReqId());
        return "redirect:/request/retrieveRequest";
    }
}
