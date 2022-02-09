package com.dolbom.controller;

import com.dolbom.domain.RequestVO;
import com.dolbom.service.DlbmSrvcService;
import com.dolbom.service.RequestService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
            rttr.addFlashAttribute("result", "success");
        } else {
            rttr.addFlashAttribute("result", "fail");
        }

        rttr.addAttribute("reqId", request.getReqId());
        return "redirect:/request/retrieveRequest";
    }


    @GetMapping("/retrieveRequest")
    public void retrieveRequest(@RequestParam("reqId") Long reqId, Model model) {
        RequestVO req = requestService.retrieveRequest(reqId);
        String srvcNm = srvcService.get(req.getSrvcId()).getSrvcNm();
        model.addAttribute("req", req);
        model.addAttribute("srvcNm", srvcNm);
    }
}
