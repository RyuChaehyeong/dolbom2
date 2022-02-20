package com.dolbom.controller;

import com.dolbom.domain.QuoteReqVO;
import com.dolbom.service.DlbmService;
import com.dolbom.service.QuoteService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@RequestMapping("/quote")
@Log4j
@AllArgsConstructor
@Controller
public class QuoteController {

    private QuoteService quoteService;
    private DlbmService dlbmService;

    @PreAuthorize("hasAnyRole('ROLE_CUSTOMER')")
    @GetMapping("/registerForm")
    public String registerQuotePopup(@RequestParam("srvcId") Long srvcId, Model model) {
        log.info("REQUEST REGISTER POPUP LOADED..");

        String srvcNm = dlbmService.get(srvcId).getSrvcNm();
        model.addAttribute("srvcNm", srvcNm);

        return "/quote/registerQuotePopup";
    }

    @PreAuthorize("hasAnyRole('ROLE_CUSTOMER')")
    @PostMapping("/register")
    public String register(QuoteReqVO quote, RedirectAttributes rttr) {
        log.info("REGISTER REQUEST: " + quote);

        int cnt = quoteService.register(quote);

        if (cnt == 1) {
            rttr.addFlashAttribute("regiResult", "success");
        } else {
            rttr.addFlashAttribute("regiResult", "fail");
        }

        rttr.addAttribute("reqId", quote.getReqId());
        return "redirect:/quote/get";
    }


    @GetMapping("/get")
    public String get(@RequestParam("reqId") Long reqId,  Model model) {
        log.info("RETRIEVE REQUEST - REQID: " + reqId );

        QuoteReqVO req = quoteService.get(reqId);
        String srvcNm = dlbmService.get(req.getSrvcId()).getSrvcNm();

        model.addAttribute("req", req);
        model.addAttribute("srvcNm", srvcNm);

        return "/quote/getQuote";
    }

    @PostMapping ("/modify")
    public @ResponseBody ResponseEntity modify(@RequestBody QuoteReqVO quote) {
        log.info("MODIFY REQUEST - REQID: " + quote.getReqId());

        int cnt = quoteService.modify(quote);

        return cnt == 1
                ? new ResponseEntity<>("success", HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }


    @PostMapping("/addQuoPrice")
    public @ResponseBody ResponseEntity addQuoPrice(@RequestBody QuoteReqVO quote) {
        log.info("UPDATE QUOTE PRICE - REQID: " + quote.getReqId());

        int cnt = quoteService.addQuoPrice(quote);

        return cnt == 1
                ? new ResponseEntity<>("success", HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @PostMapping("/acceptQuo")
    public @ResponseBody ResponseEntity acceptQuo(@RequestBody QuoteReqVO quote) {
        log.info("CUST ACCEPT QUOTE PRICE - REQID: " + quote.getReqId());

        int cnt = quoteService.acceptQuo(quote);

        return cnt == 1
                ? new ResponseEntity<>("success", HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @PostMapping("/signQuo")
    public @ResponseBody ResponseEntity signQuo(@RequestBody QuoteReqVO quote) {
        log.info("DLBM SIGN QUOTE - REQID: " + quote.getReqId());
        int signRes = quoteService.signQuo(quote);

        log.info("UPDATE SRVC USAGE CNT - SRVCID: " + quote.getSrvcId());
        int upRes = dlbmService.upCnt(quote.getSrvcId());

        return signRes == 1 && upRes == 1
                ? new ResponseEntity<>("success", HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @PostMapping("/delete")
    public @ResponseBody ResponseEntity delete(@RequestBody QuoteReqVO request) {
        log.info("DELETE REQUEST - REQID: " + request.getReqId());
        int cnt = quoteService.delete(request);

        return cnt == 1
                ? new ResponseEntity<>("success", HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @PostMapping("/upView")
    public @ResponseBody ResponseEntity upView(@RequestParam String reqId) {
        log.info("DLBM VIEW QUOTE REQ - REQID : " + reqId);

        int cnt = quoteService.upView(reqId);

        return cnt == 1
                ? new ResponseEntity<>("success", HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
