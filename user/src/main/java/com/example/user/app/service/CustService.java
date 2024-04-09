package com.example.user.app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.user.app.data.dto.CustDto;
import com.example.user.app.frame.HanaService;
import com.example.user.app.repository.CustRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CustService implements HanaService<String, CustDto> {

	private final CustRepository custRepository;

	@Override
	public int add(CustDto custDto) throws Exception {
		return custRepository.insert(custDto);
	}

	@Override
	public int del(String s) throws Exception {
		return custRepository.delete(s);
	}

	@Override
	public int modify(CustDto custDto) throws Exception {
		return custRepository.update(custDto);
	}

	@Override
	public CustDto get(String s) throws Exception {
		return custRepository.selectOne(s);
	}

	@Override
	public List<CustDto> get() throws Exception {
		return custRepository.select();
	}
}
