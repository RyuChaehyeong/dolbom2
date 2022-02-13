package com.dolbom.controller;

import com.dolbom.domain.QuoteReqVO;
import com.dolbom.service.DlbmService;
import com.dolbom.service.QuoteService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Date;

@RequestMapping("/quote")
@Log4j
@AllArgsConstructor
@Controller
public class QuoteController {

    private QuoteService quoteService;
    private DlbmService srvcService;

    @PostMapping("/register")
    public String register(QuoteReqVO request, RedirectAttributes rttr) {
        log.info("REGISTER REQUEST: " + request);

        int cnt = quoteService.register(request);

        if (cnt == 1) {
            rttr.addFlashAttribute("regiResult", "success");
        } else {
            rttr.addFlashAttribute("regiResult", "fail");
        }

        rttr.addAttribute("reqId", request.getReqId());
        return "redirect:/quote/get";
    }


    @GetMapping("/get")
    public String get(@RequestParam("reqId") Long reqId, Model model) {
        log.info("RETRIEVE REQUEST - REQID: " + reqId );
        QuoteReqVO req = quoteService.get(reqId);
        Date strDt = req.getStartDt();
        Date endDt = req.getEndDt();
        log.info("*******controller:" + strDt);
        log.info("*******controller:" + endDt);
        String srvcNm = srvcService.get(req.getSrvcId()).getSrvcNm();
        model.addAttribute("req", req);
        model.addAttribute("srvcNm", srvcNm);
        return "/quote/getQuote";
    }

    @PostMapping("/modify")
    public String modify(QuoteReqVO request, RedirectAttributes rttr) {
        log.info("MODIFY REQUEST - REQID: " + request.getReqId());
        int cnt = quoteService.modify(request);
        if (cnt == 1) {
            rttr.addFlashAttribute("modiResult", "success");
        } else {
            rttr.addFlashAttribute("modiResult", "fail");
        }
        rttr.addAttribute("reqId", request.getReqId());
        return "redirect:/quote/get";
    }

    @GetMapping("/registerForm")
    public String registerQuotePopup(@RequestParam("srvcId") Long srvcId, Model model) {
        log.info("REQUEST REGISTER POPUP LOADED..");
        String srvcNm = srvcService.get(srvcId).getSrvcNm();
        model.addAttribute("srvcNm", srvcNm);
        return "/quote/registerQuotePopup";
    }


    @PostMapping("/addQuoPrice")
    public String addQuoPrice(QuoteReqVO request, RedirectAttributes rttr) {
        log.info("UPDATE QUOTE PRICE - REQID: " + request.getReqId());
        int cnt = quoteService.addQuoPrice(request);
        if (cnt == 1) {
            rttr.addFlashAttribute("insertPriceResult", "success");
        } else {
            rttr.addFlashAttribute("insertPriceResult", "fail");
        }
        rttr.addAttribute("reqId", request.getReqId());
        return "redirect:/quote/get";
    }

    @PostMapping("/delete")
    public String delete(QuoteReqVO request, RedirectAttributes rttr) {
        log.info("DELETE REQUEST - REQID: " + request.getReqId());
        int cnt = quoteService.delete(request);
        if (cnt == 1) {
            rttr.addFlashAttribute("delReqResult", "success");
        } else {
            rttr.addFlashAttribute("delReqResult", "fail");
        }
        rttr.addAttribute("reqId", request.getReqId());
        return "redirect:/quote/get";
    }
}
