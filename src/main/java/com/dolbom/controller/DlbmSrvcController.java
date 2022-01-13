package com.dolbom.controller;

import com.dolbom.domain.DlbmSrvceVO;
import com.dolbom.service.DlbmSrvcService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/service/")
@RestController
@Log4j
@AllArgsConstructor
public class DlbmSrvcController {

    private DlbmSrvcService dlbmSrvcService;

    @PostMapping(value = "/new",
        consumes = "application/json",
        produces = MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity<String> create(@RequestBody DlbmSrvceVO dlbmSrvceVO) {

        log.info("DlbmSrvcVO: " + dlbmSrvceVO);

        int insertCnt = dlbmSrvcService.register(dlbmSrvceVO);

        log.info("SERVICE INSERT COUNT: " + insertCnt);

        return insertCnt == 1 ? new ResponseEntity<>("Servie Resgister Success", HttpStatus.OK) : new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping(value = "/{srvcId}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<DlbmSrvceVO> get(@PathVariable("srvcId") Long srvcId) {

        log.info("SERVICE READ SERVICE ID: " +  srvcId );

        return new ResponseEntity<>(dlbmSrvcService.get(srvcId), HttpStatus.OK);

    }

    @PutMapping(value = "/delete/{srvcId}",
            consumes = "application/json",
            produces = MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity<String> delete(@PathVariable("srvcId") Long srvcId) {

        log.info("SERVICE DELETE SERVICE ID: " + srvcId);

        return dlbmSrvcService.remove(srvcId) ? new ResponseEntity<>("Service Delete Success", HttpStatus.OK) : new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);


    }
}