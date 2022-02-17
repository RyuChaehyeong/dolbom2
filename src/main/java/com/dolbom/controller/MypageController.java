package com.dolbom.controller;

import com.dolbom.domain.DlbmVO;
import com.dolbom.domain.QuoteReqVO;
import com.dolbom.domain.auth.DlbmUserVO;
import com.dolbom.service.DlbmService;
import com.dolbom.service.DlbmUserService;
import com.dolbom.service.QuoteService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Controller
@Log4j
@AllArgsConstructor
@RequestMapping("/mypage/*")
public class MypageController {

    private DlbmService dlbmService;
    private QuoteService quoteService;
    private DlbmUserService dlbmUserService;

    @GetMapping("/info")
    public String loadCustPage(@RequestParam String userId, @RequestParam String auth, Model model) {

        log.info("GET MYPAGE - USER ID: " + userId);


        Map<String, List<QuoteReqVO>> map = quoteService.getQuoHist(userId, auth);
        List<QuoteReqVO> cmplQuoList = map.get("cmplList");
        List<QuoteReqVO> prgrQuoList = map.get("prgrList");

        DlbmUserVO userInfo = dlbmUserService.getUserInfo(userId);

        if ("DLBM".equals(auth)) {
            List<DlbmVO> myDlbmList = dlbmService.getmyDlbmHist(userId);
            model.addAttribute("myDlbmList", myDlbmList);
        } else {
            List<DlbmVO> complDlbmList =  dlbmService.getCmplDlbmHist(userId);
            model.addAttribute("complDlbmList", complDlbmList);
        }

        model.addAttribute("userInfo", userInfo);
        model.addAttribute("prgrQuoList", prgrQuoList);
        model.addAttribute("cmplQuoList", cmplQuoList);
        return auth.equals("DLBM")? "/mypage/getDlbmInfo" : "/mypage/getCustInfo";
    }


}
