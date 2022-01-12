package com.dolbom.controller;

import com.dolbom.domain.Ticket;
import com.dolbom.domain.boardtest.RestSampleVO;
import lombok.extern.log4j.Log4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@RestController
@RequestMapping("/sample")
@Log4j
public class RestSampleController {

    @GetMapping(value = "/getText", produces = "text/plan; charset=UTF-8")
    public String getText() {
        log.info("MIME TYPE: " + MediaType.TEXT_PLAIN_VALUE);
        return "안녕하세요.";
    }

    @GetMapping(value = "/getSample", produces = {MediaType.APPLICATION_JSON_VALUE,
                                                    MediaType.APPLICATION_XML_VALUE})
    public RestSampleVO getSample() {
        return new RestSampleVO(96, "채형", "유");
    }

    @GetMapping(value = "/getList", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<RestSampleVO> getList() {

        return IntStream.range(1, 20).mapToObj(i -> new RestSampleVO(i, i+"first", i+"last"))
                .collect(Collectors.toList());
    }

    @GetMapping(value = "/getMap")
    public Map<String, RestSampleVO> getMap() {
        Map<String, RestSampleVO> map = new HashMap<>();
        map.put("First", new RestSampleVO(96, "채형", "유"));
        return map;
    }

    @GetMapping(value = "/check", params = {"height", "weight"})
    public ResponseEntity<RestSampleVO> check(Double height, Double weight) {
        RestSampleVO rvo = new RestSampleVO(0, ""+height , ""+weight);
        ResponseEntity<RestSampleVO> result = null;

        if (height < 150) {
            result = ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(rvo);
        } else {
            result = ResponseEntity.status(HttpStatus.OK).body(rvo);
        }

        return result;
    }

    @GetMapping("/product/{cat}/{pid}")
    public String[] getPath(@PathVariable("cat") String cat, @PathVariable("pid") Integer pid) {

        return new String[] {"category: " + cat, "productId: " + pid};

    }

    @PostMapping(value="/ticket")
    public Ticket convert(@RequestBody Ticket ticket) {
        log.info("convert...ticket" + ticket);
        return ticket;
    }


}
