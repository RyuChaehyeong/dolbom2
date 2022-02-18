package com.dolbom.service;

import com.dolbom.domain.ReviewVO;
import com.dolbom.mapper.DlbmMapper;
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

    @Setter(onMethod_ = @Autowired)
    private DlbmMapper dlbmMapper;

    @Override
    public List<ReviewVO> getList(Long srvcId) {
        return reviewMapper.getList(srvcId);
    }

    @Override
    public boolean register(ReviewVO review) {

        String custId = review.getCustId();
        review.setCreatedBy(custId);
        review.setLastModifiedBy(custId);

        //상태코드 업데이트
        quoteMapper.registReview(review.getReqId() ,custId);
        //리뷰등록
        int regiRes = reviewMapper.register(review);
        //서비스 평점 업데이트
        int rateRes = dlbmMapper.updateRate(review.getSrvcId());

        return regiRes == 1 && rateRes == 1 ? true : false;
    }
}
