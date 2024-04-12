package com.example.user.app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.user.app.data.dto.BoardDto;
import com.example.user.app.frame.HanaService;
import com.example.user.app.repository.BoardRepository;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BoardService implements HanaService<Integer, BoardDto> {
	private final BoardRepository boardRepository;

	@Override
	public int add(BoardDto boardDto) throws Exception {
		return boardRepository.insert(boardDto);
	}

	@Override
	public int del(Integer s) throws Exception {
		return boardRepository.delete(s);
	}

	@Override
	public int modify(BoardDto boardDto) throws Exception {
		return boardRepository.update(boardDto);
	}

	@Override
	public BoardDto get(Integer s) throws Exception {
		return boardRepository.selectOne(s);
	}

	@Override
	public List<BoardDto> get() throws Exception {
		return boardRepository.select();
	}

	public List<BoardDto> getRank() throws Exception {
		return boardRepository.getRank();
	}

	public int cntUpdate(Integer id) throws Exception {
		return boardRepository.cntUpdate(id);
	}

	public Page<BoardDto> getPage(int pageNo) throws Exception {
		PageHelper.startPage(pageNo, 4); // 3: 한화면에 출력되는 개수
		return boardRepository.getPage();
	}
}
