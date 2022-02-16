package com.dolbom.mapper;

import com.dolbom.domain.ReviewVO;

import java.util.List;

public interface ReviewMapper {

    List<ReviewVO> getList(Long srvcId);

    int register(ReviewVO review);
}
