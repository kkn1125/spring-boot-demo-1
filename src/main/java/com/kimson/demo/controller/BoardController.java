package com.kimson.demo.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.kimson.demo.dto.Board;
import com.kimson.demo.service.BoardService;

@RequestMapping("/board")
@RestController
public class BoardController {

	private BoardService service;

	@Autowired
	BoardController(BoardService boardService) {
		this.service = boardService;
	}

	private String mapper(Object object) throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
		return mapper.writeValueAsString(object);
	}

	@GetMapping("")
	public String findAll(@RequestParam HashMap<String, Object> map) throws JsonProcessingException {
//		System.out.println(request.getParameter("test"));
//		System.out.println(request.getAttribute("test"));
		System.out.println(map.toString());
		List<Board> boardList = service.findAll();
		return mapper(boardList);
	}

	@PostMapping("")
	public String create(@RequestParam HashMap<String, Object> wow) {
		System.out.println(wow.toString());
		System.out.println(wow.get("wow"));
		return "done";
	}

}
