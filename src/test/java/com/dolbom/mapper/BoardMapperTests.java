package com.dolbom.mapper;

import com.dolbom.domain.BoardVO;
import com.dolbom.mapper.boardtest.BoardTestMapper;
import lombok.Setter;
import lombok.extern.log4j.Log4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardMapperTests {

    @Setter(onMethod_ = @Autowired)
    private BoardMapper mapper;

    @Test
    public void testGetList() {
        mapper.getList().forEach(board -> log.info(board));
    }

    @Test
    public void testInsert() {

        BoardVO board = new BoardVO();
        board.setTitle("새로 작성하는 글");
        board.setContent("새로 작성하는 내용");
        board.setWriter("tester");
        mapper.insert(board);
        log.info(board);
    }

    @Test
    public void testInsertSelectKey() {

        BoardVO board = new BoardVO();
        board.setTitle("새로 작성하는 글 select key");
        board.setContent("새로 작성하는 내용 select key");
        board.setWriter("tester");
        mapper.insertSelectKey(board);
        log.info(board);
    }

    @Test
    public void testRead() {
        BoardVO boardVO = mapper.read(38L);
        log.info(boardVO);
    }

    @Test
    public void testUpdate() {
        BoardVO board = mapper.read(38L);
        board.setTitle("수정된 제목");
        board.setContent("수정된 내용");

        int cnt = mapper.update(board);
        log.info("UPDATE COUNT: " + cnt);
    }

}
