package com.dolbom.service;

import com.dolbom.domain.ReviewVO;
import com.dolbom.mapper.QuoteMapper;
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

    @Setter(onMethod_ = @Autowired)
    private QuoteMapper quoteMapper;

    @Override
    public List<ReviewVO> getList(Long srvcId) {
        return reviewMapper.getList(srvcId);
    }

    @Override
    public int register(ReviewVO review) {

        String custId = review.getCustId();
        review.setCreatedBy(custId);
        review.setLastModifiedBy(custId);

        quoteMapper.registReview(review.getReqId() ,custId);

        return reviewMapper.register(review);
    }
}
