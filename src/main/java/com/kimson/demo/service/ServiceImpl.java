package com.kimson.demo.service;

import java.util.List;

public interface ServiceImpl<T> {
	List<T> findAll();
	T create(T t);

}
