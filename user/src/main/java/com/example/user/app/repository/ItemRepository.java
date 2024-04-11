package com.example.user.app.repository;

import org.apache.ibatis.annotations.Mapper;

import com.example.user.app.frame.HanaRepository;
import com.example.user.app.data.dto.ItemDto;

@Mapper
public interface ItemRepository extends HanaRepository<Integer, ItemDto> {
}

