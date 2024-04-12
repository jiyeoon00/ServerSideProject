package com.example.user.app.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.user.app.data.dto.BoardDto;
import com.example.user.app.frame.HanaRepository;
import com.github.pagehelper.Page;

@Mapper
public interface BoardRepository extends HanaRepository<Integer, BoardDto> {
	int cntUpdate(Integer id) throws Exception;
	List<BoardDto> getRank() throws Exception;
	Page<BoardDto> getPage();
}
