package com.dolbom.service;

import com.dolbom.domain.ReviewVO;

import java.util.List;

public interface ReviewService {

    List<ReviewVO> getList(Long srvcId);

    int register(ReviewVO review);
}
