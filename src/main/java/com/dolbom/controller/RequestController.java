package com.dolbom.controller;

import com.dolbom.domain.RequestVO;
import com.dolbom.service.RequestService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.HashMap;
import java.util.Map;

@RequestMapping("/request")
@Log4j
@AllArgsConstructor
@Controller
public class RequestController {

    private RequestService service;

    @PostMapping("/registerRequest")
    public String register(RequestVO request, RedirectAttributes rttr) {
        log.info("REGISTER REQUEST: " + request);

        int cnt = service.register(request);

        if (cnt == 1) {
            rttr.addFlashAttribute("result", "success");
        } else {
            rttr.addFlashAttribute("result", "fail");
        }
        return "redirect:/request/retrieveRequest?reqId" + request.getReqId();
    }


    @GetMapping("/retrieveRequest")
    public void retrieveRequest(@RequestParam("reqId") Long reqId, Model model) {
        RequestVO req = service.retrieveRequest(reqId);
        model.addAttribute("req", req);
    }
}
