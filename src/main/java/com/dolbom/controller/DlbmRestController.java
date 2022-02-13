package com.dolbom.controller;

import com.dolbom.domain.DlbmVO;
import com.dolbom.service.DlbmService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/service/")
@RestController
@Log4j
@AllArgsConstructor
public class DlbmRestController {

    private DlbmService service;

    @GetMapping(value = "/getList" ,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<DlbmVO>> getSrvcList(Model model) {
        List<DlbmVO> srvcList = service.getList();
        return new ResponseEntity<>(service.getList(), HttpStatus.OK);
    }



}
