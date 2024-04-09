package com.example.user.app.frame;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

public interface HanaService<K, V> {
	@Transactional
	int add(V v) throws Exception;

	@Transactional
	int del(K k) throws Exception;

	@Transactional
	int modify(V v) throws Exception;

	V get(K k) throws Exception;

	List<V> get() throws Exception;
}
