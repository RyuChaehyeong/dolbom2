package com.dolbom.controller;

import com.dolbom.domain.DlbmVO;
import com.dolbom.domain.QuoteReqVO;
import com.dolbom.domain.ReviewVO;
import com.dolbom.service.DlbmService;
import com.dolbom.service.QuoteService;
import com.dolbom.service.ReviewService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/review")
@Log4j
@AllArgsConstructor
@Controller
public class ReviewController {

    private ReviewService reviewService;

    private QuoteService quoteService;

    private DlbmService dlbmService;

    @GetMapping("/getList")
    public @ResponseBody List<ReviewVO> getList(@RequestParam Long srvcId) {
        log.info("REVIEW GETLIST - srvcId : " + srvcId);
        List<ReviewVO> reviewList = reviewService.getList(srvcId);
        return reviewList;
    }

    @PreAuthorize("hasRole('ROLE_CUSTOMER')")
    @GetMapping("/registerForm")
    public String registerQuotePopup(@RequestParam("reqId") Long reqId, Model model) {

        log.info("REVIEW REGISTER POPUP LOADED - reqId : " + reqId);

        QuoteReqVO quote = quoteService.get(reqId);
        DlbmVO dlbm  =dlbmService.get(quote.getSrvcId());
        String srvcNm = dlbm.getSrvcNm();

        model.addAttribute("quote", quote);
        model.addAttribute("srvcNm", srvcNm);

        return "/review/registerReviewPopup";
    }

    @PreAuthorize("hasRole('ROLE_CUSTOMER')")
    @PostMapping("/register")
    public @ResponseBody ResponseEntity register(@RequestBody ReviewVO review) {
        log.info("REVIEW REGISTER - REQID: " + review.getReqId());

        boolean res = reviewService.register(review);

        return res ? new ResponseEntity<>("success", HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
