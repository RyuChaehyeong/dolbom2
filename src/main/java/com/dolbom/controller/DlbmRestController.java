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

    @PostMapping(value = "/new",
        consumes = "application/json",
        produces = MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity<String> create(@RequestBody DlbmVO dlbm) {

        log.info("DlbmSrvcVO: " + dlbm);

        int insertCnt = service.register(dlbm);

        log.info("SERVICE INSERT COUNT: " + insertCnt);

        return insertCnt == 1 ? new ResponseEntity<>("Servie Resgister Success", HttpStatus.OK) : new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping(value = "/{srvcId}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<DlbmVO> get(@PathVariable("srvcId") Long srvcId) {

        log.info("SERVICE READ SERVICE ID: " +  srvcId );

        return new ResponseEntity<>(service.get(srvcId), HttpStatus.OK);

    }

    @PutMapping(value = "/delete/{srvcId}",
            consumes = "application/json",
            produces = MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity<String> delete(@PathVariable("srvcId") Long srvcId) {

        log.info("SERVICE DELETE SERVICE ID: " + srvcId);

        return service.delete(srvcId) ? new ResponseEntity<>("Service Delete Success", HttpStatus.OK) : new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);


    }

    @GetMapping(value = "/getList" ,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<DlbmVO>> getSrvcList(Model model) {
        List<DlbmVO> srvcList = service.getList();
        return new ResponseEntity<>(service.getList(), HttpStatus.OK);
    }



}
