package com.dolbom.controller;

import com.dolbom.domain.ReviewVO;
import com.dolbom.service.ReviewService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@RequestMapping("/review")
@Log4j
@AllArgsConstructor
@Controller
public class ReviewController {

    private ReviewService reviewService;

    @GetMapping("/getList")
    private @ResponseBody List<ReviewVO> getList(@RequestParam Long srvcId) {
        log.info("REVIEW GETLIST - srvcId : " + srvcId);
        List<ReviewVO> reviewList = reviewService.getList(srvcId);
        return reviewList;
    }

}
