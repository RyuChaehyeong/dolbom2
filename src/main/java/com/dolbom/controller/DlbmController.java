package com.dolbom.controller;

import com.dolbom.domain.Criteria;
import com.dolbom.domain.DlbmVO;
import com.dolbom.domain.PageDTO;
import com.dolbom.domain.QuoteReqVO;
import com.dolbom.service.DlbmService;
import lombok.Setter;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@Log4j
@RequestMapping("/dlbm/*")
public class DlbmController {

    @Setter(onMethod_ = @Autowired)
    private DlbmService dlbmService;

    @PreAuthorize("hasRole('ROLE_DLBM')")
    @GetMapping("/registerForm")
    public String registerPage() {
        log.info("SERVICE REGISTER PAGE LOADED..");
        return "/dlbm/registerForm";
    }

    @PreAuthorize("hasRole('ROLE_DLBM')")
    @PostMapping("/register")
    public String register(DlbmVO dlbm, RedirectAttributes rttr) {
        log.info("SERVICE REGISTER- SRVC ID: " + dlbm.getSrvcId());
        int cnt = dlbmService.register(dlbm);
        if (cnt == 1) {
            rttr.addFlashAttribute("regiResult", "success");
        } else {
            rttr.addFlashAttribute("regiResult", "fail");
        }

        rttr.addAttribute("srvcId", dlbm.getSrvcId());
        return "redirect:/dlbm/get";
    }

    @RequestMapping("/getList")
    public String getList(Criteria cri, Model model) {
        log.info("SERVICE LIST PAGE LOADED..");
        log.info("list: " + cri);

        List<DlbmVO> list = dlbmService.getList(cri);
        int total = dlbmService.getTotalCnt(cri);

        model.addAttribute("dlbmList", list);
        model.addAttribute("pageMaker", new PageDTO(cri, total));

        return "/dlbm/getDlbmList";
    }

    @GetMapping("/get")
    public String get(@RequestParam("srvcId") Long srvcId, @ModelAttribute("cri") Criteria cri, Model model) {
        log.info("GET SERVICE: " +srvcId);
        DlbmVO vo = dlbmService.get(srvcId);
        model.addAttribute("srvc", vo);
        return "/dlbm/getDlbm";
    }

    @PostMapping ("/modify")
    public @ResponseBody
    ResponseEntity modify(@RequestBody DlbmVO dlbm) {
        log.info("MODIFY DLBM SERVICE - SRVC ID: " + dlbm.getSrvcId());

        int cnt = dlbmService.modify(dlbm);

        return cnt == 1
                ? new ResponseEntity<>("success", HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @PostMapping("/delete")
    public @ResponseBody ResponseEntity delete(@RequestBody DlbmVO dlbm) {
        log.info("DELETE SERVICE - SRVC ID: " + dlbm.getSrvcId());
        int cnt = dlbmService.delete(dlbm);

        return cnt == 1
                ? new ResponseEntity<>("success", HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
