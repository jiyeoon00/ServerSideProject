package com.example.user.app.repository;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.example.user.app.data.dto.ItemDto;
import com.example.user.app.frame.HanaRepository;

@Mapper
public interface ItemRepository extends HanaRepository<Integer, ItemDto> {
}
