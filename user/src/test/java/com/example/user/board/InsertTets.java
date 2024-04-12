package com.example.user.board;

import java.sql.SQLException;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DuplicateKeyException;

import com.example.user.app.data.dto.BoardDto;
import com.example.user.app.service.BoardService;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
public class InsertTets {
	@Autowired
	BoardService boardService;
	@Test
	void contextLoads() {
		BoardDto boardDto = BoardDto.builder().custId("11").boardTitle("제목1").
			boardContent("내용1").build();
		try {
			boardService.add(boardDto);
			log.info("----------OK----------------");
		} catch (Exception e) {
			if(e instanceof SQLException){
				log.info("----------System Trouble EX0001----------------");
			}else if(e instanceof DuplicateKeyException){
				log.info("----------ID Duplicated EX0002----------------");
			}else{
				log.info("----------Sorry EX0003----------------");
			}

		}
	}
}
