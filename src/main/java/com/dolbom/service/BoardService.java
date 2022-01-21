package com.dolbom.service;

import com.dolbom.domain.BoardVO;

import java.util.List;

public interface BoardService {

    public void register(BoardVO board);

    public BoardVO get(Long bno);

    public boolean modify(BoardVO board);

    public List<BoardVO> getList();
}
