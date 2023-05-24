package com.kimson.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import com.kimson.demo.dto.Board;

@Mapper
public interface BoardMapper {
	@Select("SELECT * FROM board")
	List<Board> findAll();

	@Options(useGeneratedKeys = true)
	@Insert("INSERT INTO board (title, content) VALUES (#{title}, #{content})")
	Board create(Board board);
}
