package com.example.user.cust;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DuplicateKeyException;

import com.example.user.app.data.dto.CustDto;
import com.example.user.app.service.CustService;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
public class SelectTests {
	@Autowired
	CustService custService;

	@Test
	void contextLoads() {
		List<CustDto> list = new ArrayList<>();
		try {
			list = custService.get();
			for(CustDto c: list){
				log.info(c.toString());
			}
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
