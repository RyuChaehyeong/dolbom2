package com.dolbom.service;

import com.dolbom.domain.ReviewVO;
import com.dolbom.mapper.ReviewMapper;
import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Log4j
@Service
@AllArgsConstructor
public class ReviewServiceImpl implements ReviewService {

    @Setter(onMethod_ = @Autowired)
    private ReviewMapper reviewMapper;

    @Override
    public List<ReviewVO> getList(Long srvcId) {
        return reviewMapper.getList(srvcId);
    }
}
