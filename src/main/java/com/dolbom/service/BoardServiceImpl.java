package com.dolbom.service;

import com.dolbom.domain.BoardVO;
import com.dolbom.mapper.BoardMapper;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Log4j
@Service
@AllArgsConstructor
public class BoardServiceImpl implements BoardService{

    private BoardMapper mapper;

    @Override
    public void register(BoardVO board) {
        log.info("register..." + board);
        mapper.insertSelectKey(board);
    }

    @Override
    public BoardVO get(Long bno) {
        log.info("get...." + bno);
        return mapper.read(38L);
    }

    @Override
    public boolean modify(BoardVO board) {
        log.info("modify..." + board);
        return mapper.update(board) == 1;
    }

    @Override
    public List<BoardVO> getList() {
        log.info("getList....");
        return mapper.getList();
    }
}
