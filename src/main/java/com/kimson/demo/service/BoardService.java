package com.kimson.demo.service;

import java.util.List;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.kimson.demo.dto.Board;
import com.kimson.demo.mapper.BoardMapper;

@Service
public class BoardService implements ServiceImpl<Board> {

	@Autowired
	private BoardMapper mapper;

	@Override
	public List<Board> findAll() {
		// TODO Auto-generated method stub
		List<Board> boardList = mapper.findAll();
		return boardList;
	}

	@Override
	public Board create(Board board) {
		// TODO Auto-generated method stub
		mapper.create(board);
		int pk = board.getId();
		System.out.println(pk);
		return board;
	}

}
