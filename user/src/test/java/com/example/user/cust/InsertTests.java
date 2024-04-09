package com.example.user.cust;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.user.app.data.dto.CustDto;
import com.example.user.app.service.CustService;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
public class InsertTests {

	@Autowired
	CustService custService;

	@Test
	void contextLoads() {
		CustDto custDto = CustDto.builder().id("id79").pwd("pwd77").name("앙").build();
		try {
			custService.add(custDto);
			log.info("----------OK----------------");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
