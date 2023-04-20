package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.example.demo.repository.BoradRepository.JDBCBoardRepository;


@Controller
public class BoardContrioller {
	
	private final JDBCBoardRepository BoardRepository;
	
	@Autowired
	public BoardContrioller(JDBCBoardRepository boardRepository) {
		BoardRepository = boardRepository;
	}
	
	
	
	
	
}
