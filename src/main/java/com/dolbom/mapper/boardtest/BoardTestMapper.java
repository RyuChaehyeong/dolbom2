package com.dolbom.mapper.boardtest;

import com.dolbom.domain.boardtest.BoardTestVO;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface BoardTestMapper {

    //@Select("SELECT * FROM BOARD_TEST WHERE BOARD_NUM > 0")
    List<BoardTestVO> getList();
}
