package com.dolbom.controller;

import com.dolbom.domain.auth.DlbmUserAuthVO;
import com.dolbom.domain.auth.DlbmUserVO;
import com.dolbom.service.DlbmUserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@Log4j
@AllArgsConstructor
@RequestMapping("/member/*")
public class DlbmUserController {

    @Setter(onMethod_ = @Autowired)
    private DlbmUserService dlbmUserService;

    @GetMapping("/register")
    public String register() {
        return "/member/registerUser";
    }

    @PostMapping("/register")
    public @ResponseBody
    ResponseEntity register(@RequestBody Map<String, Object> data) {
        ObjectMapper mapper = new ObjectMapper();
        DlbmUserVO dlbmUser = mapper.convertValue(data.get("memInfo"), DlbmUserVO.class);

        boolean res  = dlbmUserService.register(dlbmUser);

        log.info("MEMBER REGISTRATION - userID: " + dlbmUser.getUserId());
        return res
                ? new ResponseEntity<>("success", HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping("/checkId")
    public @ResponseBody String checkId(@RequestParam("id") String id) {
        String result = dlbmUserService.checkId(id);
        log.info("CHECK REPETITIVE ID: " + id);
        return result;
    }

    @GetMapping("/checkEmail")
    public @ResponseBody String checkEmail(@RequestParam("email") String email) {
        String result = dlbmUserService.checkEmail(email);
        log.info("CHECK REPETITIVE EMAIL: " + email);
        return result;
    }

}
