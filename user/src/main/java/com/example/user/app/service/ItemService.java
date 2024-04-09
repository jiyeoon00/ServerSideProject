package com.example.user.app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.user.app.data.dto.ItemDto;
import com.example.user.app.frame.HanaService;
import com.example.user.app.repository.ItemRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ItemService implements HanaService<Integer, ItemDto> {

	final ItemRepository itemRepository;

	@Override
	public int add(ItemDto itemDto) throws Exception {
		return itemRepository.insert(itemDto);
	}

	@Override
	public int del(Integer s) throws Exception {
		return itemRepository.delete(s);
	}

	@Override
	public int modify(ItemDto itemDto) throws Exception {
		return itemRepository.update(itemDto);
	}

	@Override
	public ItemDto get(Integer s) throws Exception {
		return itemRepository.selectOne(s);
	}

	@Override
	public List<ItemDto> get() throws Exception {
		return itemRepository.select();
	}
}
