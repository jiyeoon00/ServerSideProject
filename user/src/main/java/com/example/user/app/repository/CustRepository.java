package com.example.user.app.repository;

import org.apache.ibatis.annotations.Mapper;

import com.example.user.app.data.dto.CustDto;
import com.example.user.app.frame.HanaRepository;

@Mapper
public interface CustRepository extends HanaRepository<String, CustDto> {
}
